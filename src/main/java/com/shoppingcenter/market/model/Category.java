package com.shoppingcenter.market.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity

public class Category {

    private int id;
    private String name;

    @OneToMany
    private List<Item> itemId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemId() {
        return itemId;
    }

    public void setItemId(List<Item> itemId) {
        this.itemId = itemId;
    }
}

