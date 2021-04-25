package io.zipcoder.persistenceapp.services;
import io.zipcoder.persistenceapp.models.Person;
import io.zipcoder.persistenceapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person insertPerson(Person person) {
        return this.personRepository.save(person);
    }

    public void deletePerson(Person person) {
        this.personRepository.delete(person);
    }

    public void deletePeople(List<Person> people) {
        this.personRepository.deleteInBatch(people);
    }

    public Person findPerson(Long id) {
        return this.personRepository.findOne(id);
    }

    public Person updatePerson(Long id, Person person) {
        Person toUpdate = this.personRepository.findOne(id);
        toUpdate.setFirstName(person.getFirstName());
        toUpdate.setLastName(person.getLastName());
        toUpdate.setMobile(person.getMobile());
        toUpdate.setHomeId(person.getHomeId());
        return this.personRepository.save(toUpdate);
    }

    public List<Person> findPersonByFirstName(String firstName) {
        return this.personRepository.findByFirstName(firstName);
    }

    public List<Person> findPersonByLastName(String lastName) {
        return this.personRepository.findByLastName(lastName);
    }

    public List<Person> findPersonByBirthday(Date birthday) {
        return this.personRepository.findByBirthday(birthday);
    }

    public Map<String, List<Person>> getMapLastNamesToPeopleList() {
        List<Person> people = this.personRepository.findAll();
        HashMap<String, List<Person>> map = new HashMap<>();
        for (Person p : people) {
            if (map.containsKey(p.getLastName())) {
                map.get(p.getLastName()).add(p);
            } else {
                List<Person> value = new ArrayList<Person>();
                value.add(p);
                map.put(p.getLastName(), value);
            }
        }
        return map;
    }

    public Map<String, Integer> getMapFirstNamesToOccurrences() {
        List<Person> people = this.personRepository.findAll();
        HashMap<String, Integer> map = new HashMap<>();
        for (Person p : people) {
            if (map.containsKey(p.getFirstName())) {
                map.put(p.getFirstName(), map.get(p.getFirstName()) + 1);
            } else {
                map.put(p.getFirstName(), 1);
            }
        }
    }


}
