import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantsListComponent } from './restaurants-list/restaurants-list.component';
import { MaterialModule } from '../material/matrial.module';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { ChartsModule } from 'ng2-charts';
import { RestaurantBasicInfoComponent } from './restaurant-basic-info/restaurant-basic-info.component';
import { CommentsComponent } from './comments/comments.component';
import { IncompleteComponent } from './incomplete/incomplete.component';

@NgModule({
  declarations: [
    RestaurantsListComponent,
    RestaurantDetailsComponent,
    RestaurantBasicInfoComponent,
    CommentsComponent,
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
    RestaurantBasicInfoComponent,
    CommentsComponent,
    IncompleteComponent
  ]
})
export class RestaurantsModule { }
