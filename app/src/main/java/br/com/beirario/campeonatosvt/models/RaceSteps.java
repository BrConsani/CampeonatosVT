package br.com.beirario.campeonatosvt.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class RaceSteps implements Serializable {

    private String name;
    private List<Race> races = new ArrayList<>();
    private Pilot polePosition;

    public RaceSteps(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Race> getRaces(){
        return races;
    }

    public Pilot getPolePosition(){
        return polePosition;
    }

    public void setPolePosition(Pilot pilot){
        this.polePosition = pilot;
    }

    public void addRaces(Race race){
        races.add(race);
    }
}
