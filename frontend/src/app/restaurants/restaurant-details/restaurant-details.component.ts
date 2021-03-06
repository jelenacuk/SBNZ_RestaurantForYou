import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { ReviewDto } from 'src/app/dto/review-dto';
import { ConstantsService } from 'src/app/service/constants.service';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { ReportDTO } from 'src/app/dto/report-dto';
import { MatSnackBar } from '@angular/material';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {

  private restaurantId: number;
  private restaurant: RestaurantDto;
  role: string;

  // rating
  stars: number[] = [1, 2, 3, 4, 5];
  selectedValue: number;
  // charts
  barChartOptions: ChartOptions = { responsive: true};
  barChartLabels: Label[];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];
  barChartData: ChartDataSets[];


  constructor(private restaurantService: RestaurantService, private constants: ConstantsService,
              private  userService: UserService, private snackBar: MatSnackBar) { }

  ngOnInit() {
      this.role = localStorage.getItem('role');
      this.restaurantId = Number(localStorage.getItem('restaurantId'));
      this.getRestaurant();
      }

  createChart() {
    this.barChartLabels = ['1', '2', '3', '4', '5'];
    const report: ReportDTO = this.restaurant.reportDTO;
    this.barChartData = [
      { data: [report.ones, report.twos, report.threes, report.fours, report.fives], label: 'Grades' }
    ];
  }

  getRestaurant() {
    this.restaurantService.getRestaurantById(this.restaurantId).subscribe(
      (response => {
        this.restaurant = response;
        this.createChart();
        this.selectedValue = this.restaurant.reportDTO.myReview;
      }),
       (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  countStar(star) {
    const dto: ReviewDto = new ReviewDto();
    dto.rating = star;
    dto.restaurantId = this.restaurantId;
    this.userService.rateRestaurant(dto).subscribe(
      (response => {
        if (response === true) {
          this.snackBar.open('Success!');
          this.selectedValue = star;
          window.location.reload();
        } else {
          this.snackBar.open('You can only rate restaurants that are recommended to you.');
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }


  getJson(): string {
    return JSON.stringify(this.restaurant);
  }

}
