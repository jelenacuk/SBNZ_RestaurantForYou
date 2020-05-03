import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginDto } from 'src/app/dto/loginDto';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private userService: UserService) { }

  ngOnInit() {
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
          alert('Successfuly!');
        }
      }),
      (error => {
        alert(error.error.message);
      })
    );
  }
}
