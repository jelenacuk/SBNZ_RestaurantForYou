import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  loggedIn: boolean;
  private role: string;

  constructor( private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('token') !== '' ) {
      this.role = localStorage.getItem('role');
      this.loggedIn = true;
    }

  }

}
