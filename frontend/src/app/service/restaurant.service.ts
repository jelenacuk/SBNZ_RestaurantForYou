import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantsService } from './constants.service';
import { Observable } from 'rxjs';
import { RestaurantDto } from '../dto/restaurant-dto';
import { PageEvent } from '@angular/material';
import { AddRestaurantDto } from '../dto/add-restaurant-dto';
import { UserExpectations } from '../dto/user-expectations-dto';
import { ReviewDto } from '../dto/review-dto';
import { RatingRangeDTO } from '../dto/rating-range-dto';
import { StatisticDto } from '../dto/statistic-dto';
import { SearchDto } from '../dto/search-dto';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  headers: HttpHeaders = new HttpHeaders({
    Authorization: 'Bearer ' + localStorage.getItem('token')
  });

  constructor(private http: HttpClient, private constants: ConstantsService) { }

  getRestaurants(event: PageEvent): Observable<RestaurantDto[]> {
    return this.http.get<RestaurantDto[]>(this.constants.restaurantPath + '/?page=' + event.pageIndex + '&size=' +
    event.pageSize);
  }

  getRestaurantById(id: number): Observable<RestaurantDto> {
    return this.http.get<RestaurantDto>(this.constants.restaurantPath + '/' + id, { headers: this.headers });
  }

  addRestaurantd(dto: AddRestaurantDto): Observable<boolean> {
    return this.http.post<boolean>(this.constants.restaurantPath + '/addRestaurant', dto, { headers: this.headers });
  }

  restaurantRecommandation(dto: UserExpectations): Observable<RestaurantDto> {
    return this.http.post<RestaurantDto>(this.constants.restaurantPath + '/restaurantSugestion',
     dto, { headers: this.headers });
  }

  rateRestaurant(dto: ReviewDto): Observable<boolean> {
    return this.http.post<boolean>(this.constants.userPath + '/rate' , dto, { headers: this.headers });
  }

  getRestaurantsByRatingRange(dto: RatingRangeDTO): Observable<RestaurantDto[]> {
    return this.http.post<RestaurantDto[]>(this.constants.restaurantPath + '/getRestaurantsByRatingRange', dto, { headers: this.headers });
  }

  getStatistic(numOfMonths: number): Observable<StatisticDto> {
    return this.http.get<StatisticDto>(this.constants.restaurantPath + '/reports/' + numOfMonths, { headers: this.headers });
  }

  search(dto: SearchDto): Observable<RestaurantDto[]> {
    return this.http.post<RestaurantDto[]>(this.constants.restaurantPath + '/search', dto, { headers: this.headers });
  }

}
