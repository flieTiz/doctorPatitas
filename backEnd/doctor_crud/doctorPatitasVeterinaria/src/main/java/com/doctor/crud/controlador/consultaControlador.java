/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.controlador;

import com.doctor.crud.vetModelo.consultaModelo;
import com.doctor.crud.vetRepositorio.consultaRepositorio;
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

@RequestMapping("/api/consulta")

public class consultaControlador {
    
    /////////Variable insertar
    @Autowired private consultaRepositorio cons;
    @Autowired private MongoTemplate m;

    //////////Procedimiento guardar
    @PostMapping("/guardar")
    public consultaModelo guardarConsulta(@Validated @RequestBody consultaModelo varC){
        
        return cons.insert(varC);
        
    }
    
    ///////////Procedimiento consulta general
    @GetMapping("/consultar")
    public List<consultaModelo> consultarConsulta(){
        
        return cons.findAll();
        
    }
    
    ////////Procedimiento consulta individual
    @GetMapping("/ConsultarIndividual/{id}")
    public Optional<consultaModelo> consultarIndividual(@PathVariable (value="id") String x){
        
        return cons.findById(x);
        
    }
    
    ////////Procedimiento consulta por nombre
    @GetMapping("/ConsultarNombre/{id_consulta}")
    public List<consultaModelo> consultarPorNombre(@PathVariable (value = "id_consulta") String id_consulta){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("id_consulta").is(id_consulta));
        
        return m.find(q, consultaModelo.class);
        
    }
    
    ////////Procedimiento consulta por varios parametros
    @GetMapping("/ConsultarPorVariosParametros/{id_consulta}/{id}")
    public List<consultaModelo> consultarPorVariosParametros(@PathVariable (value = "id_consulta") String id_consulta, @PathVariable (value = "id") String x){
        
        Query q=new Query();
        q.addCriteria(Criteria.where("id_consulta").is(id_consulta).and("id").is(x));
        
        return m.find(q, consultaModelo.class);
        
    }
    
    //////////Procedimiento actualizar info
    @PutMapping("/actualizar/{id}")
    public consultaModelo actualizarConsulta(@PathVariable String id,@Validated @RequestBody consultaModelo varC){
        
        return cons.save(varC);
        
    }
    
    //////////Procedimiento eliminar producto
    @DeleteMapping("/eliminar{id}")
    public void eliminarConsulta(@PathVariable String id){
        
        cons.deleteById(id);
        
    }
    
}
