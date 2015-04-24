package com.smartscore.modal;


/**
 * @author MohanRaj
 *
 */
public class Amenity {
    
    @Override
    public String toString() {
        return "Amenity [name=" + name + "]";
    }

    private String name;

    public String getName() {
        return name;
    }

    public Amenity(String name) {
        super();
        this.name = name;
    }

    public Amenity() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }
    

}
