package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.models.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

    Home findById(Long id);
    Home findByHomenumber(String homenumber);
    Home findByAddress(String address);

    //@Query(value = "SELECT p.homeId FROM Person p INNER JOIN Home h WHERE p.id = :id")
    //Long findByPersonId(@Param("id") Long id);
}
