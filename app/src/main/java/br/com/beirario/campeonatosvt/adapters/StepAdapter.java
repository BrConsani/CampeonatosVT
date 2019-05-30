package br.com.beirario.campeonatosvt.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

import br.com.beirario.campeonatosvt.models.RaceSteps;
import br.com.beirario.campeonatosvt.ui.Views;
import br.com.beirario.campeonatovt.R;

public class StepAdapter extends OneLineAdapter<RaceSteps> {

    private Context context;
    private List<RaceSteps> steps;

    public StepAdapter(Context context, List<RaceSteps> items) {
        super(items);
        this.context = context;
        this.steps = items;
    }

    @Override
    public void onClick(View view, int i) {

    }

    @Override
    public boolean onLongClick(View view, int i) {
        Views.DialogBuilder builder = new Views.DialogBuilder((AppCompatActivity) context, R.string.body1_remove_step);
        builder.setPositiveButton(R.string.btn_remove, ((dialog, which) -> {
            steps.remove(i);
            notifyItemRemoved(i);
        }));
        builder.buildDialog().show();
        return false;
    }
}
