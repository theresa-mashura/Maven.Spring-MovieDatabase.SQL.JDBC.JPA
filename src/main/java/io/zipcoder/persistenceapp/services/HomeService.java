package io.zipcoder.persistenceapp.services;

import io.zipcoder.persistenceapp.models.Home;
import io.zipcoder.persistenceapp.repositories.HomeRepository;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public Home insertHome(Home home) {
        return this.homeRepository.save(home);
    }

    public Home updateHome(Home home) {
        Home toUpdate = this.homeRepository.findById(home.getId());
        toUpdate.setAddress(home.getAddress());
        toUpdate.setHomenumber(home.getHomenumber());
        return this.homeRepository.save(toUpdate);
    }

    public Home findHomeById(Long id) {
        return this.homeRepository.findById(id);
    }

    public Home findHomeByHomeNumber(String homenumber) {
        return this.homeRepository.findByHomenumber(homenumber);
    }

    public Home findHomeByAddress(String address) {
        return this.homeRepository.findByAddress(address);
    }

    // FIND A HOME BY A PERSON ID
    public Long findHomeByPersonId(Long id) {
        return this.homeRepository.findByPersonId(id);
    }

    // ADD A PERSON TO A HOME

    // GENERATE LIST OF PEOPLE THAT LIVE IN A HOME

}
