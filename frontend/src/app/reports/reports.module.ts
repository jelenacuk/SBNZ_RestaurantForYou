import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from '../app-routing.module';
import { MaterialModule } from '../material/matrial.module';
import { RestaurantsModule } from '../restaurants/restaurants.module';
import { ReportsPageComponent } from './reports-page/reports-page.component';
import { RatingRangeComponent } from './rating-range/rating-range.component';
import { PopularityComponent } from './popularity/popularity.component';
import { DissatisfiedUsersComponent } from './dissatisfied-users/dissatisfied-users.component';
import { AlarmsComponent } from './alarms/alarms.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ReportsPageComponent,
    RatingRangeComponent,
    PopularityComponent,
    DissatisfiedUsersComponent,
    AlarmsComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    AppRoutingModule,
    RestaurantsModule,
    FormsModule
  ],
  exports: [
    ReportsPageComponent,
    RatingRangeComponent,
    PopularityComponent,
    DissatisfiedUsersComponent,
    AlarmsComponent
  ]
})
export class ReportsModule { }
