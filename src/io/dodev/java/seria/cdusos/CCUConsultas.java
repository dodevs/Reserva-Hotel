package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.util.ConsoleIO;

import java.io.IOException;
import java.util.Scanner;

public class CCUConsultas {
    public static void executar(BaseDeDados baseDados) throws IOException {

        char opcao = '*';

        while (opcao != '4') {

            ConsoleIO.cls();
            System.in.read(new byte[System.in.available()]); // Clear buffer

            System.out.println("Consultas:");
            System.out.println("1. Quartos");
            System.out.println("2. Pessoas");
            System.out.println("3. Reservas");
            System.out.println("4. Voltar");

            System.out.println("Escolha uma opcao e tecle <Enter>: ");

            switch (opcao) {
                case '1':
                    CCUListaQuartos.executar(baseDados);
                    break;
                case '2':
                    CCUListaPessoas.executar(baseDados);
                    break;
                case '3':
                    CCUListaReservas.executar(baseDados);
                    break;
            }

            opcao = (char)System.in.read();
        }
    }
}
