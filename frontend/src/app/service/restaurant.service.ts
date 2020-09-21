import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantsService } from './constants.service';
import { Observable } from 'rxjs';
import { RestaurantDto } from '../dto/restaurant-dto';
import { PageEvent } from '@angular/material';
import { CommentDto } from '../dto/comment-dto';
import { UserExpectations } from '../dto/user-expectations-dto';
import { ReviewDto } from '../dto/review-dto';
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
    return this.http.get<RestaurantDto>(this.constants.restaurantPath + '/restaurantDetails/' + id, { headers: this.headers });
  }

  updateRestaurant(dto: RestaurantDto): Observable<boolean> {
    return this.http.post<boolean>(this.constants.restaurantPath + '/updateRestaurant', dto, { headers: this.headers });
  }

  restaurantRecommandation(dto: UserExpectations): Observable<RestaurantDto> {
    return this.http.post<RestaurantDto>(this.constants.restaurantPath + '/restaurantSugestion',
     dto, { headers: this.headers });
  }

  getComments(id: number, event: PageEvent): Observable<CommentDto[]> {
    return this.http.get<CommentDto[]>(this.constants.restaurantPath + '/comments/' + id + '/?page=' + event.pageIndex + '&size=' +
    event.pageSize , { headers: this.headers });
  }

  search(dto: SearchDto): Observable<RestaurantDto[]> {
    return this.http.post<RestaurantDto[]>(this.constants.restaurantPath + '/search', dto, { headers: this.headers });
  }

  getIncompleteRestaurants() {
    return this.http.get<RestaurantDto[]>(this.constants.restaurantPath + '/incompleteRestaurants', { headers: this.headers });
  }

}
