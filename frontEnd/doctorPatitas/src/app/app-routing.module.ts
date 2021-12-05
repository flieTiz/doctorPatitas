import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './datosDueño/login/login.component';
import { LoginModule } from './datosDueño/login/login.module';
import { MenuComponent } from './datosDueño/menu/menu.component';

const routes: Routes = [

  { path:"",redirectTo:"/login",pathMatch:"full"},
  { path:"menu",component:MenuComponent,children:[
    { path: 'consultar', loadChildren: () => import('./datosDueño/consultar/consultar.module').then(m => m.ConsultarModule) }, 
  { path: 'nuevo', loadChildren: () => import('./datosDueño/nuevo/nuevo.module').then(m => m.NuevoModule) }, 
  { path: 'editar/:x', loadChildren: () => import('./datosDueño/editar/editar.module').then(m => m.EditarModule) }, 
  { path: 'consultaParametros', loadChildren: () => import('./datosDueño/consulta-parametros/consulta-parametros.module').then(m => m.ConsultaParametrosModule) },

  ]},
  
  { path:"login",component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
