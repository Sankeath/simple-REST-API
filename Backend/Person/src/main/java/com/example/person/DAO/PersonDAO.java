package com.example.person.DAO;

import com.example.person.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.person.Repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@Repository
public class PersonDAO{
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    public Optional<Person> getPerson(Long id){
        return personRepository.findById(id);
    }

    public Boolean updatePerson(Long id,Person person){
        Optional<Person> toUpdate = getPerson(id);
        Boolean returnStatement = false;
        if (toUpdate.isPresent()){
            toUpdate.get().setAddress(person.getAddress());
            toUpdate.get().setAge(person.getAge());
            toUpdate.get().setEmail(person.getEmail());
            toUpdate.get().setJob(person.getJob());
            toUpdate.get().setName(person.getName());
            toUpdate.get().setPostCode(person.getPostCode());
            toUpdate.get().setPhoneNo(person.getPhoneNo());
            personRepository.save(toUpdate.get());
            returnStatement = true;
        }
        return returnStatement;
    }

    public void deletePerson(Long id){
        Optional<Person> toDelete = personRepository.findById(id);
        if (toDelete.isPresent()){personRepository.delete(toDelete.get());}

    }

    public boolean createPerson(Person person){
        System.out.println(person.toString());
        boolean isCreated =true;
        try {
            personRepository.save(person);
        }
        catch (Exception e){
            isCreated = false;

        }

        return isCreated;
    }
}
