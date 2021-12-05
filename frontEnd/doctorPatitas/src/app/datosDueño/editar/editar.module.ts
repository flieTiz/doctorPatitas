import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';

import { EditarRoutingModule } from './editar-routing.module';
import { EditarComponent } from './editar.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    EditarComponent
  ],
  imports: [
    CommonModule,
    EditarRoutingModule,
    FormsModule,
    
    HttpClientModule
  ]
})
export class EditarModule { }