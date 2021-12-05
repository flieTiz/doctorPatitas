/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd.doctorPatitas.crud_doctorPatitas.controlador;

import com.bd.doctorPatitas.crud_doctorPatitas.modelo.datosMascota;
import com.bd.doctorPatitas.crud_doctorPatitas.vista.repositorioDatosMascota;
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
 * @author ivan
 */
@RestController
@CrossOrigin(origins="*", methods ={RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/datosMascota")
public class controladorDatosMascota {
    
    @Autowired
    private repositorioDatosMascota r;
    
    @GetMapping("/consultar")
    public List<datosMascota> consultarDatosMascota(){
        return r.findAll();
    }
    
    @PostMapping("/insertar")
    public datosMascota insertarDatosMacota(@Validated @RequestBody datosMascota m){
        return r.insert(m);
    }
    
    @PutMapping("/actualizar")
    public datosMascota acualizarDatosMascota(@PathVariable (value="dni") String x,@Validated @RequestBody datosMascota m){
       return r.save(m);
    }
    
    @DeleteMapping("/eliminard/{id}")
    public void eliminarDatosMascota(@PathVariable (value="dni") String x){
        r.deleteById(x);
    }
    
     @GetMapping("/consultar/{id}")
    public Optional<datosMascota> consultarIndividual(@PathVariable (value="dni") String x){
        return r.findById(x);
    }
    
}