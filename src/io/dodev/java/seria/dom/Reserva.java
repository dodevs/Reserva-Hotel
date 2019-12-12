package io.dodev.java.seria.dom;

import java.io.Serializable;

public class Reserva implements Serializable {

    private long id;
    private String cpf_pessoa;
    private int numero_quarto;
    private EstadoReserva estado;

    private transient Pessoa pessoa; // Virtual, nao sera serializado
    private transient Quarto quarto; // Virtual, ~

    public Reserva(String cpf_pessoa, int numero_quarto) {
        this.cpf_pessoa = cpf_pessoa;
        this.numero_quarto = numero_quarto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }

    public int getNumero_quarto() {
        return numero_quarto;
    }

    public void setNumero_quarto(int numero_quarto) {
        this.numero_quarto = numero_quarto;
    }

    public EstadoReserva getEstadoReserva() {
        return estado;
    }

    public void setEstadoReserva(EstadoReserva estado) {
        this.estado = estado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
}
