import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './users/login/login.component';
import { RegistrationComponent } from './users/registration/registration.component';
import { RestaurantsListComponent } from './restaurants/restaurants-list/restaurants-list.component';
import { AddRestaurantComponent } from './restaurants/add-restaurant/add-restaurant.component';
import { HomepageComponent } from './homepage-common/homepage/homepage.component';
import { RestaurantRecommandationComponent } from './restaurant-recommandation/restaurant-recommandation.component';
import { RestaurantDetailsComponent } from './restaurants/restaurant-details/restaurant-details.component';
import { ReportsPageComponent } from './reports/reports-page/reports-page.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/home'},
  {path: 'home', component: HomepageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'restaurants-list', component: RestaurantsListComponent},
  {path: 'add-restaurant', component: AddRestaurantComponent},
  {path: 'recommandation', component: RestaurantRecommandationComponent},
  {path: 'restaurant-details', component: RestaurantDetailsComponent},
  {path: 'reports', component: ReportsPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
