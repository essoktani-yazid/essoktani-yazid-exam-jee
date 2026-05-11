import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehicule, Agence } from '../models/vehicule.model';

@Injectable({
  providedIn: 'root'
})
export class VehiculeService {
  private backendHost = "http://localhost:8085/api";

  constructor(private http: HttpClient) { }

  public getVehicules(): Observable<Vehicule[]> {
    return this.http.get<Vehicule[]>(`${this.backendHost}/vehicules`);
  }

  public getAgences(): Observable<Agence[]> {
    return this.http.get<Agence[]>(`${this.backendHost}/agences`);
  }
}