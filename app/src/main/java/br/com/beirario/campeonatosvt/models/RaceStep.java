package br.com.beirario.campeonatosvt.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RaceStep implements Serializable {

    private String name;
    private List<RaceTest> tests = new ArrayList<>();

    public RaceStep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<RaceTest> getTests(){
        return tests;
    }

    public void addTest(RaceTest test){
        tests.add(test);
    }

    public void removeTest(RaceTest test){
        tests.remove(test);
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
