/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.controlador;

import com.doctor.crud.vetModelo.mascotaModelo;
import com.doctor.crud.vetRepositorio.mascotaRepositorio;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})

@RequestMapping("/api/mascotas")

public class mascotaControlador {
    
    //////////Variable de insertar
    @Autowired
    private mascotaRepositorio masC;
    
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
