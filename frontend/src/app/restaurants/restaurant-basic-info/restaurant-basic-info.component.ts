import { Component, OnInit, Input } from '@angular/core';
import { RestaurantDto } from 'src/app/dto/restaurant-dto';
import { ConstantsService } from 'src/app/service/constants.service';

@Component({
  selector: 'app-restaurant-basic-info',
  templateUrl: './restaurant-basic-info.component.html',
  styleUrls: ['./restaurant-basic-info.component.css']
})
export class RestaurantBasicInfoComponent implements OnInit {

  @Input() restaurant: RestaurantDto;

  constructor(private constants: ConstantsService) { }
  ngOnInit() {
    console.log(JSON.stringify(this.restaurant));
  }

  goToDetails(restaurantId: number) {
    localStorage.setItem('restaurantId', restaurantId.toString());
    window.open('/restaurant-details');
 }

 getPicture(picture: string): string {
  return this.constants.localhost + picture;
}

}
