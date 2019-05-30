package br.com.beirario.campeonatosvt.adapters;

import android.content.Context;
import android.view.View;

import java.util.List;

import br.com.beirario.campeonatosvt.models.RaceSteps;

public class StepAdapter extends OneLineAdapter<RaceSteps> {

    private Context context;

    public StepAdapter(Context context, List<RaceSteps> items) {
        super(items);
        this.context = context;
    }

    @Override
    public void onClick(View view, int i) {

    }

    @Override
    public boolean onLongClick(View view, int i) {
        return false;
    }
}
