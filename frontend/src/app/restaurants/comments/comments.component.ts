import { Component, OnInit } from '@angular/core';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { MatSnackBar, PageEvent } from '@angular/material';
import { CommentDto } from 'src/app/dto/comment-dto';
import { UserDto } from 'src/app/dto/user-dto';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  restaurantId: number;
  comments: Array<CommentDto>;
  text: string;
  private page: PageEvent = new PageEvent();
  role: string;

  constructor( private restaurantService: RestaurantService, private userService: UserService, private snackBar: MatSnackBar ) { }

  ngOnInit() {
    this.page.pageIndex = 0;
    this.page.pageSize = 4;
    this.restaurantId = 104;
    this.role = localStorage.getItem('role');
    this.comments = new Array<CommentDto>();
    this.loadComments();
  }

  nextPage($event) {
    this.page = $event;
    this.loadComments();
  }

  submitComment() {
    const comment = new CommentDto();
    comment.text = this.text;
    comment.restaurantId = this.restaurantId;
    this.userService.commentRestaurant(comment).subscribe(
      (response => {
        if (response !== null) {
          this.comments.unshift(response);
        } else {
          this.snackBar.open('You can only comment recommended restaurants!');
        }
      }),
      (error => {
        this.snackBar.open('Something went wrong!');
      })
    );
  }

  loadComments() {
    this.restaurantService.getComments(this.restaurantId, this.page).subscribe(
      (response => {
        if (response !== null) {
          this.comments = response;
          this.page.length = this.comments[0].size;
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }


}
