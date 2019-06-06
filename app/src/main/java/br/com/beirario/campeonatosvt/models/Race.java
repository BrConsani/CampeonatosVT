package br.com.beirario.campeonatosvt.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Race implements Serializable {

    private Test owner;
    private String name;
    private Map<Pilot, Integer> positions = new HashMap<>();
    private Pilot fastTurn;

    public Race(String name, Test owner){
        this.name = name;
        this.owner = owner;
    }

    public String getName(){
        return name;
    }

    public Test getParent(){
        return owner;
    }

    public Map<Pilot, Integer> getPositions() {
        return orderDescend();
    }

    public void addPilot(Pilot pilot){
        positions.put(pilot, 0);
    }

    public void removePilot(Pilot pilot){
        positions.remove(pilot);
    }

    public void changePoints(Pilot pilot, int points){
        if(positions.containsKey(pilot)){
            positions.put(pilot, points);
        }
    }

    public Pilot getFastTurn() {
        return fastTurn;
    }

    public void setFastTurn(Pilot fastTurn) {
        this.fastTurn = fastTurn;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }

    private Map<Pilot, Integer> orderDescend(){
        List<Map.Entry<Pilot, Integer>> list = new LinkedList<>(positions.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        // Maintaining insertion order with the help of LinkedList
        Map<Pilot, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Pilot, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
