package io.dodev.java.seria.dom;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String cpf; // com transiente, nao será serializado

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
