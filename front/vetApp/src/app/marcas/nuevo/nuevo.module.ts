import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NuevoRoutingModule } from './nuevo-routing.module';
import { NuevoComponent } from './nuevo.component';


@NgModule({
  declarations: [
    NuevoComponent
  ],
  imports: [
    CommonModule,
    NuevoRoutingModule
  ]
})
export class NuevoModule { }
