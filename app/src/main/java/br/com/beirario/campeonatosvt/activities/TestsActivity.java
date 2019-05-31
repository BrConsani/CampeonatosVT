package br.com.beirario.campeonatosvt.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import br.com.beirario.campeonatosvt.Program;
import br.com.beirario.campeonatosvt.models.RaceStep;
import br.com.beirario.campeonatosvt.ui.Views;
import br.com.beirario.campeonatovt.R;

public class TestsActivity extends AppCompatActivity {

    private RaceStep step;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
    }

    public void OnClickAddButton(View view){

    }

}
