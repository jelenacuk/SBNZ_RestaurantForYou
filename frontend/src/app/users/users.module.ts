import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { MaterialModule } from '../material/matrial.module';
import { HomePageModule } from '../homepage-common/homepage_common.module';
import { RestaurantRecommandationComponent } from './restaurant-recommandation/restaurant-recommandation.component';
import { AddFeaturesComponent } from './add-features/add-features.component';
import { RestaurantsModule } from '../restaurants/restaurants.module';
import { UsersListComponent } from './users-list/users-list.component';

@NgModule({
  declarations: [
    LoginComponent,
    RegistrationComponent,
    RestaurantRecommandationComponent,
    AddFeaturesComponent,
    UsersListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    HomePageModule,
    RestaurantsModule
  ],
  exports: [
    LoginComponent,
    RegistrationComponent,
    RestaurantRecommandationComponent,
    AddFeaturesComponent
  ]
})
export class UsersModule { }
