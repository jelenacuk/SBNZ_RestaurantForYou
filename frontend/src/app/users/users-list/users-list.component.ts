import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSnackBar, MatTableDataSource } from '@angular/material';
import { UserDto } from 'src/app/dto/user-dto';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users = new MatTableDataSource<UserDto>();
  displayedColumns: string[] = [ 'name', 'username', 'status', 'block'];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  constructor( private userService: UserService, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.users.paginator = this.paginator;
    this.getUsers();
  }

  getUsers() {
    this.userService.getUsers(this.users.paginator).subscribe(
      (response => {
        if (response !== null) {
          this.users.data = response;
          if (this.users.data.length > 0) {
            this.users.paginator.length = this.users.data[0].size;
          }
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  blockUser( username: string) {
    this.userService.blockUser(username).subscribe(
      (response => {
        if (response === true) {
          this.snackBar.open('Successfuly blocked!');
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.users.filter = filterValue.trim().toLowerCase();
    if (this.users.paginator) {
      this.users.paginator.firstPage();
    }
  }

}
