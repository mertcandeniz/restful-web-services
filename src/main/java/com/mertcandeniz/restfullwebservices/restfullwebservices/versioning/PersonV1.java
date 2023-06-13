package com.mertcandeniz.restfullwebservices.restfullwebservices.versioning;

public class PersonV1 {

    private String name;

    public PersonV1() {
    }
    public PersonV1(String name) {
        this.name = name;
    }
    public String getNane() {
        return name;
    }

    public void setNane(String nane) {
        this.name = nane;
    }
}
