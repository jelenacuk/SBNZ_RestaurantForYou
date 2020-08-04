import { Component, OnInit } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { PageEvent, MatSnackBar } from '@angular/material';
import { ConstantsService } from 'src/app/service/constants.service';
import { Router } from '@angular/router';
import { SearchDto } from 'src/app/dto/search-dto';

@Component({
  selector: 'app-restaurants-list',
  templateUrl: './restaurants-list.component.html',
  styleUrls: ['./restaurants-list.component.css']
})
export class RestaurantsListComponent implements OnInit {

  private restaurants: RestaurantDto[];
  private page: PageEvent = new PageEvent();
  searchInput = '';

  constructor(private restaurantService: RestaurantService, private constants: ConstantsService,
              private snackBar: MatSnackBar, private router: Router) { }

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
          this.page.length = this.restaurants[0].size;
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  search() {
    const dto: SearchDto =  new SearchDto();
    dto.name = this.searchInput;

    this.restaurantService.search(dto).subscribe(
      (response => {
        if (response != null) {
          this.restaurants = response;
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  goToDetails( id: number ) {
    localStorage.setItem('restaurantId', id.toString());
    window.open('restaurant-details');
  }

  getPicture(picture: string): string {
    return this.constants.localhost + picture;
  }

}
