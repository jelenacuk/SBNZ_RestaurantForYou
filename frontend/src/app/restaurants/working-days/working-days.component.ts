import { Component, OnInit, Input } from '@angular/core';
import { WorkingDayDto } from 'src/app/dto/working-day-dto';
import { AddRestaurantDto } from 'src/app/dto/add-restaurant-dto';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-working-days',
  templateUrl: './working-days.component.html',
  styleUrls: ['./working-days.component.css']
})
export class WorkingDaysComponent implements OnInit {

  @Input() restaurantDto: AddRestaurantDto;
  private workingDays: WorkingDayDto[];

  constructor(private restaurantService: RestaurantService, private formBuilder: FormBuilder) { }


  ngOnInit() {
    this.initializeList();
  }

  onAddRestaurantSubmit() {
    this.restaurantDto.workingDays = this.workingDays;
    this.restaurantService.addRestaurantd(this.restaurantDto).subscribe(
      (response => {
        if (response === true) {
          alert('Successfuly!');
        }
      }),
      (error => {
        alert(error.error.message);
      })
    );
  }

  initializeList() {
    this.workingDays = new Array<WorkingDayDto>();
    this.workingDays.push(new WorkingDayDto('Monday'));
    this.workingDays.push(new WorkingDayDto('Thuesday'));
    this.workingDays.push(new WorkingDayDto('Wednesday'));
    this.workingDays.push(new WorkingDayDto('Thursday'));
    this.workingDays.push(new WorkingDayDto('Friday'));
    this.workingDays.push(new WorkingDayDto('Saturday'));
    this.workingDays.push(new WorkingDayDto('Sunday'));
  }

}
