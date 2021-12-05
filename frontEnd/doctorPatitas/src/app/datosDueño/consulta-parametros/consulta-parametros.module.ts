import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { ConsultaParametrosRoutingModule } from './consulta-parametros-routing.module';
import { ConsultaParametrosComponent } from './consulta-parametros.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ConsultaParametrosComponent
  ],
  imports: [
    CommonModule,
    ConsultaParametrosRoutingModule,
    FormsModule,
    HttpClientModule
  ]
})
export class ConsultaParametrosModule { }
