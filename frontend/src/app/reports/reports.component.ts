import { Component, OnInit } from '@angular/core';
import { RatingRangeDTO } from '../dto/rating-range-dto';
import { RestaurantService } from '../service/restaurant.service';
import { Router } from '@angular/router';
import { RestaurantDto } from '../dto/restaurant-dto';
import { ConstantsService } from '../service/constants.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

  private from: number;
  private to: number;
  private showResult: boolean;
  private restaurants: RestaurantDto[];


  constructor( private restaurantService: RestaurantService, private router: Router, private constants: ConstantsService ) { }

  ngOnInit() {
    this.from = 0;
    this.to = 0;
    this.showResult = false;
  }

  getRestaurants() {
    const dto = new  RatingRangeDTO(this.from, this.to);
    this.restaurantService.getRestaurantsByRatingRange(dto).subscribe(
      (response => {
        if (response !== null) {
          this.restaurants = response;
          this.showResult = true;
        }
      }),
      (error => {
        alert(error.error.message);
      })
    );
  }

  getPicture(picture: string): string {
    return this.constants.localhost + picture;
  }

}
