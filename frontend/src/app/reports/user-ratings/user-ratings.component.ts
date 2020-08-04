import { Component, OnInit, Input } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { ConstantsService } from 'src/app/service/constants.service';
import { ReportService } from 'src/app/service/report.service';

@Component({
  selector: 'app-user-ratings',
  templateUrl: './user-ratings.component.html',
  styleUrls: ['./user-ratings.component.css']
})
export class UserRatingsComponent implements OnInit {

  private numOfMonths: number;
  private mostRecommended: RestaurantDto;
  private leastRecommended: RestaurantDto;

  constructor( private reportService: ReportService, private constants: ConstantsService) { }

  ngOnInit() {
    this.numOfMonths = 2;
    this.getPopularityReport();
  }

  getPopularityReport() {
    this.reportService.getPopularityReport(this.numOfMonths).subscribe(
      (response => {
        if (response != null) {
          this.mostRecommended = response.mostRecommended;
          this.leastRecommended = response.leastRecommended;
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
