/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doctor.crud.vetRepositorio;

import com.doctor.crud.vetModelo.veterinariaModelo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author flietiz
 */
@Repository
public interface veterinariaRepositorio extends MongoRepository<veterinariaModelo, String>{
    
}
