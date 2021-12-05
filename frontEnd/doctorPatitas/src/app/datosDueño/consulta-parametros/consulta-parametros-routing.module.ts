import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultaParametrosComponent } from './consulta-parametros.component';

const routes: Routes = [{ path: '', component: ConsultaParametrosComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ConsultaParametrosRoutingModule { }
