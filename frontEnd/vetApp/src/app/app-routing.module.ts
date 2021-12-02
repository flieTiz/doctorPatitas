import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'consultar', loadChildren: () => import('./marcas/consultar/consultar.module').then(m => m.ConsultarModule) }, 
{ path: 'nuevo', loadChildren: () => import('./marcas/nuevo/nuevo.module').then(m => m.NuevoModule) },
  { path: 'editar/:x', loadChildren: () => import('./marcas/editar/editar.module').then(m => m.EditarModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
