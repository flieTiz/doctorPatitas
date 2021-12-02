/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.controlador;

import com.doctor.crud.vetModelo.veterinariaModelo;
import com.doctor.crud.vetRepositorio.veterinariaRepositorio;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author flietiz
 */
@RestController
@CrossOrigin(origins = "*", methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/veterinaria")
public class veterinariaControlador {
    
    //////////Variable de insertar
    @Autowired private veterinariaRepositorio vet;
    @Autowired private MongoTemplate m;
    
    /////////Procedimiento guardar
    @PostMapping("/GuardarUsuarios")
    public veterinariaModelo guardarUsuario(@Validated @RequestBody veterinariaModelo varU){
        
        return vet.insert(varU);
        
    }
    
    /////////Procedimiento cargar archivos
    @PostMapping(
    path="/cargarArchivoUsuario",
    consumes=MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String cargarArchivo(@RequestParam("file") MultipartFile f) throws IOException{
        
        String f_nombre=f.getOriginalFilename();
        
        f.transferTo(new File("//home//flietiz//gg//Sprints//backEnd//archivosRecibidos_cargarArchivo//"+f_nombre));
        return f_nombre;
        
    }
    
    ////////Procedimiento consulta general
    @GetMapping("/ConsultarGeneral")
    public List<veterinariaModelo> consultarTodos(){
        
        return vet.findAll();
        
    }

    ////////Procedimiento consulta individual
    @GetMapping("/ConsultarIndividual/{id}")
    public Optional<veterinariaModelo> consultarIndividual(@PathVariable (value="id") String x){
        
        return vet.findById(x);
        
    }
    
    ////////Procedimiento consulta por nombre
    @GetMapping("/ConsultarNombre/{nombres}")
    public List<veterinariaModelo> consultarPorNombre(@PathVariable (value = "nombres") String nombres){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("nombres").is(nombres));
        
        return m.find(q, veterinariaModelo.class);
        
    }
    
    ////////Procedimiento consulta por varios parametros
    @GetMapping("/ConsultarPorVariosParametros/{nombres}/{id}")
    public List<veterinariaModelo> consultarPorVariosParametros(@PathVariable (value = "nombres") String nombres, @PathVariable (value = "id") String x){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("nombres").is(nombres).and("id").is(x));
        
        return m.find(q, veterinariaModelo.class);
        
    }
    
    //////////Procedimiento actualizar info
    @PutMapping("/ActualizarUsuarios/{id}")
    public veterinariaModelo actualizarUsuarios(@PathVariable (value = "id") String x, @Validated @RequestBody veterinariaModelo varU){
        
        return vet.save(varU);
        
    }
    
    ///////////Procedimiento eliminar usuario
    @DeleteMapping("/EliminarUsuario{id}")
    public void eliminarUsuarios(@PathVariable String id){
        
        vet.deleteById(id);
        
    }
    
}
