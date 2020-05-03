import { Injectable } from '@angular/core';

@Injectable()
export class ConstantsService {
    readonly localhost = 'http://localhost:8080';
    readonly userPath = this.localhost + '/api/users';
    readonly restaurantPath = this.localhost + '/api/restaurants';
}
