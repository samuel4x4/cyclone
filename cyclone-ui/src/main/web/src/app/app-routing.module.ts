import { ListNamespacesComponent } from './list-namespaces/list-namespaces.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListCountriesComponent } from './list-countries/list-countries.component';
import { ListConfigComponent } from './list-config/list-config.component';
const routes: Routes = [
  {
    path: 'namespaces',
    component: ListNamespacesComponent,
    children: [
      {
        path: ':id',
        component: ListCountriesComponent,
        children: [
          {
            path: ':id',
            component: ListConfigComponent
          }
        ]
      }
    ]
  },
  {
    path: 'home',
    redirectTo: 'namespaces'
  },
  {
    path: 'countries',
    component: ListCountriesComponent
  },
  {
    path: 'list-config',
    component: ListConfigComponent
  },
  {
    path: '**',
    redirectTo: 'namespaces'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
