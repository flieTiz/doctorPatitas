import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';



@Component({
  selector: 'app-consultar',
  templateUrl: './consultar.component.html',
  styleUrls: ['./consultar.component.css']
})
export class ConsultarComponent implements OnInit {

  infoConsulta:any;

  constructor(private rou:Router, private http: HttpClient) { }
  
  ngOnInit(): void {
    this.listar();

    
    

    
    
  }
  
  listar():void{
    
    this.http.get("http://localhost:8083/api/veterinaria/ConsultarGeneral",{responseType:"json"})
    .subscribe((x:any)=>{
      console.log(x);
      this.infoConsulta=x;
      
    });
    
  }

  eliminar(x:any):void{
    
    this.http.delete("http://localhost:8083/api/veterinaria/EliminarUsuario"+x)
    .subscribe((x:any)=>{
      console.log(x);
      this.listar();
    });

  }

  FormularioEditar(x:any):void{

    
    this.rou.navigate(["/editar",x]);

  }

}
