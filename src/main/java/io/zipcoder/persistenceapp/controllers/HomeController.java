package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Home;
import io.zipcoder.persistenceapp.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.List;

@RestController
public class HomeController {

    private HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ResponseEntity<Home> createPerson(@RequestBody Home home) {
        return new ResponseEntity<>(this.homeService.insertHome(home), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/home", method = RequestMethod.PUT)
    public ResponseEntity<Home> updateHome(@RequestBody Home homeUpdated) {
        return new ResponseEntity<>(this.homeService.updateHome(homeUpdated), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Home> deletePerson(@PathVariable Long id) {
        this.homeService.removeHome(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/home/delete-list", method = RequestMethod.DELETE)
    public ResponseEntity<List<Home>> deleteManyHomes(@RequestBody List<Home> homes) {
        this.homeService.removeHomes(homes);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/home/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Home> findHomeById(@PathVariable Long id) {
        return new ResponseEntity<>(this.homeService.findHomeById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ResponseEntity<List<Home>> findAllHomes() {
        return new ResponseEntity<>(this.homeService.findAllHomes(), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/home-number/{homeNumber}", method = RequestMethod.GET)
    public ResponseEntity<Home> findHomeByHomeNumber(@PathVariable String homeNumber) {
        return new ResponseEntity<>(this.homeService.findHomeByHomeNumber(homeNumber), HttpStatus.OK);
    }

    @RequestMapping(value = "/home/address/{address}", method = RequestMethod.GET)
    public ResponseEntity<Home> findHomeByAddress(@PathVariable String address) {
        return new ResponseEntity<>(this.homeService.findHomeByAddress(address), HttpStatus.OK);
    }
}
