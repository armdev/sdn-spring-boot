package com.backend.neo.domain;

import java.util.Set;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Person {

    @GraphId
    private Long id;

    private String firstName;
    private String lastName;
    @Relationship(type = "FRIEND", direction = "UNDIRECTED")
    private Set<Person> friends;

    public void knows(Person friend) {
        friends.add(friend);
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }
    
    

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
