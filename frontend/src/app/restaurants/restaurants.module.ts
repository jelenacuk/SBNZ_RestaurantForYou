import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantsListComponent } from './restaurants-list/restaurants-list.component';
import { AddRestaurantComponent } from './add-restaurant/add-restaurant.component';
import { MaterialModule } from '../material/matrial.module';
import { WorkingDaysComponent } from './working-days/working-days.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    RestaurantsListComponent,
    AddRestaurantComponent,
    WorkingDaysComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule
  ],
  exports: [
    RestaurantsListComponent,
  ]
})
export class RestaurantsModule { }
