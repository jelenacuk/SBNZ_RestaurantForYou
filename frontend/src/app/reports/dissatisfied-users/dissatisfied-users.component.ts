import { Component, OnInit, Input } from '@angular/core';
import { DissatisfiedUserDto } from 'src/app/dto/dissatisfied-users-dto';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { UserDto } from 'src/app/dto/user-dto';
import { ReportService } from 'src/app/service/report.service';

@Component({
  selector: 'app-dissatisfied-users',
  templateUrl: './dissatisfied-users.component.html',
  styleUrls: ['./dissatisfied-users.component.css']
})
export class DissatisfiedUsersComponent implements OnInit {

  dissatisfiedUsers: DissatisfiedUserDto[];

  constructor(  private reportService: ReportService ) { }

  ngOnInit() {
    this.getDissatisfiedUsers();
  }

  getDissatisfiedUsers() {
    this.reportService.getDissatisfiedUsers().subscribe(
      (response => {
        if (response != null) {
          this.dissatisfiedUsers = response;
        }
      }),
      (error => {
        alert(error.error.message);
      })
    );
  }

  goToDetails(restaurantId: number) {
    localStorage.setItem('restaurantId', restaurantId.toString());
    window.open('/restaurant-details');
 }

}
