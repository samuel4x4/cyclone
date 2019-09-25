import { Component, OnInit } from '@angular/core';
import { CountryComponent } from './../country/country.component';
import { Country } from './../shared/models/country-model';
import { RouterModule, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-list-countries',
  templateUrl: './list-countries.component.html',
  styleUrls: ['./list-countries.component.scss']
})
export class ListCountriesComponent implements OnInit {
  queryParams: any;
  showTemplate = true;
  countries: Country[] = [
    { id: 'ro', name: 'Romania' },
    { id: 'es', name: 'Spain' },
    { id: 'fr', name: 'France' },
    { id: 'gb', name: 'Great Britain' },
    { id: 'pl', name: 'Poland' },
    { id: 'be', name: 'Belgium' },
    { id: 'md', name: 'Moldova' },
    { id: 'sk', name: 'Slovakia' },
    { id: 'lu', name: 'Luxembourg' }
  ];

  constructor(private activatedRoute: ActivatedRoute) {
    activatedRoute.queryParamMap.subscribe(queryParams => {
      this.queryParams = queryParams;

      if (Object.keys(this.queryParams.params).length > 1) {
        this.showTemplate = false;
      } else {
        this.showTemplate = true;
      }
    });
  }

  ngOnInit() {}
}
