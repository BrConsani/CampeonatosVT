package br.com.beirario.campeonatosvt.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RaceTest implements Serializable {

    private String name;
    private List<Race> races = new ArrayList<>();
    private Pilot polePosition;

    public RaceTest(String name) {
        this.name = name;
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
}
