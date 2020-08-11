import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantsListComponent } from './restaurants-list/restaurants-list.component';
import { MaterialModule } from '../material/matrial.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { ChartsModule } from 'ng2-charts';
import { RestaurantBasicInfoComponent } from './restaurant-basic-info/restaurant-basic-info.component';
import { AddFeaturesComponent } from './add-features/add-features.component';
import { IncompleteComponent } from './incomplete/incomplete.component';



@NgModule({
  declarations: [
    RestaurantsListComponent,
    RestaurantDetailsComponent,
    RestaurantBasicInfoComponent,
    AddFeaturesComponent,
    IncompleteComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    ChartsModule
  ],
  exports: [
    RestaurantsListComponent,
    RestaurantDetailsComponent,
    ChartsModule,
    RestaurantBasicInfoComponent
  ]
})
export class RestaurantsModule { }
