package br.com.beirario.campeonatosvt.activities;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.adapters.OneLineAdapter;
import br.com.beirario.campeonatosvt.adapters.RaceAdapter;
import br.com.beirario.campeonatosvt.adapters.TestAdapter;
import br.com.beirario.campeonatosvt.models.Race;
import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.models.Test;
import br.com.beirario.campeonatosvt.ui.Dialogs;
import br.com.beirario.campeonatovt.R;

public class RaceActivity extends AppCompatActivity {

    private Test test;
    private OneLineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        test = (Test) getIntent().getSerializableExtra(Program.JSON_TEST);
        test = Program.getInstance().getTest(test);

        adapter = new RaceAdapter(this, test);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void OnClickAddButton(View view){
        Dialogs.DialogBuilder builder = new Dialogs.OneEditTextDialog(this, R.string.title_create_race,
                R.string.body1_create_race, R.string.hint_race);
        builder.setPositiveButton(R.string.btn_create, ((dialog, which) -> {
            EditText name = ((AlertDialog) dialog).findViewById(R.id.edt_default);
            test.addRace(new Race(name.getText().toString(), test));
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
