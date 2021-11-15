/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.controlador;

import com.doctor.crud.vetModelo.consultaModelo;
import com.doctor.crud.vetRepositorio.consultaRepositorio;
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

@RequestMapping("/api/consulta")

public class consultaControlador {
    
    /////////Variable insertar
    @Autowired
    private consultaRepositorio cons;
    
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
