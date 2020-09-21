import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/matrial.module';
import { UsersModule } from './users/users.module';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './service/user.service';
import { ConstantsService } from './service/constants.service';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RestaurantsModule } from './restaurants/restaurants.module';
import { HomePageModule } from './homepage-common/homepage_common.module';
import { ChartsModule } from 'ng2-charts';
import { StickyNavModule } from 'ng2-sticky-nav';
import { ReportsModule } from './reports/reports.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    RouterModule,
    FormsModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    ChartsModule,
    StickyNavModule,
    HomePageModule,
    UsersModule,
    RestaurantsModule,
    ReportsModule,
  ],
  providers: [
    UserService,
    ConstantsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
