import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

declare const Swal:any;
declare const $:any;
@Component({
  selector: 'app-consultar',
  templateUrl: './consultar.component.html',
  styleUrls: ['./consultar.component.css']
})
export class ConsultarComponent implements OnInit {

  infoConsulta:any;

  constructor(private rou:Router,private http: HttpClient) { }

  ngOnInit(): void {
    
    this.listar();
    
    setTimeout(() => {
      
    $('#t_d').DataTable();
    }, 2000);
   
  }
  

  listar():void{
    this.http.get("http://localhost:8080/api/datosDueño/consultar",{responseType:"json"}).subscribe((Res:any)=>{
      
    this.infoConsulta=Res})
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
      
    this.listar();
  });
  }
})

 
}

editar(x:any):void{
  
  this.rou.navigate(["/menu/editar",x]);
}
}
