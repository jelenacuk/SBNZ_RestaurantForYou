import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../service/authentication.service';

@Injectable({
    providedIn: 'root'
})
export class RegisteredUserGuard implements CanActivate {
    constructor(private authenticationService: AuthenticationService, private router: Router) { }
    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean |
            UrlTree> | boolean | UrlTree {
        const role = this.authenticationService.getRoles();
        if (role === 'ROLE_REGISTERED') {
            return true;
        } else if (role === 'ROLE_ADMIN') {
            this.router.navigateByUrl('/home');
            return false;
        }
        this.router.navigateByUrl('/login');
        return false;
    }
}
