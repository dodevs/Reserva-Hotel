package io.dodev.java.seria.util;

import java.io.*;
import java.util.ArrayList;

public class Empacotamento {

    // Serializacao
    public static void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
        File arq = new File(nomeArq);

        try {
            boolean result;
            result = arq.delete();
            result = arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            objOutput.close();
        } catch (IOException e) {
            System.out.printf("Erro: %s", e.getMessage());
        }
    }

    // Desserializacao
    public static ArrayList<Object> lerArquivoBinario(String nomeArq) {
        ArrayList<Object> lista = new ArrayList<>();

        try {
            File arq = new File(nomeArq);

            if(arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Object>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Erro: %s", e.getMessage());
        }

        return lista;
    }
}
