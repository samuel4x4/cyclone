import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { LeftMenuComponent } from './left-menu/left-menu.component';
import { MaterialModule } from './shared/material.module';
import { CountryComponent } from './country/country.component';
import { ListCountriesComponent } from './list-countries/list-countries.component';
import { NamespaceComponent } from './namespace/namespace.component';
import { ListNamespacesComponent } from './list-namespaces/list-namespaces.component';
import { ListConfigComponent } from './list-config/list-config.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgBoostedModule } from 'ng-boosted';
import { StepsComponent } from './steps/steps.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LeftMenuComponent,
    CountryComponent,
    ListCountriesComponent,
    NamespaceComponent,
    ListNamespacesComponent,
    ListConfigComponent,
    StepsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MaterialModule,
    NgbModule,
    NgBoostedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
