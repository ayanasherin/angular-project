
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';  // To get the token from the URL
import { AuthService } from '../../services/auth.service';  // Assuming AuthService handles the backend logic
import { Router } from '@angular/router';
@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {
  resetPasswordForm: FormGroup;
  token: string | null = null;  

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private authService: AuthService,  private router: Router) {
    this.resetPasswordForm = this.fb.group({
      newPassword: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required]
    }, { validator: this.passwordMatchValidator });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.token = params['token'];
      console.log('Token from URL:', this.token);  
    });
  }

  passwordMatchValidator(formGroup: FormGroup) {
    return formGroup.get('newPassword')?.value === formGroup.get('confirmPassword')?.value
      ? null : { mismatch: true };
  }

  onSubmit() {
    if (this.resetPasswordForm.valid && this.token) {
      const newPassword = this.resetPasswordForm.value.newPassword;
      const confirmPassword = this.resetPasswordForm.value.confirmPassword;

      
      this.authService.resetPassword(this.token, newPassword, confirmPassword).subscribe({
        next: (response) => {
          console.log('Password reset successful:', response);
          alert('Password has been reset successfully.');


          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.error('Error resetting password:', error);
        }
      });
    }
  }
}
