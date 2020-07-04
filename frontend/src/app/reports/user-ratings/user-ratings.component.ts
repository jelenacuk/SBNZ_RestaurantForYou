import { Component, OnInit, Input } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { ConstantsService } from 'src/app/service/constants.service';

@Component({
  selector: 'app-user-ratings',
  templateUrl: './user-ratings.component.html',
  styleUrls: ['./user-ratings.component.css']
})
export class UserRatingsComponent implements OnInit {

  private numOfMonths: number;
  @Input() mostRecommended: RestaurantDto;
  @Input() leastRecommended: RestaurantDto;

  constructor( private restaurantService: RestaurantService, private constants: ConstantsService) { }

  ngOnInit() {
    this.numOfMonths = 2;
  }


  getPicture(picture: string): string {
    return this.constants.localhost + picture;
  }

}
