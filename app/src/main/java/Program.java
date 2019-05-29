import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import models.Championship;

public class Program implements Serializable {

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
}
