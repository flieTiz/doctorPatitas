/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patitas.crud.controladores;

import com.patitas.crud.modelo.veterinariaModelo;
import com.patitas.crud.repositorios.veterinariaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/api/usuarios")

public class vaterinariaControlador {
    
    ///////Vairable de insertar 
    @Autowired
    private veterinariaRepositorio vet;
    
    ///////Procedimiento guardar
    @PostMapping("/guardar")
    public veterinariaModelo guardarUsuarios(@Validated @RequestBody veterinariaModelo varU){
        
        return vet.insert(varU);
        
    }
    
    //////////Procedimiento consulta general
    @GetMapping("/consultar")
    public List<veterinariaModelo> consultarUsuarios(){
        
        return vet.findAll();
        
    }
    
    /////////Procedimiento actualizar informacion
    @PutMapping("/actualizar/{id}")
    public veterinariaModelo actualizarUsuarios(@PathVariable String id,@Validated @RequestBody veterinariaModelo varU){
        
        return vet.save(varU);
        
    }
    
    ////////Procedimiento eliminar usuario
    @DeleteMapping("/eliminar{id}")
    public void eliminarUsuarios(@PathVariable String id){
        
        vet.deleteById(id);
        
    }
    
    
}
