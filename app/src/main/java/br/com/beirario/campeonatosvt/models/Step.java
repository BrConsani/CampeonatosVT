package br.com.beirario.campeonatosvt.models;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Step implements Serializable {

    private Championship owner;
    private String name;
    private List<Test> tests = new ArrayList<>();

    public Step(String name, Championship owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public Championship getParent(){
        return owner;
    }

    public List<Test> getTests(){
        return tests;
    }

    public void addTest(Test test){
        tests.add(test);
    }

    public void removeTest(Test test){
        tests.remove(test);
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
        Step step = (Step) o;
        return Objects.equals(name, step.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
