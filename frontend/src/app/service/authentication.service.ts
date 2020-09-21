import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }
  getToken(): string {
    return localStorage.getItem('token');
  }

  getRoles(): string {
    const jwtData = this.getToken().split('.')[1];
    if (jwtData) {
      const decodedJwtJsonData = window.atob(jwtData);
      const decodedJwtData = JSON.parse(decodedJwtJsonData);
      if (decodedJwtData.role.length > 0) {
        return decodedJwtData.role[0].authority;
      }
    }
    return '';
  }
}
