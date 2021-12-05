/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bd.doctorPatitas.crud_doctorPatitas.vista;

import com.bd.doctorPatitas.crud_doctorPatitas.modelo.consulta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivan
 */

@Repository
public interface repositorioConsulta extends MongoRepository<consulta, String> {
    
}
