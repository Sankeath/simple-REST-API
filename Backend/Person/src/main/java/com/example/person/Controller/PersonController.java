package com.example.person.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.person.DAO.PersonDAO;
import com.example.person.Model.Person;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    //Get all persons
    @GetMapping(path = "/person", produces = "application/json")
    public List<Person> getPersonList(){
        return personDAO.getPersonList();
    }

    //Get person by id
    @GetMapping(path = "/{id}", produces = "application/json")
    public Person getPersonList(@PathVariable Long id){
        Optional<Person> person = personDAO.getPerson(id);
        return person.get();
    }

    //Update person using their id
    @PutMapping(path = "/person", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updatePerson(@RequestBody Person person){

        if (personDAO.updatePerson(person.getId(),person)){
            return new ResponseEntity<>("Person info updated",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Person to update not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/person",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> deletePerson(@RequestBody Person person){
        personDAO.deletePerson(person.getId());
        return new ResponseEntity<>("Person specified by id was deleted",HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> createPerson(@RequestBody Person person){
        personDAO.createPerson(person);
        return new ResponseEntity<>("Person created",HttpStatus.OK);
    }

}
