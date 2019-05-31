package br.com.beirario.campeonatosvt.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.activities.StepsActivity;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.ui.Views;
import br.com.beirario.campeonatovt.R;

public class ChampionshipAdapter extends OneLineAdapter<Championship> {

    private AppCompatActivity context;

    public ChampionshipAdapter(AppCompatActivity context) {
        super(Program.getInstance().getChampionships());
        this.context = context;
    }

    @Override
    public void onClick(View view, int i) {
        Intent intent = new Intent(context, StepsActivity.class);
        intent.putExtra(Program.ID_CHAMPIONSHIP, Program.getInstance().getChampionships().get(i));
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public boolean onLongClick(View view, int i) {
        Views.DialogBuilder builder = new Views.DialogBuilder(context, R.string.body1_remove_championship);
        builder.setPositiveButton(R.string.btn_remove ,(dialog, which) -> {
            Program.getInstance().removeChampionship(i);
            this.notifyItemRemoved(i);
        });
        builder.buildDialog().show();
        return true;
    }
}
