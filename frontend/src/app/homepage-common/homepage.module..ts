import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AppRoutingModule } from '../app-routing.module';
import { MaterialModule } from '../material/matrial.module';
import { RestaurantsModule } from '../restaurants/restaurants.module';

@NgModule({
  declarations: [
    NavbarComponent,
    HomepageComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    AppRoutingModule,
    RestaurantsModule
  ],
  exports: [
    NavbarComponent,
  ]
})
export class HomePageModule { }
