package br.com.beirario.campeonatosvt.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.adapters.OneLineAdapter;
import br.com.beirario.campeonatosvt.adapters.TestAdapter;
import br.com.beirario.campeonatosvt.models.Step;
import br.com.beirario.campeonatosvt.models.Test;
import br.com.beirario.campeonatosvt.ui.Dialogs;
import br.com.beirario.campeonatovt.R;

public class TestsActivity extends AppCompatActivity {

    private Step step;
    private OneLineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        step = (Step) getIntent().getSerializableExtra(Program.ID_STEP);
        step = Program.getInstance().getStep(step);

        adapter = new TestAdapter(this, step);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void OnClickAddButton(View view){
        Dialogs.DialogBuilder builder = new Dialogs.OneEditTextDialog(this, R.string.title_create_tests,
                R.string.body1_create_test, R.string.hint_test);
        builder.setPositiveButton(R.string.btn_create, ((dialog, which) -> {
            EditText name = ((AlertDialog) dialog).findViewById(R.id.edt_default);
            step.addTest(new Test(name.getText().toString(), step));
            //adapter.notifyItemInserted(adapter.getItemCount());
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
