/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.controlador;

import com.doctor.crud.vetModelo.productoModelo;
import com.doctor.crud.vetRepositorio.productoRepositorio;
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
@CrossOrigin(origins="*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})

@RequestMapping("/api/productos")

public class productoControlador {
    
    /////////Variable insertar
    @Autowired private productoRepositorio prod;
    @Autowired private MongoTemplate m;

    
    //////////Procedimiento guardar
    @PostMapping("/guardar")
    public productoModelo guardarProducto(@Validated @RequestBody productoModelo varP){
        
        return prod.insert(varP);
        
    }
    
    ///////////Procedimiento consulta general
    @GetMapping("/consultarTodos")
    public List<productoModelo> consultarProducto(){
        
        return prod.findAll();
        
    }
    
    ////////Procedimiento consulta individual
    @GetMapping("/ConsultarIndividual/{id}")
    public Optional<productoModelo> consultarIndividual(@PathVariable (value="id") String x){
        
        return prod.findById(x);
        
    }
    
    ////////Procedimiento consulta por nombre
    @GetMapping("/ConsultarNombre/{nombres}")
    public List<productoModelo> consultarPorNombre(@PathVariable (value = "nombres") String nombres){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("nombres").is(nombres));
        
        return m.find(q, productoModelo.class);
        
    }
    
    ////////Procedimiento consulta por varios parametros
    @GetMapping("/ConsultarPorVariosParametros/{nombres}/{id}")
    public List<productoModelo> consultarPorVariosParametros(@PathVariable (value = "nombres") String nombres, @PathVariable (value = "id") String x){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("nombres").is(nombres).and("id").is(x));
        
        return m.find(q, productoModelo.class);
        
    }
    
    //////////Procedimiento actualizar info
    @PutMapping("/actualizar/{id}")
    public productoModelo actualizarProducto(@PathVariable String id,@Validated @RequestBody productoModelo varP){
        
        return prod.save(varP);
        
    }
    
    //////////Procedimiento eliminar producto
    @DeleteMapping("/eliminar{id}")
    public void eliminarProducto(@PathVariable String id){
        
        prod.deleteById(id);
        
    }
    
}
