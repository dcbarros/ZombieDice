package com.zombiedice.model;

public class Zombie {
    private String name;
    private Integer brains;

    public Zombie(String name) {
        this.name = name;
        this.brains = 0;
    }

    public Zombie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBrains() {
        return brains;
    }

    public void setBrains(Integer brains) {
        this.brains = brains;
    }

    

    
}
