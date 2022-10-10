package com.example.person.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.person.Model.Person;



public interface PersonRepository extends JpaRepository<Person,Long> {





}
