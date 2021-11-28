import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

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

  constructor(private rou:Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  guardar():void{

    this.http.post("http://localhost:8080/api/veterinaria/guardar",this.m)
    .subscribe((x:any)=>{
      console.log(x);
      alert("Registrado Satisfactoriamente")

      this.rou.navigate(["/consultar"])

    });

  }

}
