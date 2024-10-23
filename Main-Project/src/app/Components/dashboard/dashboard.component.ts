import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'] 
})
export class DashboardComponent implements OnInit {
  welcomeMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.authService.refresh$.subscribe(() => {
      this.loadWelcomeMessage();
    });
    this.loadWelcomeMessage(); 
  }

  loadWelcomeMessage(): void {
    const user = JSON.parse(localStorage.getItem('user') || '{}'); 
    if (user && user.firstname) {
      this.welcomeMessage = `Welcome, ${user.firstname}!`;
    } else {
      this.router.navigate(['/login']); 
    }
  }
}
