package br.com.beirario.campeonatosvt.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import br.com.beirario.campeonatovt.R;

public class Views {

    public static class DialogBuilder{

        private AppCompatActivity context;
        private AlertDialog.Builder builder;

        //Default dialog constructor
        public DialogBuilder(AppCompatActivity context, @StringRes int message) {
            this.context = context;
            builder = new AlertDialog.Builder(context);
            builder.setMessage(message);
            setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.dismiss());
        }

        //Custom dialog constructor with Resource Layout
        public DialogBuilder(AppCompatActivity context,  @LayoutRes int layout, boolean customLayout) {
            this.context = context;
            builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = context.getLayoutInflater();
            builder.setView(inflater.inflate(layout, null));
            setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.dismiss());
        }

        public void setPositiveButton(@StringRes int label, DialogInterface.OnClickListener listener){
            builder.setPositiveButton(label, listener);
        }

        public void setNegativeButton(@StringRes int label, DialogInterface.OnClickListener listener){
            builder.setNegativeButton(label, listener);
        }

        public Dialog buildDialog(){
            return builder.create();
        }
    }
}
