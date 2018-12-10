package com.example.cache.cachedemo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Customer implements Serializable {


    @SequenceGenerator(name="CUS_ID_GEN",sequenceName = "CUS_ID_SEQ",allocationSize = 1000, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CUS_ID_GEN")
    @Id
    private Long id;

    private String name;


    /**
     * Annotated the List element with @JsonIgnore to avoid serializing the List
     * Another approach to Load the entities in EAGER mode but that will be expensive
     *
     */
    @ElementCollection
    @JsonIgnore
    private List<String> wishList;

    public Customer(){

    }

    public Customer(String name, List wishList){
        this.name = name;
        this.wishList = wishList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWishList() {
        return wishList;
    }

    public void setWishList(List<String> wishList) {
        this.wishList = wishList;
    }

    @Override
    public String toString() {
        return getId() + " :: " + getName() + " :: " + getWishList().toArray().toString();
    }

}
