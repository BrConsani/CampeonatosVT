package br.com.beirario.campeonatosvt.interfaces;

import android.view.View;

public class Listener {

    public interface onClickListener{

        void onClick(View view, int i);

        boolean onLongClick(View view, int i);
    }
}
