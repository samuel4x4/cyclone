pipeline {
    agent {
        docker {
            label 'docker'
            image 'maven:3.6.1-jdk-8'
            args '-v $HOME/.m2:/home/jenkins/.m2 --cap-add=ALL'
        }
    }

    triggers {
        cron('H 00 * * 1-5')
    }

    options {
        timeout(time: 60, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }

    parameters {
        string(name: 'branch', defaultValue: 'develop', description: 'name of the git branch')
    }

    stages {

        stage('checkout') {
            steps {
                script {
                    git branch: '$branch',
                            url: 'https://github.com/bogdan-pistol/cyclone'
                }
            }
        }

        stage('build') {
            steps {
                script {
                    sh 'export PATH=$MVN_CMD_DIR:$PATH && mvn clean package'
                }
            }
        }

        stage('docker build push'){
            steps {
                script {
                    docker.withRegistry('', '') {
                        TAG_VERSION = 'new_version'
                        def cyclone_image = docker.build("cyclone:${TAG_VERSION}", "--no-cache -f cyclone-server/Dockerfile ./cyclone-server")
                        cyclone_image.push()
                        cyclone_image.push(TAG_VERSION)
                    }
                }
            }
        }

        stage('deploy'){
            //TODO
        }

    }

}