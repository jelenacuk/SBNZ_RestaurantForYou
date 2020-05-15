import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './users/login/login.component';
import { RegistrationComponent } from './users/registration/registration.component';
import { RestaurantsListComponent } from './restaurants/restaurants-list/restaurants-list.component';
import { AddRestaurantComponent } from './restaurants/add-restaurant/add-restaurant.component';
import { HomepageComponent } from './homepage-common/homepage/homepage.component';
import { RestaurantRecommandationComponent } from './restaurant-recommandation/restaurant-recommandation.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/home/false'},
  {path: 'home/:loggedIn', component: HomepageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'restaurants-list', component: RestaurantsListComponent},
  {path: 'add-restaurant', component: AddRestaurantComponent},
  {path: 'recommandation', component: RestaurantRecommandationComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
