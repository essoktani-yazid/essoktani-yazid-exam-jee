import { Component, computed, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './navbar-component.html',
  styleUrls: ['./navbar-component.css']
})
export class NavbarComponent {
  username = signal<string | null>(null);
  role = signal<string | null>(null);

  isLoggedIn = computed(() => !!this.auth.getToken());

  constructor(private auth: AuthService, private router: Router) {
    this.username.set(this.auth.getUsername());
    this.role.set(this.auth.getRole());
  }

  logout() {
    this.auth.logout();
    this.username.set(null);
    this.role.set(null);
    this.router.navigateByUrl('/');
  }
}