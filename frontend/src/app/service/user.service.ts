import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantsService } from './constants.service';
import { LoginDto } from '../dto/login-dto';
import { Observable } from 'rxjs';
import { TokenDto } from '../dto/token-dto';
import { UserDto } from '../dto/user-dto';
import { ReviewDto } from '../dto/review-dto';
import { CommentDto } from '../dto/comment-dto';
import { PageEvent } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private constants: ConstantsService) { }

  headers: HttpHeaders = new HttpHeaders({
    Authorization: 'Bearer ' + localStorage.getItem('token')
  });

  login(dto: LoginDto): Observable<TokenDto> {
    return this.http.post<TokenDto>(this.constants.authPath + '/login', dto);
  }

  register(dto: UserDto): Observable<boolean> {
    return this.http.post<boolean>(this.constants.authPath + '/registration', dto);
  }
  rateRestaurant(dto: ReviewDto): Observable<boolean> {
    return this.http.post<boolean>(this.constants.userPath + '/rate' , dto, { headers: this.headers });
  }

  commentRestaurant(dto: CommentDto): Observable<CommentDto> {
    return this.http.post<CommentDto>(this.constants.userPath + '/comment' , dto, { headers: this.headers });
  }

  getUsers(event: PageEvent): Observable<UserDto[]> {
    return this.http.get<UserDto[]>(this.constants.userPath  + '/?page=' + event.pageIndex + '&size=' +
    event.pageSize, {headers: this.headers});
  }

  blockUser(username: string): Observable<boolean> {
    return this.http.get<boolean>(this.constants.userPath  + '/blockUser/' + username , {headers: this.headers});
  }
}
