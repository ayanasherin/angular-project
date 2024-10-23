import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';  
import { HttpErrorResponse } from '@angular/common/http';  
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent {
  forgotPasswordForm: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private modalService: NgbModal) {
    this.forgotPasswordForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]]  
    });
  }

  ngOnInit(): void {}

  openModal(): void {
    const modalElement = document.getElementById('forgotPasswordModal');
    if (modalElement) {
      const modal = new bootstrap.Modal(modalElement);
      modal.show(); 
    }
  }

  onSubmit(): void {
    if (this.forgotPasswordForm.valid) {
      const email = this.forgotPasswordForm.value.email;
      
      this.authService.forgotPassword(email).subscribe({
        next: (response) => {
          console.log('Reset link sent to email:', response);
          this.openModal();  // Show modal only on success
        },
        error: (error: HttpErrorResponse) => {
          console.error('Error sending reset link:', error);
          
          if (error.status === 404) {
            alert('No user found with this email address.');  
          } else {
            alert('No user found with this email address.');
          }
        }
      });
    }
  }}