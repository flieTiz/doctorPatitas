/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd.doctorPatitas.crud_doctorPatitas.controlador;

import com.bd.doctorPatitas.crud_doctorPatitas.modelo.productos;
import com.bd.doctorPatitas.crud_doctorPatitas.vista.repositorioProductos;
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
@RequestMapping("/productos")
public class controladorProductos {
    
    
    @Autowired
    private repositorioProductos r;
    
    @GetMapping("/consultar")
    public List<productos> listarProductos(){
        return r.findAll();
    }
    
    @PostMapping("/insertar")
    public productos insertarProducto(@Validated @RequestBody productos m){
        return r.insert(m);
    }
    
    
     @PutMapping("/actualizar/{id}")
    public productos actualizarProducto(@PathVariable (value="numeroR") String x,@Validated @RequestBody productos m){
        return r.save(m);
    }
    
    @DeleteMapping("/eliminar")
    public void eliminarProducto(@PathVariable (value="numeroR") String x){
         r.deleteById(x);
    }
    
    
    @GetMapping("/consultar/{id}")
    public Optional<productos> consultaIndividual(@PathVariable (value="numeroR") String x){
        return r.findById(x);
    }
    
}
