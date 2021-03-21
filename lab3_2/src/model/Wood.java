package model;

import java.io.Serializable;

public class Wood implements Serializable {

    private int id;
    private String name;
    private float dencity;

    public Wood(int id, String name, float dencity) {
        this.id = id;
        this.name = name;
        this.dencity = dencity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getDencity() {
        return dencity;
    }

    @Override
    public String toString() {
        return "Wood{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dencity=" + dencity +
                '}';
    }

}
