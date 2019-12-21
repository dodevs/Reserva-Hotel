package io.dodev.java.seria.dados;

import io.dodev.java.seria.dom.Pessoa;
import io.dodev.java.seria.dom.Quarto;
import io.dodev.java.seria.dom.Reserva;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BaseDeDados {
    private HashMap<String, Pessoa> hmPessoas = new HashMap<>();
    private HashMap<Integer, Quarto> hmQuartos = new HashMap<>();
    private HashMap<Long, Reserva> hmReservas = new HashMap<>();
    private HashMap<String, Long> hmIds = new HashMap<>();

    private BancoDeDados bdd;

    public BaseDeDados(BancoDeDados bd) { this.bdd = bd; }

    public void carregar() throws IOException {
        bdd.carregar(hmPessoas, hmQuartos, hmReservas, hmIds);
    }

    public void salvar() throws IOException {
        bdd.salvar(hmPessoas, hmQuartos, hmReservas, hmIds);
    }

    /* IDS */
    public long getNewId(String table) {
        if(this.hmIds.containsKey(table)) {
            return this.hmIds.get(table) + 1;
        } else {
            return 0;
        }
    }
    public void setLastId(String table, long id) {
        this.hmIds.put(table, id);
    }

    /* Pessoa */
    public boolean pessoaExists(String cpf) {
        return this.hmPessoas.containsKey(cpf);
    }
    public Pessoa getPessoaByCPF(String cpf) {
        return this.hmPessoas.get(cpf);
    }
    public Collection<Pessoa> getPessoas() {
        return this.hmPessoas.values();
    }
    public void addPessoa(Pessoa p) {
        this.hmPessoas.put(p.getCpf(), p);
    }

    /* Quarto */
    public boolean quartoExists(int numero) {
        return this.hmQuartos.containsKey(numero);
    }
    public Quarto getQuartoByNumero(int numero) {
        return this.hmQuartos.get(numero);
    }
    public Collection<Quarto> getQuartos() {
        return this.hmQuartos.values();
    }
    public void addQuarto(Quarto q) {
        this.hmQuartos.put(q.getNumero(), q);
    }

    /* Reserva */
    public boolean reservaExists(long id) {
        return this.hmReservas.containsKey(id);
    }
    public Reserva getReservaById(long id) {
        return hmReservas.get(id);
    }
    public Collection<Reserva> getReservas() {
        Collection<Reserva> reservas = this.hmReservas.values();
        for (Reserva r : reservas) {
            Pessoa p = this.getPessoaByCPF(r.getCpf_pessoa());
            Quarto q = this.getQuartoByNumero(r.getNumero_quarto());
            r.setPessoa(p);
            r.setQuarto(q);
        }

        return reservas;
    }
    public void addReserva(Reserva r) {
        long id = this.getNewId("hmReservas");
        r.setId(id);
        this.hmReservas.put(id, r);
        this.setLastId("hmReservas", id);
    }
}
