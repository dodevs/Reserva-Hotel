package io.dodev.java.seria.dom;

import java.io.Serializable;

public class Quarto implements Serializable {
    private int andar, numero;

    public Quarto(int andar, int numero) {
        this.andar = andar;
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
