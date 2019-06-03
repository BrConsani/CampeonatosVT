package br.com.beirario.campeonatosvt.interfaces;

import android.view.View;

public class ListenerInterface {

    public interface onClickListener<T>{

        void onClick(View view, T o);

        boolean onLongClick(View view, T o);
    }
}
