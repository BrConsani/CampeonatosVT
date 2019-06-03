package br.com.beirario.campeonatosvt.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.activities.TestsActivity;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.ui.Dialogs;
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
    public void onClick(View view, Step o) {
        Intent intent = new Intent(context, TestsActivity.class);
        intent.putExtra(Program.ID_STEP, o);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public boolean onLongClick(View view, Step o) {
        Dialogs.DialogBuilder builder = new Dialogs.MessageDialog(context, R.string.body1_remove_step);
        builder.setPositiveButton(R.string.btn_remove, ((dialog, which) -> {
            championship.removeStep(o);
            notifyItemRemoved(championship.getSteps().indexOf(o));
        }));
        builder.buildDialog().show();
        return false;
    }
}
