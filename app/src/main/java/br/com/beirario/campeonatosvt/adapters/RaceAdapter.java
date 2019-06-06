package br.com.beirario.campeonatosvt.adapters;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.beirario.campeonatosvt.models.Race;
import br.com.beirario.campeonatosvt.models.Test;
import br.com.beirario.campeonatosvt.ui.Dialogs;
import br.com.beirario.campeonatovt.R;

public class RaceAdapter extends OneLineAdapter<Race> {

    private AppCompatActivity context;
    private Test test;

    public RaceAdapter(AppCompatActivity context, Test test) {
        super(test.getRaces());
        this.context = context;
        this.test = test;
    }

    @Override
    public void onClick(View view, Race o) {

    }

    @Override
    public boolean onLongClick(View view, Race o) {
        Dialogs.DialogBuilder builder = new Dialogs.MessageDialog(context, R.string.body1_remove_race);
        builder.setPositiveButton(R.string.btn_remove, ((dialog, which) -> {
            test.removeRace(o);
            notifyItemRemoved(test.getRaces().indexOf(o));
        }));
        builder.buildDialog().show();
        return false;
    }
}
