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
    this.role = localStorage.getItem('role');
    if (localStorage.getItem('token') !== '' && localStorage.getItem('token') !== null ) {
      this.loggedIn = true;
    }
  }

  onLogOut() {
    localStorage.setItem('token', '');
    localStorage.setItem('role', '');
    this.router.navigate(['/login']);
    this.loggedIn = false;
  }

}
