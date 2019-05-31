package br.com.beirario.campeonatosvt.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Objects;

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

    @NonNull
    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return name.equals(pilot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
