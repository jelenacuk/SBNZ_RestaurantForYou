import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { DissatisfiedUserDto } from 'src/app/dto/dissatisfied-users-dto';

@Component({
  selector: 'app-reports-page',
  templateUrl: './reports-page.component.html',
  styleUrls: ['./reports-page.component.css']
})
export class ReportsPageComponent implements OnInit {

  mostRecommended: RestaurantDto;
  leastRecommended: RestaurantDto;
  dissatisfiedUsers: DissatisfiedUserDto[];
  numOfMonths: number;

  constructor( private restaurantService: RestaurantService) { }

  ngOnInit() {
    this.numOfMonths = 2;
    this.getStatistic();
  }

  getStatistic() {
    this.restaurantService.getStatistic(this.numOfMonths).subscribe(
      (response => {
        if (response != null) {
          this.mostRecommended = response.mostRecommended;
          this.leastRecommended = response.leastRecommended;
          this.dissatisfiedUsers = response.dissatisfiedUsers;
        }
      }),
      (error => {
        alert(error.error.message);
      })
    );
  }

}
