/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.neo.repositories;

import com.backend.neo.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Admin
 */
public interface PersonCrudRepository extends CrudRepository<Person, Long> {

    
}
