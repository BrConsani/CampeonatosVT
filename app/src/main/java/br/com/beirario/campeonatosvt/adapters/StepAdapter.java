package br.com.beirario.campeonatosvt.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.activities.TestsActivity;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.ui.Views;
import br.com.beirario.campeonatovt.R;

public class StepAdapter extends OneLineAdapter<Step> {

    private AppCompatActivity context;
    private Championship championship;

    public StepAdapter(AppCompatActivity context, Championship championship) {
        super(championship.getSteps());
        this.context = context;
        this.championship = championship;
    }

    @Override
    public void onClick(View view, int i) {
        Intent intent = new Intent(context, TestsActivity.class);
        intent.putExtra(Program.ID_STEP, championship.getSteps().get(i));
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public boolean onLongClick(View view, int i) {
        Views.DialogBuilder builder = new Views.DialogBuilder(context, R.string.body1_remove_step);
        builder.setPositiveButton(R.string.btn_remove, ((dialog, which) -> {
            championship.removeStep(championship.getSteps().get(i));
            notifyItemRemoved(i);
        }));
        builder.buildDialog().show();
        return false;
    }
}
