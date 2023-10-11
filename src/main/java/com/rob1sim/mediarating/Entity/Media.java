package com.rob1sim.mediarating.Entity;


import jakarta.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description = "";
    private String imagePath = "";
    private float rating = 0;
    @ManyToOne
    private Type type;

    public Media(){}
    public Media name(String name){
        this.name = name;
        return this;
    }
    public Media type(Type type){
        this.type = type;
        return this;
    }
    public Media description(String Description){
        this.description = description;
        return this;
    }

    public Media image(String imagePath){
        this.imagePath = imagePath;
        return this;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Type getType() {
        return type;
    }

    public float getRating() {
        return rating;
    }
}
