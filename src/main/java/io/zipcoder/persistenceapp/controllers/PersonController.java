package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(Person person) {
        return new ResponseEntity<>(this.personService.insertPerson(person), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personUpdated) {
        return new ResponseEntity<>(this.personService.updatePerson(id, personUpdated), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> findPerson(@PathVariable Long id) {
        return new ResponseEntity<>(this.personService.findPerson(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        this.personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findAllPeople() {
        return new ResponseEntity<>(this.personService.findAllPeople(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/reverse-lookup/{mobileNumber}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findByMobileNumber(@PathVariable String mobileNumber) {
        return new ResponseEntity<>(this.personService.findPersonByMobileNumber(mobileNumber), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/surname/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPeopleWithLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(this.personService.findPersonByFirstName(lastName), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/surname", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Person>>> getSurnameReport() {
        return new ResponseEntity<>(this.personService.getMapLastNamesToPeopleList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/firstname/stats" method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getFirstNamesReport() {
        return new ResponseEntity<>(this.personService.getMapFirstNamesToOccurrences(), HttpStatus.OK);
    }

}
