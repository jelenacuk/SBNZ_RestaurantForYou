import { Component, OnInit, Input } from '@angular/core';
import { DissatisfiedUserDto } from 'src/app/dto/dissatisfied-users-dto';

@Component({
  selector: 'app-dissatisfied-users',
  templateUrl: './dissatisfied-users.component.html',
  styleUrls: ['./dissatisfied-users.component.css']
})
export class DissatisfiedUsersComponent implements OnInit {

  @Input() dissatisfiedUsers: DissatisfiedUserDto[];

  constructor() { }

  ngOnInit() {
    console.log(JSON.stringify(this.dissatisfiedUsers));
  }

  goToDetails(restaurantId: number) {
    localStorage.setItem('restaurantId', restaurantId.toString());
    window.open('/restaurant-details');
 }

}
