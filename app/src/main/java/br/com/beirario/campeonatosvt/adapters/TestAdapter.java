package br.com.beirario.campeonatosvt.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.models.Test;
import br.com.beirario.campeonatosvt.ui.Views;
import br.com.beirario.campeonatovt.R;

public class TestAdapter extends OneLineAdapter<Test> {

    private AppCompatActivity context;
    private Step step;

    public TestAdapter(AppCompatActivity context, Step step) {
        super(step.getTests());
        this.context = context;
        this.step = step;
    }

    @Override
    public void onClick(View view, Test o) {

    }

    @Override
    public boolean onLongClick(View view, Test o) {
        Views.DialogBuilder builder = new Views.DialogBuilder(context, R.string.body1_remove_step);
        builder.setPositiveButton(R.string.btn_remove, ((dialog, which) -> {
            step.removeTest(o);
            notifyItemRemoved(step.getTests().indexOf(o));
        }));
        builder.buildDialog().show();
        return false;
    }
}
