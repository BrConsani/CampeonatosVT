package br.com.beirario.campeonatosvt.activities;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.adapters.OneLineAdapter;
import br.com.beirario.campeonatosvt.adapters.StepAdapter;
import br.com.beirario.campeonatosvt.models.Championship;
import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.ui.Dialogs;
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

        Championship o = (Championship) getIntent().getSerializableExtra(Program.JSON_CHAMPIONSHIP);
        championship = Program.getInstance().getChampionship(o);

        adapter = new StepAdapter(this, championship);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void OnClickAddButton(View view){
        Dialogs.DialogBuilder builder = new Dialogs.OneEditTextDialog(this,
                R.string.title_create_step, R.string.body1_create_step, R.string.hint_step);
        builder.setPositiveButton(R.string.btn_create, ((dialog, which) -> {
            EditText name = ((AlertDialog) dialog).findViewById(R.id.edt_default);
            championship.addStep(new Step(name.getText().toString(), championship));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.step_menu, menu);
        return true;
    }
}
