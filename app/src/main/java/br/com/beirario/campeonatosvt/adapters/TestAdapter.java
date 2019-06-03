package br.com.beirario.campeonatosvt.adapters;

import android.content.Context;
import android.view.View;

import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.models.Test;

public class TestAdapter extends OneLineAdapter<Test> {

    private Context context;

    public TestAdapter(Context context, Step step) {
        super(step.getTests());
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
