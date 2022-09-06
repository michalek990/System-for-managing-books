import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AlertService} from '../../services/alert.service';

@Component({    //TODO można poprawić cos w tym css z logowania i rejestracji zeby tak nie latal przy wpisywaniu danychss
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginFormGroup: FormGroup;
  fieldTextType: boolean;

  constructor(private authService: AuthService,
              private formBuilder: FormBuilder,
              private router: Router,
              private alertService: AlertService) {
  }

  ngOnInit(): void {
    this.loginFormGroup = this.formBuilder.group({
      user: this.formBuilder.group({
        login: new FormControl('',
          [Validators.required, Validators.minLength(3)]),
        password: new FormControl('',
          [Validators.required, Validators.minLength(3)])
      })
    });
  }

  login() {
    if(this.loginFormGroup.valid) {
      this.authService.login(this.loginFormGroup.get('user').get('login').value, this.loginFormGroup.get('user').get('password').value)
        .subscribe(
          response => {
            this.authService.setToken(response.token);
            this.router.navigateByUrl('/dashboard');
          },
          error => {
            this.alertService.error("Wrong credetials");
          }
        );
    }else{
    this.alertService.error("Wrong credetials");
  }}
  toggleFieldTextType() {
    this.fieldTextType = !this.fieldTextType;
  }
}
