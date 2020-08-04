import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-api',
  templateUrl: './api.component.html',
  styleUrls: ['./api.component.css']
})
export class ApiComponent implements OnInit {

  constructor(private apiService: ApiService) { }

  ngOnInit() {

    this.apiService.getRestaurants().subscribe(
      (response => {
        if (response !== null) {
          console.log(JSON.stringify(response));
        }
      }),
      (error => {
        alert(error.error.message);
      })
    );
  }



}
