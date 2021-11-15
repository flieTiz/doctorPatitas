/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.vetRepositorio;

import com.doctor.crud.vetModelo.consultaModelo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author flietiz
 */
public interface consultaRepositorio extends MongoRepository<consultaModelo, String>{
    
}
