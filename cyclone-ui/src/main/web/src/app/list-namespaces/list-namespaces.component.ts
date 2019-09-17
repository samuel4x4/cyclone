import { Component, OnInit } from '@angular/core';
import { Namespace } from './../shared/models/namespace';
import { NamespaceComponent } from './../namespace/namespace.component';
import { RouterModule, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-list-namespaces',
  templateUrl: './list-namespaces.component.html',
  styleUrls: ['./list-namespaces.component.scss']
})
export class ListNamespacesComponent implements OnInit {
  queryParams: any;
  showTemplate = true;
  namespaces: Namespace[] = [
    {
      title: 'Dev',
      description:
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s',
      icon: 'developer_mode'
    },
    {
      title: 'Prod',
      description:
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s',
      icon: 'storage'
    },
    {
      title: 'Prod qualif',
      description:
        'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s',
      icon: 'pages'
    }
  ];

  constructor(private activatedRoute: ActivatedRoute) {
    activatedRoute.queryParamMap.subscribe(queryParams => {
      this.queryParams = queryParams;

      if (Object.keys(this.queryParams.params).length > 0) {
        this.showTemplate = false;
      } else {
        this.showTemplate = true;
      }
    });
  }

  ngOnInit() {}
}
