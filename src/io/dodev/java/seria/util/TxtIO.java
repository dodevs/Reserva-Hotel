package io.dodev.java.seria.util;

import io.dodev.java.seria.dom.Pessoa;

import java.io.*;
import java.util.ArrayList;

public class TxtIO {

    public static void Export() throws IOException {
        ArrayList<Object> pessoas = Empacotamento.lerArquivoBinario("dados.dat");

        FileWriter arq = new FileWriter("export.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        int i = 1;
        int n = pessoas.size();

        for (Object item: pessoas) {
            System.out.printf("Exportando %dº registro de %d: %s\n", i++, n, ((Pessoa)item).getNome());

//            gravarArq.printf(
//                    "Nome|%s;Peso Corporal|%.2f;Altura|%.2f;IMC|%.2f;Interpretacao|%s%n",
//                    ((Pessoa)item).getNome(),
//                    ((Pessoa)item).getPc(),
//                    ((Pessoa)item).getAlt(),
//                    ((Pessoa)item).IMC(),
//                    ((Pessoa)item).interpretaIMC()
//            );
        }
        gravarArq.close();
        System.out.print("Exportacao realizada com sucesso!\n");
    }

    public static void Import() throws IOException {
        FileReader arq = new FileReader("export.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        
        int i = 1, j, n;
        
        String linha = lerArq.readLine();
        
        while (linha != null) {
            System.out.printf("Ficha nº: %d\n", i++);

            n = linha.length();

            for (j = 0; j < n; j++) {
                if (linha.charAt(j) == '|')
                    System.out.print(": ");
                else if (linha.charAt(j) == ';')
                    System.out.print("\n");
                else
                    System.out.printf("%c", linha.charAt(j));
            }

            System.out.printf("\n\n");
            linha = lerArq.readLine();
        }

        lerArq.close();
    }
}
