import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginDto } from 'src/app/dto/login-dto';
import { UserService } from 'src/app/service/user.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loginForm: FormGroup;
  private hide: boolean;

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.hide = true;
    this.loginForm = this.formBuilder.group({
      username: ['', [
        Validators.required
      ]],
      password: ['', [
        Validators.required,
      ]]
    });
  }

  get username() { return this.loginForm.controls.username.value as string; }
  get password() { return this.loginForm.controls.password.value as string; }


  onLogInSubmit() {
    const dto: LoginDto = new LoginDto(this.username, this.password);
    this.userService.login(dto).subscribe(
      (response => {
        if (response != null) {
          localStorage.setItem('token', response.token);
          const jwt: JwtHelperService = new JwtHelperService();
          const info = jwt.decodeToken(response.token);
          const role = info.role[0].authority;
          localStorage.setItem('role', info.role[0].authority);
          window.location.replace('/home');
          // this.router.navigate(['/home', true]);
        } else {
          alert('Bad Credentials');
        }
      }),
      (error => {
        this.snackBar.open('Bad Credentials!');
      })
    );
  }
}
