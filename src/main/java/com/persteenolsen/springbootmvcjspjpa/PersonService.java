package com.persteenolsen.springbootmvcjspjpa;

import java.util.List;
import java.util.Optional;
 
import javax.persistence.EntityNotFoundException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import com.persteenolsen.springbootmvcjspjpa.PersonEntity;
import com.persteenolsen.springbootmvcjspjpa.PersonRepository;
 
@Service
public class PersonService {
 
    @Autowired
    PersonRepository personRepo;
    
    
    // --------------------------------Use by both MVC / Controller + JSP - URL - REST-------------------
    public List<PersonEntity> getAll() {
        return (List<PersonEntity>) personRepo.findAll();
    }
 

    //---------------------------------Use by MVC / Controller + JSP-------------------------------------
    public PersonEntity getPersonById(long id) {

        PersonEntity person = null;
        Optional<PersonEntity> searchEntity = personRepo.findById(id);
        if (searchEntity.isPresent()) 
            person = searchEntity.get();
         else 
             throw new EntityNotFoundException();
         return person;
       }
       
       // This method is used by Update + Create
       public void saveOrUpdate(PersonEntity person) {
          personRepo.save(person);
       }
             
       public void deletePerson(long id) {
          personRepo.deleteById(id);
       }
    
    

    //----------------------------------------Use by REST API--------------------------------------------
    public PersonEntity createPerson(PersonEntity personEntity) {
        return personRepo.save(personEntity);
    }
 

    public PersonEntity updatePerson(Long Id, PersonEntity personEntity) {
        PersonEntity updatedPerson;
        Optional<PersonEntity> searchEntity = personRepo.findById(Id);
        if (searchEntity.isPresent()) {
            PersonEntity person = searchEntity.get();
            person.setAge(personEntity.getAge());
            person.setName(personEntity.getName());
            updatedPerson = personRepo.save(person);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedPerson;
    }
 

    public ResponseEntity<Object> deletePerson(Long Id) {
        Optional<PersonEntity> personEntity = personRepo.findById(Id);
        if (personEntity.isPresent()) {
            PersonEntity person = personEntity.get();
            personRepo.delete(person);
           
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}