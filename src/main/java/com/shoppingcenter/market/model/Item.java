package com.shoppingcenter.market.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity

public class Item {

    private int id;
    private String name;
    @ManyToOne
    private String categoryId;


}
