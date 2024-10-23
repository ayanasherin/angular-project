import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] 
})
export class LoginComponent {
  model = {
    email: '',
    password: ''
  };
  errorMessage: string | null = null;

  constructor(private router: Router, private authService: AuthService) {}

  onSubmit(loginForm: NgForm) {
    console.log('Form Submitted', this.model);
    
    this.authService.login(this.model).subscribe(
      (response) => {
        console.log('Login successful', response);
        // alert('Login successful.');
        this.authService.setLoggedIn(true); 
        this.router.navigate(['/dashboard']); 
      },
      (error: HttpErrorResponse) => {
        
        this.errorMessage = 'Invalid email or password'; 
        console.error('Login failed', error);
      }
    );
  }
}
