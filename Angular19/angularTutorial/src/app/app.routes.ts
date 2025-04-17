import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'hello', pathMatch: 'full' },
  {
    path: 'hello',
    loadComponent: () => import('./hello/hello.component').then(m => m.HelloComponent)
  },
  {
    path: 'signal',
    loadComponent: () => import('./signal/signal.component').then(m => m.SignalComponent)
  },
  {
    path: 'minigame',
    loadComponent: () => import('./minigame/minigame.component').then(m => m.MinigameComponent)
  },
  {
    path: 'controlflow',
    loadComponent: () => import('./controlflow/controlflow.component').then(m => m.ControlFlowComponent)
  },
  {
    path: '**',
    loadComponent: () => import('./hello/hello.component').then(m => m.HelloComponent)
  }
];