package io.dodev.java.seria.dados;

import io.dodev.java.seria.dom.Pessoa;
import io.dodev.java.seria.dom.Quarto;
import io.dodev.java.seria.dom.Reserva;

import java.io.*;
import java.util.HashMap;

public class BdOBJ extends BancoDeDados {
    public BdOBJ(String pasta) throws IOException {
        super(pasta, "OBJ");
    }

    @Override
    public void carregar(HashMap<String, Pessoa> hmPessoas, HashMap<Integer, Quarto> hmQuartos, HashMap<Long, Reserva> hmReservas, HashMap<String, Long> hmIds) throws IOException {
        super.carregaMeta();

        for(int i = 0; i < this.getArquivosSize(); i++) {
            String nomeArq = this.getArquivo(i);

            File arq = new File(getPasta() + '/' + getTipo() + '/' + nomeArq);

            try {
                if(arq.exists()) {
                    ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                    switch (nomeArq) {
                        case "hmPessoas":
                            hmPessoas = (HashMap<String, Pessoa>) objInput.readObject();
                            break;
                        case "hmQuartos":
                            hmQuartos = (HashMap<Integer, Quarto>) objInput.readObject();
                            break;
                        case "hmReservas":
                            hmReservas = (HashMap<Long, Reserva>) objInput.readObject();
                            break;
                        case "hmIds":
                            hmIds = (HashMap<String, Long>) objInput.readObject();
                            break;
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void salvar(HashMap<String, Pessoa> hmPessoas, HashMap<Integer, Quarto> hmQuartos, HashMap<Long, Reserva> hmReservas, HashMap<String, Long> hmIds) throws IOException {
        this.addArquivo("hmPessoas");
        this.addArquivo("hmQuartos");
        this.addArquivo("hmReservas");
        this.addArquivo("hmIds");

        for (int i = 0; i < this.getArquivosSize(); i++) {
            String arq_name = this.getArquivo(i);
            File arq = new File(getPasta() + '/' + getTipo() + '/' + arq_name);
            try {
                arq.delete();
                arq.createNewFile();

                ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
                switch (arq_name){
                    case "hmPessoas":
                        objOutput.writeObject(hmPessoas);
                        break;
                    case "hmQuartos":
                        objOutput.writeObject(hmQuartos);
                        break;
                    case "hmReservas":
                        objOutput.writeObject(hmReservas);
                        break;
                    case "hmIds":
                        objOutput.writeObject(hmIds);
                        break;
                }

                objOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.salvaMeta();
    }
}
