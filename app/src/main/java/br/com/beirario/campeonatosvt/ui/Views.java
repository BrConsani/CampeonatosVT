package br.com.beirario.campeonatosvt.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import br.com.beirario.campeonatovt.R;

public class Views {

    @SuppressLint("InflateParams")
    public static Dialog createChampionshipDialog(AppCompatActivity context,
                                                  DialogInterface.OnClickListener positiveListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = context.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_create_championship, null));
        builder.setPositiveButton(R.string.btn_create, positiveListener);
        builder.setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.dismiss());
        return builder.create();
    }

    public static Dialog removeChampionshipDialog(Context context,
                                                  DialogInterface.OnClickListener positiveListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.body1_remove_championship);
        builder.setPositiveButton(R.string.btn_remove, positiveListener);
        builder.setNegativeButton(R.string.btn_cancel, ((dialog, which) -> dialog.dismiss()));
        return builder.create();
    }
}
