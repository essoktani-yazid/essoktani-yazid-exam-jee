import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehiculeService } from '../../services/vehicule.service';
import { Vehicule } from '../../models/vehicule.model';

@Component({
  selector: 'app-vehicule',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vehicule-component.html',
  styleUrls: ['./vehicule-component.css']
})
export class VehiculesComponent implements OnInit {
  vehicules!: Vehicule[];
  errorMessage: string | null = null;

  constructor(private vehiculeService: VehiculeService) {}

  ngOnInit(): void {
    this.vehiculeService.getVehicules().subscribe({
      next: (data) => {
        this.vehicules = data;
      },
      error: (err) => {
        this.errorMessage = err.message;
      }
    });
  }
}