export interface Agence {
  id: number;
  nom: string;
  adresse: string;
  ville: string;
  telephone: string;
}

export interface Vehicule {
  id: number;
  marque: string;
  modele: string;
  matricule: string;
  prixParJour: number;
  dateMiseEnService: Date;
  statut: string;
  type: string; 
  
  nombrePortes?: number;
  typeCarburant?: string;
  boiteVitesse?: string;
  
  cylindree?: number;
  typeMoto?: string;
  casqueInclus?: boolean;
}