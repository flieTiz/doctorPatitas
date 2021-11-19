import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { ConsultarRoutingModule } from './consultar-routing.module';
import { ConsultarComponent } from './consultar.component';


@NgModule({
  declarations: [
    ConsultarComponent
  ],
  imports: [
    CommonModule,
    ConsultarRoutingModule,
    HttpClientModule
  ]
})
export class ConsultarModule { }
