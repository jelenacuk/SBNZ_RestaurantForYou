import { Component, OnInit } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { PageEvent } from '@angular/material';

@Component({
  selector: 'app-restaurants-list',
  templateUrl: './restaurants-list.component.html',
  styleUrls: ['./restaurants-list.component.css']
})
export class RestaurantsListComponent implements OnInit {

  private restaurants: RestaurantDto[];
  private page: PageEvent = new PageEvent();

  constructor(private restaurantService: RestaurantService) { }

  ngOnInit() {
    this.page.pageIndex = 0;
    this.page.pageSize = 4;
    this.getRestaurants();
  }

  nextPage($event) {
    this.page = $event;
    this.getRestaurants();
  }

  getRestaurants() {
    this.restaurantService.getRestaurants(this.page).subscribe(
      (response => {
        if (response !== null) {
          this.restaurants = response;
          console.log(JSON.stringify(response));
        }
      }),
      (error => {
        alert(error.error.message);
      })
    );
  }

}
