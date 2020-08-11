import { Component, OnInit, ViewChild } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { MatSnackBar, MatTableDataSource, MatPaginator } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-incomplete',
  templateUrl: './incomplete.component.html',
  styleUrls: ['./incomplete.component.css']
})
export class IncompleteComponent implements OnInit {

  private restaurants: RestaurantDto[];
  incomplete = new MatTableDataSource<RestaurantDto>();
  displayedColumns: string[] = [ 'photo', 'name', 'address'];

  constructor( private restaurantService: RestaurantService, private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit() {
    this.getRestaurants();
  }

  getRestaurants() {
    this.restaurantService.getIncompleteRestaurants().subscribe(
      (response => {
        if (response !== null) {
          this.incomplete.data = response;
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  goToDetails(id: number) {
    localStorage.setItem('featuresId', id.toString());
    this.router.navigateByUrl('/addFeatures');

  }

}
