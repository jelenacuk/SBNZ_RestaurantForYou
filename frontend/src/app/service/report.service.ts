import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantsService } from './constants.service';
import { Observable } from 'rxjs';
import { RestaurantDto } from '../dto/restaurant-dto';
import { PageEvent } from '@angular/material';
import { RatingRangeDTO } from '../dto/rating-range-dto';
import { PopularityDto } from '../dto/popularity-dto';
import { DissatisfiedUserDto } from '../dto/dissatisfied-users-dto';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  headers: HttpHeaders = new HttpHeaders({
    Authorization: 'Bearer ' + localStorage.getItem('token')
  });

  constructor(private http: HttpClient, private constants: ConstantsService) { }


  getRestaurantsByRatingRange(dto: RatingRangeDTO): Observable<RestaurantDto[]> {
    return this.http.post<RestaurantDto[]>(this.constants.reportsPath + '/getRestaurantsByRatingRange', dto, { headers: this.headers });
  }

  getPopularityReport(numOfMonths: number): Observable<PopularityDto> {
    return this.http.get<PopularityDto>(this.constants.reportsPath + '/popularityReport/' + numOfMonths, { headers: this.headers });
  }

  getDissatisfiedUsers(): Observable<DissatisfiedUserDto[]> {
    return this.http.get<DissatisfiedUserDto[]>(this.constants.reportsPath + '/getDissatisfiedUsers', { headers: this.headers });
  }

  getAlarms(event: PageEvent): Observable<RestaurantDto[]> {
    return this.http.get<RestaurantDto[]>(this.constants.reportsPath + '/getAlarms'  + '/?page=' + event.pageIndex + '&size=' +
    event.pageSize, {headers: this.headers});
  }

}
