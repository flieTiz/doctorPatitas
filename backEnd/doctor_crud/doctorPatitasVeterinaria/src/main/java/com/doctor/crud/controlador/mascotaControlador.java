/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.controlador;

import com.doctor.crud.vetModelo.mascotaModelo;
import com.doctor.crud.vetRepositorio.mascotaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author flietiz
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})

@RequestMapping("/api/mascotas")

public class mascotaControlador {
    
    //////////Variable de insertar
    @Autowired private mascotaRepositorio masC;
    @Autowired private MongoTemplate m;

    
    /////////Procedimiento guardar
    @PostMapping("/guardar")
    public mascotaModelo guardarMascota(@Validated @RequestBody mascotaModelo varM){
        
        return masC.insert(varM);
        
    }
    
    ////////Procedimiento consulta general
    @GetMapping("/consultar")
    public List<mascotaModelo> consultarMascota(){
        
        return masC.findAll();
        
    }
    
    ////////Procedimiento consulta individual
    @GetMapping("/ConsultarIndividual/{id}")
    public Optional<mascotaModelo> consultarIndividual(@PathVariable (value="id") String x){
        
        return masC.findById(x);
        
    }
    
    ////////Procedimiento consulta por nombre
    @GetMapping("/ConsultarNombre/{nombres}")
    public List<mascotaModelo> consultarPorNombre(@PathVariable (value = "nombres") String nombres){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("nombres").is(nombres));
        
        return m.find(q, mascotaModelo.class);
        
    }
    
    ////////Procedimiento consulta por varios parametros
    @GetMapping("/ConsultarPorVariosParametros/{nombres}/{id}")
    public List<mascotaModelo> consultarPorVariosParametros(@PathVariable (value = "nombres") String nombres, @PathVariable (value = "id") String x){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("nombres").is(nombres).and("id").is(x));
        
        return m.find(q, mascotaModelo.class);
        
    }
    
    //////////Procedimiento actualizar info
    @PutMapping("/actualizar/{id}")
    public mascotaModelo actualizarMascota(@PathVariable String id, @Validated @RequestBody mascotaModelo varM){
        
        return masC.save(varM);
        
    }
    
    ///////////Procedimiento eliminar usuario
    @DeleteMapping("/eliminar{id}")
    public void eliminarMascota(@PathVariable String id){
        
        masC.deleteById(id);
        
    }
    
}
