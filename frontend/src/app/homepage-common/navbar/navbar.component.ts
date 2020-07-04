import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input() loggedIn: boolean;
  private role: string;

  constructor( private router: Router) { }

  ngOnInit() {


    if (localStorage.getItem('token') !== '' ) {
      this.role = localStorage.getItem('role');
    }

  }

  onLogOut() {
    localStorage.setItem('token', '');
    localStorage.setItem('role', '');
    this.router.navigate(['/login']);
    this.loggedIn = false;
  }

  navigateToHome() {
    if (this.loggedIn) {
      this.router.navigate(['/home', true]);
    } else {
      this.router.navigate(['/home', false]);
    }
  }

}
