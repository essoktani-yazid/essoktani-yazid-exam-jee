import { Routes } from '@angular/router';
import { VehiculesComponent } from './components/vehicule-component/vehicule-component';
import { LoginComponent } from './components/login-component/login-component';

export const routes: Routes = [
  { path: 'vehicules', component: VehiculesComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/vehicules', pathMatch: 'full' }
];
