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
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
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
        return new ResponseEntity<>(this.personService.findPersonByLastName(lastName), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/surname", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Person>>> getSurnameReport() {
        return new ResponseEntity<>(this.personService.getMapLastNamesToPeopleList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/firstname/stats", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getFirstNamesReport() {
        return new ResponseEntity<>(this.personService.getMapFirstNamesToOccurrences(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/firstname/{firstName}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPersonByFirstName(@PathVariable String firstName) {
        return new ResponseEntity<>(this.personService.findPersonByFirstName(firstName), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/delete-list", method = RequestMethod.DELETE)
    public ResponseEntity<List<Person>> deleteManyPeople(@RequestBody List<Person> people) {
        this.personService.deletePeople(people);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/people/{personId}/home/{homeId}", method = RequestMethod.PUT)
    public ResponseEntity<Person> addPersonToAHome(@PathVariable Long personId, @PathVariable Long homeId) {
        return new ResponseEntity<>(this.personService.addPersonToHome(homeId, personId), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{personId}/home", method = RequestMethod.GET)
    public ResponseEntity<Long> findHomeByPerson(@PathVariable Long personId) {
        return new ResponseEntity<>(this.personService.findHomeByPersonId(personId), HttpStatus.OK);
    }

    @RequestMapping(value = "/people/all/home/{homeId}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPeopleInAHome(@PathVariable Long homeId) {
        return new ResponseEntity<>(this.personService.getListPeopleInAHome(homeId), HttpStatus.OK);
    }

}
