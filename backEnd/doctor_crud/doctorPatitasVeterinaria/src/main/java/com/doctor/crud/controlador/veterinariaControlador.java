/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.controlador;

import com.doctor.crud.vetModelo.veterinariaModelo;
import com.doctor.crud.vetRepositorio.veterinariaRepositorio;
import java.util.List;
import java.util.Optional;

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
@CrossOrigin(origins = "*", methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/veterinaria")
public class veterinariaControlador {
    
    //////////Variable de insertar
    @Autowired
    private veterinariaRepositorio vet;
    
    /////////Procedimiento guardar
    @PostMapping("/GuardarUsuarios")
    public veterinariaModelo guardarUsuario(@Validated @RequestBody veterinariaModelo varU){
        
        return vet.insert(varU);
        
    }
    
    ////////Procedimiento consulta general
    @GetMapping("/ConsultarGeneral")
    public List<veterinariaModelo> consultarTodos(){
        
        return vet.findAll();
        
    }

    ////////Procedimiento consulta general
    @GetMapping("/ConsultarIndividual")
    public Optional<veterinariaModelo> consultarIndividual(@PathVariable (value = "id") String x){
        
        return vet.findById(x);
        
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
