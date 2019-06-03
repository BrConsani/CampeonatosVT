package br.com.beirario.campeonatosvt.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.beirario.campeonatovt.R;

public class Views {

    public static class DialogBuilder{

        private AppCompatActivity context;
        private AlertDialog.Builder builder;

        DialogBuilder(AppCompatActivity context) {
            this.context = context;
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

    public static class OneEditTextDialog extends DialogBuilder{

        public OneEditTextDialog(AppCompatActivity context, @StringRes int title, @StringRes int body, @StringRes int hint) {
            super(context);
            super.builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = context.getLayoutInflater();
            @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.dialog_one_edit_text, null);
            TextView txtTitle = view.findViewById(R.id.txt_title);
            txtTitle.setText(title);
            TextView txtBody = view.findViewById(R.id.txt_body);
            txtBody.setText(body);
            EditText editText = view.findViewById(R.id.edt_default);
            editText.setHint(hint);
            super.builder.setView(view);
            setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.dismiss());
        }

    }

    public static class MessageDialog extends DialogBuilder{

        public MessageDialog(AppCompatActivity context, @StringRes int message) {
            super(context);
            super.builder = new AlertDialog.Builder(context);
            super.builder.setMessage(message);
            setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.dismiss());
        }

    }

    public static class CustomLayoutDialog extends DialogBuilder{

        public CustomLayoutDialog(AppCompatActivity context, @LayoutRes int layout) {
            super(context);
            super.builder = new AlertDialog.Builder(context);
            LayoutInflater inflater = context.getLayoutInflater();
            super.builder.setView(inflater.inflate(layout, null));
            setNegativeButton(R.string.btn_cancel, (dialog, which) -> dialog.dismiss());
        }
    }


}
