
import { Component, OnInit ,AfterViewChecked, AfterViewInit} from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit,AfterViewInit {
  isLoggedIn = false; 
  isLoginPage = false; 
  isRegisterPage = false; 

  constructor(private router: Router, private authService: AuthService) {}
ngAfterViewInit(): void {
  let a = 100;
}
  ngOnInit(): void {
    this.authService.refresh$.subscribe(() => {
      this.refreshData();
    });
    this.updateLoginStatus();

    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        const currentUrl = this.router.url;
        this.isLoginPage = currentUrl.includes('/login');
        this.isRegisterPage = currentUrl.includes('/register');
      }
    });
  }
  refreshData() {
    this.updateLoginStatus();
  }
  
  private updateLoginStatus(): void {
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  
  logout(): void {
    this.authService.logout();
    this.updateLoginStatus();
    this.router.navigate(['']); 
  }
}
