import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


declare const $:any;

@Component({
  selector: 'app-consultar',
  templateUrl: './consultar.component.html',
  styleUrls: ['./consultar.component.css']
})
export class ConsultarComponent implements OnInit {

  infoConsulta:any;

  constructor(private http: HttpClient) { }
  
  ngOnInit(): void {
    this.listar();

    $('#table_usu').DataTable();
    
  }

  listar():void{

    this.http.get("http://localhost:8080/api/veterinaria/consultar",{responseType:"json"})
    .subscribe((x:any)=>{
      console.log(x);
      this.infoConsulta=x;
    });

  }

  eliminar(x:any):void{
    
    this.http.delete("http://localhost:8080/api/veterinaria/eliminar"+x)
    .subscribe((x:any)=>{
      console.log(x);
      this.listar();
    });

  }

}
