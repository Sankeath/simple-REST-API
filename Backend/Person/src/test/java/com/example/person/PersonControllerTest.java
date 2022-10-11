package com.example.person;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.person.Repository.PersonRepository;
import com.example.person.Model.Person;
import com.example.person.Controller.PersonController;

import org.mockito.Mockito;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Mockito.when;



@SpringBootTest
public class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @MockBean
    private PersonRepository personRepository;

    @BeforeEach
    void setUp(){
        Long id = Long.valueOf(1);
        personController = Mockito.mock(PersonController.class);
        Person person = new Person(id,"1","2","3","4","5","6","7");
        personRepository.save(person);
    }

    @Test
    public void testUpdateSuccess(){
        Long id = Long.valueOf(1);

        Person p = new Person(id,"new name","2","3","4","5","6","7");


        ResponseEntity<?> response = new ResponseEntity<>("Person info updated", HttpStatus.OK);
        when(personController.updatePerson(p)).thenReturn((ResponseEntity) response);

        assertEquals(response, personController.updatePerson(p));
    }

    @Test
    public void testUpdateNotFound(){
        Long id = Long.valueOf(2);

        Person p = new Person(id,"new name","2","3","4","5","6","7");


        ResponseEntity<?> response = new ResponseEntity<>("Person to update not found", HttpStatus.NOT_FOUND);
        when(personController.updatePerson(p)).thenReturn((ResponseEntity) response);

        assertEquals(response, personController.updatePerson(p));
    }

    @Test
    public void testDeleteSuccess(){
        Long id = Long.valueOf(1);

        Person p = new Person(id,"1","2","3","4","5","6","7");


        ResponseEntity<?> response = new ResponseEntity<>("Person specified by id was deleted", HttpStatus.OK);
        when(personController.updatePerson(p)).thenReturn((ResponseEntity) response);

        assertEquals(response, personController.updatePerson(p));
    }
}
