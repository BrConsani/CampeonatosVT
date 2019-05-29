package activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.beirario.campeonatovt.R;
import ui.Views;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void onClickAddButton(View view){
        Dialog d = Views.createChampionshipDialog(this, ((dialog, which) -> {
            //TODO create championship logic
        }), (dialog, which) -> dialog.dismiss());
        d.show();
    }
}
