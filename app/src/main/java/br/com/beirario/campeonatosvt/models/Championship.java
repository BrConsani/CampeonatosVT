package br.com.beirario.campeonatosvt.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Championship implements Serializable {

    private String name;
    private List<Step> steps = new ArrayList<>();
    private List<Pilot> pilots  = new ArrayList<>();
    private Discard discard = new Discard(2,2);

    public Championship(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<Step> getSteps(){
        return this.steps;
    }

    public void addStep(Step step){
        this.steps.add(step);
    }

    public void removeStep(Step step){
        steps.remove(step);
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public void addPilots(Pilot pilot){
        this.pilots.add(pilot);
    }

    public void removePilot(Pilot pilot){
        this.pilots.remove(pilot);
    }

    public Discard getDiscard() {
        return discard;
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
        Championship that = (Championship) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
