package br.com.beirario.campeonatosvt.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test implements Serializable {

    private Step owner;
    private String name;
    private List<Race> races = new ArrayList<>();
    private Pilot polePosition;

    public Test(String name, Step parent) {
        this.name = name;
        this.owner = parent;
    }

    public String getName() {
        return name;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void addRace(Race race){
        races.add(race);
    }

    public void removeRace(Race race){
        races.remove(race);
    }

    public Pilot getPolePosition() {
        return polePosition;
    }

    public void setPolePosition(Pilot polePosition) {
        this.polePosition = polePosition;
    }

    public Step getParent(){
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return owner.equals(test.owner) &&
                name.equals(test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, name);
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
