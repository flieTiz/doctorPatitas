import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare const Swal:any;
declare const $:any;
@Component({
  selector: 'app-consulta-parametros',
  templateUrl: './consulta-parametros.component.html',
  styleUrls: ['./consulta-parametros.component.css']
})
export class ConsultaParametrosComponent implements OnInit {
  
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

  infoConsulta:any;

    urlconsulta:any;

  constructor(private rou:Router,private http: HttpClient) { }

  ngOnInit(): void {
    
  }

  consultaP():void{


    if(this.m.nombres===""){
    

Swal.fire(
  'Datos obligatorios',
  'El nombre no puede estar vacio',
  'warning'
)
    }
    else{

      if(this.m.dni==""){
        this.urlconsulta="http://localhost:8080/api/datosDueño/consultarDiferenteId/"+this.m.nombres;
      }
      else{
        this.urlconsulta="http://localhost:8080/api/datosDueño/consultaPorParametros/"+this.m.dni+"/"+this.m.nombres+"";
      }
    
        this.http.get(this.urlconsulta,{responseType:"json"}).subscribe((Res:any)=>{
      
    this.infoConsulta=Res})
     setTimeout(() => {
      
    $('#t_d2').DataTable();
    }, 1000);
    }
  }


  eliminar(x:any):void{
 Swal.fire({
  title: '¿Seguro que desea eliminar los datos del dueño?',
  icon: 'warning',
  showCancelButton: true,
  confirmButtonColor: '#3085d6',
  cancelButtonColor: '#d33',
  confirmButtonText: 'Eliminar',
  cancelButtonText: 'Cancelar'
}).then((result:any) => {
  if (result.isConfirmed) {
    this.http.delete("http://localhost:8080/api/datosDueño/eliminar/"+x).subscribe((Res:any)=>{
      this.consultaP();
    //this.listar();
  });
  }
})

  }

  editar(x:any):void{
     this.rou.navigate(["/menu/editar",x]);

  }
}
