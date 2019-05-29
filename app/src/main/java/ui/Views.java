package ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import br.com.beirario.campeonatovt.R;

public class Views {

    @SuppressLint("InflateParams")
    public static Dialog createChampionshipDialog(AppCompatActivity context,
                                                  DialogInterface.OnClickListener positiveListener,
                                                  DialogInterface.OnClickListener negativeListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_create_championship, null));
        builder.setPositiveButton(R.string.btn_create, positiveListener);
        builder.setNegativeButton(R.string.btn_cancel, negativeListener);
        return builder.create();
    }


}
