package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByFirstName(String firstName);
    List<Person> findAllByLastName(String lastName);
    List<Person> findAllByBirthday(Date birthday);
    List<Person> findAllByMobile(String mobile);
}
