package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.util.ConsoleIO;

import java.io.IOException;
import java.util.Scanner;

public class CCUCadastros {

    public static void executar(BaseDeDados baseDados) throws IOException {
        ConsoleIO.cls();
        Scanner ler = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 4) {

            while (ler.hasNextInt()) {
                ler.nextInt();
            }

            System.out.println("####### Cadastros #######");

            System.out.println("1. Cadastrar Quarto\n");
            System.out.println("2. Cadastrar Pessoa\n");
            System.out.println("3. Cadastrar Reserva\n");
            System.out.println("4. Voltar\n");

            System.out.println("Escolha uma das opcoes acima e tecle <ENTER>: ");

            switch (opcao) {
                case 1:
                    CCUCadastraQuarto.executar(baseDados);
                    break;
                case 2:
                    CCUCadastraPessoa.executar(baseDados);
                    break;
                case 3:
                    CCUCadastrarReserva.executar(baseDados);
                    break;
            }

            opcao = ler.nextInt();
        }
    }
}
