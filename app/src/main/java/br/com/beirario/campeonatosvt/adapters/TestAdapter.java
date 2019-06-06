package br.com.beirario.campeonatosvt.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.activities.BatteryActivity;
import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.models.Test;
import br.com.beirario.campeonatosvt.ui.Dialogs;
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
        Intent intent = new Intent(context, BatteryActivity.class);
        intent.putExtra(Program.JSON_TEST, o);
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public boolean onLongClick(View view, Test o) {
        Dialogs.DialogBuilder builder = new Dialogs.MessageDialog(context, R.string.body1_remove_test);
        builder.setPositiveButton(R.string.btn_remove, ((dialog, which) -> {
            step.removeTest(o);
            notifyItemRemoved(step.getTests().indexOf(o));
        }));
        builder.buildDialog().show();
        return false;
    }
}
