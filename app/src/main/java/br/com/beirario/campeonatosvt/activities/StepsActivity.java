package br.com.beirario.campeonatosvt.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.adapters.OneLineAdapter;
import br.com.beirario.campeonatosvt.adapters.StepAdapter;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.models.RaceSteps;
import br.com.beirario.campeonatosvt.ui.Views;
import br.com.beirario.campeonatovt.R;

public class StepsActivity extends AppCompatActivity {

    private Championship championship;
    private OneLineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        int indexChampionship = intent.getIntExtra(Program.ID_CHAMPIONSHIP, -1);
        if(indexChampionship == -1) finish();
        championship = Program.getInstance().getChampionships().get(indexChampionship);

        adapter = new StepAdapter(this, championship.getSteps());

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void OnClickAddButton(View view){
        Views.DialogBuilder builder = new Views.DialogBuilder(this, R.layout.dialog_create_step, true);
        builder.setPositiveButton(R.string.btn_create, ((dialog, which) -> {
            EditText name = ((AlertDialog) dialog).findViewById(R.id.edt_step);
            championship.addStep(new RaceSteps(name.getText().toString()));
            adapter.notifyItemInserted(adapter.getItemCount());
        }));
        builder.buildDialog().show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_inverse, R.anim.slide_out_inverse);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
