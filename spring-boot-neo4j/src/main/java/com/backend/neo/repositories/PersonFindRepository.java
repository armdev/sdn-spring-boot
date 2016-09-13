/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.neo.repositories;

import com.backend.neo.domain.Person;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Admin
 */
public interface PersonFindRepository extends PagingAndSortingRepository<Person, Long> {

    Person findByFirstName(String name);

    List<Person> findByFirstNameLike(String name);
}
