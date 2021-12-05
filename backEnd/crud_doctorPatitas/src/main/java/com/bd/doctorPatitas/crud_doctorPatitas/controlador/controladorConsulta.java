/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd.doctorPatitas.crud_doctorPatitas.controlador;


import com.bd.doctorPatitas.crud_doctorPatitas.modelo.consulta;
import com.bd.doctorPatitas.crud_doctorPatitas.vista.repositorioConsulta;
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
@RequestMapping("/consulta")
public class controladorConsulta {
     @Autowired
    private repositorioConsulta r;
    
    
    @GetMapping("/consultar")
    public List<consulta> consultarDatosDueño(){
        return r.findAll();
    }
    
    @PostMapping("/insertar")
    public consulta insertarDatos(@Validated @RequestBody consulta m){
        return r.insert(m);
    }
    
    
    @PutMapping("/actualizar/{numeroConsulta}")
    public consulta actualizarDatos(@PathVariable (value="numeroConsulta") String x,@Validated @RequestBody consulta m){
        return r.save(m);
    }
    
    @DeleteMapping("/eliminar/{numeroConsulta}")
     public void eliminarDatos(@PathVariable (value="numeroConsulta") String x){
         r.deleteById(x);
    }
     
     
     @GetMapping("/consultarIndividual/{numeroConsulta}")
    public Optional<consulta> consultarDatosDueñoIndividual(@PathVariable (value="numeroConsulta") String x){
        return r.findById(x);
    }
}
