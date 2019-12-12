package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BancoDeDados;
import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.dados.BdOBJ;
import io.dodev.java.seria.util.ConsoleIO;

import java.io.IOException;
import java.util.Scanner;

public class CCUSistema {
    private static BaseDeDados baseDados;

    public static void iniciar() throws IOException {
        BancoDeDados bdd = new BdOBJ("bdClientes/");
        baseDados = new BaseDeDados(bdd);
        baseDados.carregar();

        Scanner ler = new Scanner(System.in);

        while (ler.hasNextInt()) {
            ler.nextInt();
        }

        int opcao = 0;

        while (opcao != 3) {
            ConsoleIO.cls();

            System.out.println("Sistema de Reservas de HOTAL V1.0");

            System.out.println("1. Cadastros");
            System.out.println("2. Consultas");
            System.out.println("3. Sair");

            System.out.println("Escolha uma das opcoes e tecle <Enter>: ");

            switch (opcao){
                case 1:
                    CCUCadastros.executar(baseDados);
                    break;
                case 2:
                    CCUConsultas.executar(baseDados);
                    break;
            }

            opcao = ler.nextInt();
        }
    }
}
