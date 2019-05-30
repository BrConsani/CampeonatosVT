package br.com.beirario.campeonatosvt.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Championship implements Serializable {

    private String name;
    private List<RaceSteps> steps = new ArrayList<>();
    private List<Pilot> pilots  = new ArrayList<>();

    public Championship(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RaceSteps> getSteps(){
        return this.steps;
    }

    public void addStep(RaceSteps step){
        this.steps.add(step);
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void addPilots(Pilot pilot){
        this.pilots.add(pilot);
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
