package io.zipcoder.persistenceapp.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Home {

    @Id
    @GeneratedValue
    private Long id;
    private String address;
    private String homenumber;

    public Home() {
    }

    public Home(Long id, String address, String homenumber) {
        this.id = id;
        this.address = address;
        this.homenumber = homenumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public void setHomenumber(String homenumber) {
        this.homenumber = homenumber;
    }
}
