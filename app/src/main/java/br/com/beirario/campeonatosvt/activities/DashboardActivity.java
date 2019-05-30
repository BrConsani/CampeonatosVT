package br.com.beirario.campeonatosvt.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.adapters.ChampionshipAdapter;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.ui.Views;
import br.com.beirario.campeonatovt.R;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChampionshipAdapter adapter = new ChampionshipAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void onClickAddButton(View view){
        Dialog d = Views.createChampionshipDialog(this, ((dialog, which) -> {
            EditText name = ((AlertDialog) dialog).findViewById(R.id.edt_championship);
            Program.getInstance().addChampionship(new Championship(name.getText().toString()));
            adapter.notifyItemInserted(adapter.getItemCount());
            dialog.dismiss();
        }), (dialog, which) -> dialog.dismiss());
        d.show();
    }
}
