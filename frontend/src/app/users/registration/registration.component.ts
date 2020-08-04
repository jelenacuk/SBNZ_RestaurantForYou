import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserDto } from 'src/app/dto/user-dto';
import { UserService } from 'src/app/service/user.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  private registerForm: FormGroup;
  private hide: boolean;

  constructor(private formBuilder: FormBuilder, private userService: UserService, private snackBar: MatSnackBar ) { }

  ngOnInit() {
    this.hide = true;
    this.createRegisterForm();
  }

  onRegisterSubmit() {
    const dto: UserDto = this.userData;
    this.userService.register(dto).subscribe(
      (response => {
        if (response === true) {
          this.snackBar.open('Successfuly!');
        }
      }),
      (error => {
        this.snackBar.open(error.error.message);
      })
    );
  }

  get userData(): UserDto {
    const user: UserDto = new UserDto();
    user.username = this.registerForm.controls.username.value;
    user.password = this.registerForm.controls.password.value;
    user.repeatedPassword = this.registerForm.controls.repeatedPassword.value;
    user.firstName = this.registerForm.controls.firstName.value;
    user.lastName = this.registerForm.controls.lastName.value;
    user.email = this.registerForm.controls.email.value;
    return user;
  }

  createRegisterForm() {
    this.registerForm = this.formBuilder.group({
      username: ['', [
        Validators.required,
        Validators.minLength(4),
        Validators.pattern('[a-z A-Z 0-9]*')
      ]],
      password : ['', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(30),
        Validators.pattern('[a-z A-Z 0-9]*')
      ]],
      repeatedPassword: ['', [
        Validators.required,
      ]],
      firstName: ['', [
        Validators.required,
        Validators.maxLength(20),
        Validators.pattern('[a-z A-Z]*')
      ]],
      lastName: ['', [
        Validators.required,
        Validators.maxLength(20),
        Validators.pattern('[a-z A-Z]*')
      ]],
      email: ['', [
        Validators.required,
        Validators.email
      ]],
    });
  }

}
