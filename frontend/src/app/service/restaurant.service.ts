import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantsService } from './constants.service';
import { Observable } from 'rxjs';
import { RestaurantDto } from '../dto/restaurant-dto';
import { PageEvent } from '@angular/material';
import { AddRestaurantDto } from '../dto/add-restaurant-dto';

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
}
