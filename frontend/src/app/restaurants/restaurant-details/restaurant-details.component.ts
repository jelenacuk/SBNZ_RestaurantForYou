import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { ReviewDto } from 'src/app/dto/review-dto';
import { ConstantsService } from 'src/app/service/constants.service';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Color, Label } from 'ng2-charts';
import { ReportDTO } from 'src/app/dto/report-dto';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {

  private restaurantId: number;
  private restaurant: RestaurantDto;
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


  constructor(private restaurantService: RestaurantService, private constants: ConstantsService) { }

  ngOnInit() {
      this.restaurantId = Number(localStorage.getItem('restaurantId'));
      this.getRestaurant();
      }

  createChart() {
    this.barChartLabels = ['1', '2', '3', '4', '5'];
    const report: ReportDTO = this.restaurant.reportDTO;
    this.barChartData = [
      { data: [report.ones, report.twos, report.threes, report.fours, report.fives], label: 'Best Fruits' }
    ];
  }

  getRestaurant() {
    this.restaurantService.getRestaurantById(this.restaurantId).subscribe(
      (response => {
        this.restaurant = response;
        this.createChart();
      }),
       (error => {
        alert(error.error.message);
      })
    );
  }

  countStar(star) {
    this.selectedValue = star;
    const dto: ReviewDto = new ReviewDto();
    dto.rating = star;
    dto.restaurantId = this.restaurantId;
    this.restaurantService.rateRestaurant(dto).subscribe(
      (response => {
        if (response === true) {
          alert('Success!');
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

  getJson(): string {
    return JSON.stringify(this.restaurant);
  }

}
