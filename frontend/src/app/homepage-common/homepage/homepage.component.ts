import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  private loggedIn: boolean;
  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    if (this.route.snapshot.paramMap.get('loggedIn') === 'true') {
      this.loggedIn = true;
    }
  }

}
