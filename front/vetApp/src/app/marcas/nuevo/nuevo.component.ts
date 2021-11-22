import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nuevo',
  templateUrl: './nuevo.component.html',
  styleUrls: ['./nuevo.component.css']
})
export class NuevoComponent implements OnInit {

  m:any={
    nombres:"",
    apellidos:"",
    email:"",
    direccion:"",
    fecNacimiento:"",
    password:"",
    telefono:"",
    dni:""
  }

  constructor() { }

  ngOnInit(): void {
  }

  guardar():void{

  }

}
