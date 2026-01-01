import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ConferencesComponent } from './conferences/conferences';
import { KeynotesComponent } from './keynotes/keynotes';

export const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },
  { path: 'conferences', component: ConferencesComponent },
  { path: 'keynotes', component: KeynotesComponent },
  { path: '**', redirectTo: '' },
];
