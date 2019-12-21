package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.dom.Quarto;
import io.dodev.java.seria.util.ConsoleIO;
import io.dodev.java.seria.util.Empacotamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CCUCadastraQuarto {
    public static void executar(BaseDeDados baseDados) throws IOException {
        int andar, numero;

        Scanner ler = new Scanner(System.in);

        while(true) {
            ConsoleIO.cls();
            ler.nextLine(); // esvazia o buffer do teclado

            System.out.printf("\nInforme o numero do quarto, FIM para encerrar:");
            String numero_str = ler.nextLine();

            if(numero_str.equalsIgnoreCase("FIM")) {
                break;
            }

            numero = Integer.parseInt(numero_str);

            System.out.printf("Informe o andar do quarto:\n");
            andar = ler.nextInt();

            Quarto novoQuarto = new Quarto(andar, numero);
            baseDados.addQuarto(novoQuarto);
        }

        baseDados.salvar();
    }
}
