package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.models.constants.FileFormat;
import com.ruby.cyclone.configserver.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/namespaces/{namespace}/countries/{country}")
public class FilesController {


    private FileService fileService;

    @Autowired
    public FilesController() {
    }

    @GetMapping("/files")
    public List<String> getFiles(@PathVariable String namespace, @PathVariable String business) {
        return this.fileService.getFiles(namespace, business);
    }

    @PostMapping("/files")
    public String importPropertiesFromFile(@PathVariable String namespace,
                                           @PathVariable String business,
                                           @RequestParam FileFormat fileFormat,
                                           @RequestBody MultipartFile file) {
        return this.fileService.importProperties(namespace, business, fileFormat, file);
    }


    @GetMapping("/files/export/{filename}")
    public void exportFileByName(@PathVariable String namespace,
                                 @PathVariable String business,
                                 @PathVariable String filename) {
        fileService.exportFile(namespace, business, filename);
    }

    @GetMapping("/files/{file}/properties")
    public Map<String, Object> listProperties(@PathVariable String namespace,
                                              @PathVariable String business,
                                              @PathVariable String file) {
        return fileService.getPropertiesFromFile(namespace, business, file);

    }

}
