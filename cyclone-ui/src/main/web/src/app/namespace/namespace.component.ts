import { Component, OnInit, Input } from '@angular/core';
import { Namespace } from './../shared/models/namespace';
@Component({
  selector: 'app-namespace',
  templateUrl: './namespace.component.html',
  styleUrls: ['./namespace.component.scss']
})
export class NamespaceComponent implements OnInit {
  @Input() namespace: Namespace;
  constructor() {}

  ngOnInit() {}
}
