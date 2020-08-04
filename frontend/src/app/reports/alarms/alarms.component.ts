import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { PageEvent, MatTableDataSource, MatSnackBar, MatPaginator } from '@angular/material';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { ReportService } from 'src/app/service/report.service';

@Component({
  selector: 'app-alarms',
  templateUrl: './alarms.component.html',
  styleUrls: ['./alarms.component.css']
})
export class AlarmsComponent implements OnInit {

  alarms = new MatTableDataSource<RestaurantDto>();
  displayedColumns: string[] = [ 'name', 'average', 'creationDate', 'numOfReviews'];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor( private reportService: ReportService, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.alarms.paginator = this.paginator;
    this.getAlarms();
  }


  getAlarms() {
    this.reportService.getAlarms(this.alarms.paginator).subscribe(
      (response => {
        if (response !== null) {
          this.alarms.data = response;
          if (this.alarms.data.length > 0) {
            this.alarms.paginator.length = this.alarms.data[0].size;
          }
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }


  goToDetails(restaurantId: number ) {
    localStorage.setItem('restaurantId', restaurantId.toString());
    window.open('/restaurant-details');
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.alarms.filter = filterValue.trim().toLowerCase();
    if (this.alarms.paginator) {
      this.alarms.paginator.firstPage();
    }
  }

}
