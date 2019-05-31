package br.com.beirario.campeonatosvt.models;

import java.io.Serializable;

public class Discard implements Serializable {

    private int pair;
    private int odd;

    public Discard(int pair, int odd) {
        this.pair = pair;
        this.odd = odd;
    }

    public int getPair() {
        return pair;
    }

    public int getOdd() {
        return odd;
    }
}
