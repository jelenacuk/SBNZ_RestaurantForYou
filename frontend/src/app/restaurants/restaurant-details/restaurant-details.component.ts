import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {

  private restaurantId: number;
  private restaurant: RestaurantDto;

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit() {
    this.restaurantId = Number(localStorage.getItem('restaurantId'));
    this.getRestaurant();
  }

  getRestaurant() {
    this.restaurantService.getRestaurantById(this.restaurantId).subscribe(
      (response => {
        this.restaurant = response;
      }),
       (error => {
        alert(error.error.message);
      })
    );
  }

  getJson(): string {
    return JSON.stringify(this.restaurant);
  }

}
