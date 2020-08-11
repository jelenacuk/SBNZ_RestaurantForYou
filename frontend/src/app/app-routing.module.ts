import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './users/login/login.component';
import { RegistrationComponent } from './users/registration/registration.component';
import { RestaurantsListComponent } from './restaurants/restaurants-list/restaurants-list.component';
import { HomepageComponent } from './homepage-common/homepage/homepage.component';
import { RestaurantRecommandationComponent } from './restaurant-recommandation/restaurant-recommandation.component';
import { RestaurantDetailsComponent } from './restaurants/restaurant-details/restaurant-details.component';
import { ReportsPageComponent } from './reports/reports-page/reports-page.component';
import { ApiComponent } from './api/api.component';
import { AddFeaturesComponent } from './restaurants/add-features/add-features.component';
import { IncompleteComponent } from './restaurants/incomplete/incomplete.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/home'},
  {path: 'home', component: HomepageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'restaurants-list', component: RestaurantsListComponent},
  {path: 'recommandation', component: RestaurantRecommandationComponent},
  {path: 'restaurant-details', component: RestaurantDetailsComponent},
  {path: 'reports', component: ReportsPageComponent},
  {path: 'api', component: ApiComponent},
  {path: 'addFeatures', component: AddFeaturesComponent},
  {path: 'incomplete', component: IncompleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
