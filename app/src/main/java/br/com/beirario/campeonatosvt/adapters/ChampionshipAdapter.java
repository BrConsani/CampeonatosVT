package br.com.beirario.campeonatosvt.adapters;


import android.content.Context;
import android.view.View;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.ui.Views;

public class ChampionshipAdapter extends OneLineAdapter<Championship> {

    private Context context;

    public ChampionshipAdapter(Context context) {
        super(Program.getInstance().getChampionships());
        this.context = context;
    }

    @Override
    public void onClick(View view, int i) {
        //TODO implement onClick
    }

    @Override
    public boolean onLongClick(View view, int i) {
        Views.removeChampionshipDialog(context, (dialog, which) -> {
            Program.getInstance().removeChampionship(i);
            this.notifyItemRemoved(i);
        }).show();
        return true;
    }
}
