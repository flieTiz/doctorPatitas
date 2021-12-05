import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css']
})
export class EditarComponent implements OnInit {

  varArchivo:any;

  m:any={
  id:"",
  apellidos: "",
  contra: "",
  correo: "",
  direccion: "",
  dni: "",
  fechaNacimiento: "",
  nombres: "",
  telefono: ""
 }
 
  constructor(private rou:Router,private rouvar:ActivatedRoute, private http:HttpClient) { }

  ngOnInit(): void {

    this.m.id=this.rouvar.snapshot.params["x"];
  }

  actualizar():void{
  this.http.put("http://localhost:8080/api/datosDueño/actualizar/"+this.m.id,this.m).subscribe((Res:any)=>{
      
    alert("Actualizado exitosamente")
    
    this.rou.navigate(["/menu/consultar"])
  
  })
  }
  cancelar(){
    this.rou.navigate(["/menu/consultar"])
  }

  archivoSeleccionado(event:any):void{
    this.varArchivo=event.target.files[0];
    console.log(this.varArchivo)
    
  }

  subirArchivo(){
    const FD: FormData= new FormData();

    FD.append("file",this.varArchivo);

    this.http.post("http://localhost:8080/api/datosDueño/cargarArchivoNombre/"+this.m.id,FD).subscribe((Res:any)=>{
    
    console.log(Res);
  
  })


  }
  
}
