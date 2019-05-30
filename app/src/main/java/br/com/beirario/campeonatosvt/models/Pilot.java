package br.com.beirario.campeonatosvt.models;

import java.io.Serializable;

public class Pilot implements Serializable {

    private String name;

    public Pilot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
