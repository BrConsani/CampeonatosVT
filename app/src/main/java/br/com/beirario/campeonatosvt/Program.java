package br.com.beirario.campeonatosvt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.beirario.campeonatosvt.models.Championship;

public class Program implements Serializable {

    public static String ID_CHAMPIONSHIP = "id_championship";


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
