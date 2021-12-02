import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { ConsultarRoutingModule } from './consultar-routing.module';
import { ConsultarComponent } from './consultar.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ConsultarComponent
  ],
  imports: [
    CommonModule,
    ConsultarRoutingModule,
    HttpClientModule,
    FormsModule
  ]
})
export class ConsultarModule { }
