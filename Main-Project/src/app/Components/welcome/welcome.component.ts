import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {
  constructor(private location: Location, private authService: AuthService) {}

  ngOnInit() {
    if (!this.authService.isAuthenticated) { 
      this.location.replaceState('/');
    }
  }
}
