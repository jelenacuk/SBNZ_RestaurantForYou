import { Component, OnInit } from '@angular/core';
import { RatingRangeDTO } from 'src/app/dto/rating-range-dto';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { Router } from '@angular/router';
import { ConstantsService } from 'src/app/service/constants.service';

@Component({
  selector: 'app-rating-range',
  templateUrl: './rating-range.component.html',
  styleUrls: ['./rating-range.component.css']
})
export class RatingRangeComponent implements OnInit {

  private from: number;
  private to: number;
  private showResult: boolean;
  private restaurants: RestaurantDto[];


  constructor( private restaurantService: RestaurantService, private router: Router, private constants: ConstantsService ) { }

  ngOnInit() {
    this.from = 0;
    this.to = 5;
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
