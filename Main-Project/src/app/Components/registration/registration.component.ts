import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Student } from '../../models/student.model'; 
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  model: Student = {
    id: 0,
    prefix: '',
    firstname: '',
    lastname: '',
    countrycode: '',
    phone: '',
    email: '',
    password: '',
    addressline1: '',
    adressline2: '',
    city: '',
    state: '',
    zipcode: '',
    bachelorDegree: '',
    bachelorGPA: null,
    md: '',
    mdGPA: null,
    lookingForInternship: false,
    resume: null as File | null
  };

  fileError: string | null = null;
  passwordMismatch: boolean = false;

  constructor(private router: Router, private authService: AuthService) {}

  isFieldInvalid(fieldName: string, form: NgForm): boolean {
    const field = form.controls[fieldName];
    return field?.invalid && field?.touched;
  }

  onSubmit(registrationForm: NgForm) {
    if (!this.model.resume) {
      this.fileError = 'Please upload a valid PDF file.';
      return; 
    }

    if (this.validateFields() && registrationForm.valid) {
      this.authService.register(this.model).subscribe(
        response => {
          console.log('Registration successful:', response);
          alert('Registration successful!');
          this.authService.setLoggedIn(true); 
          this.router.navigate(['/login']); 
        },
        error => {
          alert('Registration Failed!');
          console.error('Registration failed:', error);
        }
      );
    }
  }

  validateFields(): boolean {
    return true; 
  }

  onFileSelect(event: any) {
    const file = event.target.files[0];
    if (file) {
      const allowedExtensions = /\.pdf$/i; 
      if (!allowedExtensions.exec(file.name)) {
        this.fileError = 'Invalid file type. Only .pdf files are allowed.';
        this.model.resume = null; 
      } else {
        this.fileError = null;
        this.model.resume = file; 
      }
    }
  }

}
