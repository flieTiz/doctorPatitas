import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
declare const Swal:any;
@Component({
  selector: 'app-nuevo',
  templateUrl: './nuevo.component.html',
  styleUrls: ['./nuevo.component.css']
})
export class NuevoComponent implements OnInit {

 m:any={
  apellidos: "",
  contra: "",
  correo: "",
  direccion: "",
  dni: "",
  fechaNacimiento: "",
  nombres: "",
  telefono: ""
 }
 
 
    constructor(private rou:Router,private http: HttpClient) { }

  ngOnInit(): void {
  }

  guardar():void{
    this.http.post("http://localhost:8080/api/datosDueño/insertar/",this.m).subscribe((Res:any)=>{
    
    this.rou.navigate(["/consultar"])

    Swal.fire({
  position: 'center',
  icon: 'success',
  title: '¡Dueño guardado satisfacoriamnte¡',
  showConfirmButton: false,
  timer: 2000
})
  
  })
  }

   cancelar():void{
    this.rou.navigate(["/menu/consultar"])
  }
  
}
