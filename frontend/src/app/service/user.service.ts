import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConstantsService } from './constants.service';
import { LoginDto } from '../dto/loginDto';
import { Observable } from 'rxjs';
import { TokenDto } from '../dto/tokenDto';
import { UserDto } from '../dto/user-dto';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private constants: ConstantsService) { }

  login(dto: LoginDto): Observable<TokenDto> {
    return this.http.post<TokenDto>(this.constants.userPath + '/login', dto);
  }

  register(dto: UserDto): Observable<boolean> {
    return this.http.post<boolean>(this.constants.userPath + '/registration', dto);
  }
}
