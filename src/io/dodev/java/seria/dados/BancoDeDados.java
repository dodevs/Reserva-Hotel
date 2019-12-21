package io.dodev.java.seria.dados;

import io.dodev.java.seria.dom.Pessoa;
import io.dodev.java.seria.dom.Quarto;
import io.dodev.java.seria.dom.Reserva;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class BancoDeDados {
    private String tipo = null;
    private String pasta;
    private LinkedList<String> arquivos = new LinkedList<>();

    public BancoDeDados(String pasta, String tipo) {
        this.pasta = pasta;
        this.tipo = tipo;

        File file = new File(pasta);
        if( !file.exists()) {
            file.mkdir();
            file = new File(pasta + '/' + tipo);
            if(!file.exists()) file.mkdir();
        }
    }

    public abstract void carregar(HashMap<String, Pessoa> hmPessoas, HashMap<Integer, Quarto> hmQuartos, HashMap<Long, Reserva> hmReservas, HashMap<String, Long> hmIds) throws IOException;

    public abstract void salvar(HashMap<String, Pessoa> hmPessoas, HashMap<Integer, Quarto> hmQuartos, HashMap<Long, Reserva> hmReservas, HashMap<String, Long> hmIds) throws IOException;

    public String getTipo() {
        return tipo;
    }

    public String getPasta() {
        return pasta;
    }

    public void addArquivo(String arquivo) {
        this.arquivos.add(arquivo);
    }

    public String getArquivo(int i) {
        return this.arquivos.get(i);
    }

    public int getArquivosSize() {
        return this.arquivos.size();
    }

    public void salvaMeta() throws IOException {

        File meta_f = new File((pasta + '/' + "meta.cfg"));

        if(meta_f.exists()) {
            meta_f.delete();
        }

        FileWriter meta = new FileWriter(pasta + '/' + "meta.cfg");
        PrintWriter meta_w = new PrintWriter(meta);

        meta_w.printf("%s%n", tipo);
        for (String nomeArq : arquivos) {
            meta_w.printf("%s%n", nomeArq);
        }

        meta_w.close();
    }

    public void carregaMeta() throws IOException {
        File meta_f = new File(pasta + '/' +"meta.cfg");

        if(meta_f.exists()) {
            FileReader meta = new FileReader(meta_f);
            BufferedReader meta_r = new BufferedReader(meta);

            String linha = meta_r.readLine();

            this.tipo = linha;

            while (linha != null) {
                this.arquivos.add(linha);
                linha = meta_r.readLine();
            }

            meta_r.close();
        }
    }
}
