import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './users/login/login.component';
import { RegistrationComponent } from './users/registration/registration.component';
import { RestaurantsListComponent } from './restaurants/restaurants-list/restaurants-list.component';
import { HomepageComponent } from './homepage-common/homepage/homepage.component';
import { RestaurantDetailsComponent } from './restaurants/restaurant-details/restaurant-details.component';
import { ReportsPageComponent } from './reports/reports-page/reports-page.component';
import { RestaurantRecommandationComponent } from './users/restaurant-recommandation/restaurant-recommandation.component';
import { AddFeaturesComponent } from './users/add-features/add-features.component';
import { IncompleteComponent } from './restaurants/incomplete/incomplete.component';
import { UsersListComponent } from './users/users-list/users-list.component';
import { AdminGuard } from './guards/admin.guard';
import { RegisteredUserGuard } from './guards/registered_user.guard';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: '/home'},
  {path: 'home', component: HomepageComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'restaurants-list', component: RestaurantsListComponent},
  {path: 'recommandation', component: RestaurantRecommandationComponent, canActivate: [RegisteredUserGuard]},
  {path: 'restaurant-details', component: RestaurantDetailsComponent},
  {path: 'reports', component: ReportsPageComponent, canActivate: [AdminGuard]},
  {path: 'addFeatures', component: AddFeaturesComponent, canActivate: [AdminGuard]},
  {path: 'incomplete', component: IncompleteComponent, canActivate: [AdminGuard]},
  {path: 'users', component: UsersListComponent, canActivate: [AdminGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
