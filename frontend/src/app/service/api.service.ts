import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ApiService {

    url = 'https://locations.p.rapidapi.com/?radius=50&language=en&lat=50.0819945&long=19.953965699999998';

    headers: HttpHeaders = new HttpHeaders({
        'x-rapidapi-host': 'locations.p.rapidapi.com',
        'x-rapidapi-key': '9449d52f1amsh71d50a2adea3fa2p1d3d7ejsn789a0c973a2e'
    });

    data = {
        limit: '30',
        language: 'en_US',
        location_id: '15333482',
        currency: 'USD'
    };

    constructor(private http: HttpClient) { }

    getRestaurants(): Observable<any> {
        return this.http.get<any>(this.url,  { headers: this.headers });
    }


}
