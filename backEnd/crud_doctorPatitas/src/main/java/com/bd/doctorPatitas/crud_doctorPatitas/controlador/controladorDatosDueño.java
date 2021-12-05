/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd.doctorPatitas.crud_doctorPatitas.controlador;

import com.bd.doctorPatitas.crud_doctorPatitas.modelo.datosD;
import com.bd.doctorPatitas.crud_doctorPatitas.vista.repositorioDatosDueño;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ivan
 */
@RestController
@CrossOrigin(origins="*", methods ={RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/api/datosDueño")

public class controladorDatosDueño {
    
  
    @Autowired
    private repositorioDatosDueño r;
    @Autowired
    private MongoTemplate m;
    
    @GetMapping("/consultar")
    public List<datosD> consultarDatosDueño(){
        return r.findAll();
    }
    
    @PostMapping("/insertar")
    public datosD insertarDatos(@Validated @RequestBody datosD m){
        return r.insert(m);
    }
    
    
    @PutMapping("/actualizar/{dni}")
    public datosD actualizarDatos(@PathVariable (value="dni") String x,@Validated @RequestBody datosD m){
        return r.save(m);
    }
    
    @DeleteMapping("/eliminar/{dni}")
     public void eliminarDatos(@PathVariable (value="dni") String x){
         r.deleteById(x);
    }
     
     
     @GetMapping("/consultarIndividual/{dni}")
    public Optional<datosD> consultarDatosDueñoIndividual(@PathVariable (value="dni") String x){
        return r.findById(x);
    }
    
    @GetMapping("/consultarDiferenteId/{nombres}")
    public List<datosD> consultaDiferenteId(@PathVariable (value="nombres") String nombres){
        Query q=new Query();
        q.addCriteria(Criteria.where("nombres").is(nombres));
        return m.find(q, datosD.class);
    }
    
    @GetMapping("/consultaPorParametros/{dni}/{nombres}")
    public List<datosD> consultaPorVariosParametros(@PathVariable (value="dni") String dni, @PathVariable (value="nombres") String nombres){
        Query q=new Query();
        q.addCriteria(Criteria.where("dni").is(dni).and("nombres").is(nombres));
        return m.find(q, datosD.class);
        
    }
      @GetMapping("/consultaPorParametrosUsuario/{correo}/{contra}")
    public List<datosD> consultaPorVariosParametrosUsuario(@PathVariable (value="correo") String correo, @PathVariable (value="contra") String contra){
        Query q=new Query();
        q.addCriteria(Criteria.where("correo").is(correo).and("contra").is(contra));
        return m.find(q, datosD.class);
        
    }
    
    @PostMapping(
    path = "/cargarArchivo",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String cargarArchivo(@RequestParam("file") MultipartFile f) throws IOException{
        String f_nombre =f.getOriginalFilename();
        f.transferTo(new File("//home//ivan//archivos//"+f_nombre));
        
        return f_nombre;
        
    }
    
    @PostMapping(
    path = "/cargarArchivoNombre/{nombre}",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String cargarArchivoNombre(@RequestParam("file") MultipartFile f, @PathVariable (value="nombre") String nombre) throws IOException{
        String f_nombre =f.getOriginalFilename();
        String extension=f_nombre.replaceAll("^.*\\.(.*)$", "$1");
        f.transferTo(new File("//home//ivan//archivos//"+nombre+"."+extension));
        
        return nombre+"."+extension;
    }
    
      @PostMapping(
    path = "/cargarArchivoNombreAutomatico",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String cargarArchivoNombreAutomatico(@RequestParam("file") MultipartFile f) throws IOException{
        
        
        String f_nombre =f.getOriginalFilename();
        String extension=f_nombre.replaceAll("^.*\\.(.*)$", "$1");
        
        String nombreAuto=new java.text.SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new java.util.Date());

        f.transferTo(new File("//home//ivan//archivos//"+nombreAuto+"."+extension));
        
        return nombreAuto+"."+extension;
        
    }
   
     
}
