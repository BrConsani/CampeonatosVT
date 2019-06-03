package br.com.beirario.campeonatosvt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.models.Step;

public class Program implements Serializable {

    public static String ID_CHAMPIONSHIP = "id_championship";
    public static String ID_STEP = "id_step";

    private static Program mInstance;

    private List<Championship> championships = new ArrayList<>();

    private Program(){}

    public static Program getInstance(){
        if(mInstance == null) mInstance = new Program();
        return  mInstance;
    }

    public List<Championship> getChampionships() {
        return championships;
    }

    public Championship getChampionship(Championship o){
        return getChampionships().get(getChampionships().indexOf(o));
    }

    public Step getStep(Step o){
        Championship c = getChampionship(o.getParent());
        List<Step> steps = c.getSteps();
        return steps.get(steps.indexOf(o));
    }

    public void addChampionship(Championship championship){
        championships.add(championship);
    }

    public void removeChampionship(Championship championship){
        championships.remove(championship);
    }

    public void removeChampionship(int index){
        championships.remove(index);
    }
}
