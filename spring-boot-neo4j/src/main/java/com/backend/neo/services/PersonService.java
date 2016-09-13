/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.neo.services;

import com.backend.neo.domain.Person;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.backend.neo.repositories.PersonCrudRepository;
import com.backend.neo.repositories.PersonFindRepository;

/**
 *
 * @author Admin
 */
@Service
public class PersonService {

    @Autowired
    private PersonCrudRepository repository;

    @Autowired
    private PersonFindRepository personFindRepository;

    @Transactional
    public List<Person> getPerson(String firstName) {      
        return personFindRepository.findByFirstNameLike(firstName);
    }
    
    @Transactional
    public void savePerson(String firstName, String lastName) {
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        repository.save(p);
        
    }

  

}
