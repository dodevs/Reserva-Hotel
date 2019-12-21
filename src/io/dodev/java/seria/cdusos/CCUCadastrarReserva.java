package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.dom.EstadoReserva;
import io.dodev.java.seria.dom.Reserva;
import io.dodev.java.seria.exceptions.DadoNotOkException;
import io.dodev.java.seria.util.ConsoleIO;

import java.io.IOException;
import java.util.Scanner;

public class CCUCadastrarReserva {

    public static void executar(BaseDeDados baseDados) throws IOException {
        int numero_quarto;
        String cpf_pessoa;

        Scanner ler = new Scanner(System.in);

        while (true) {
            ConsoleIO.cls();
            ler.nextLine(); // esvazia o buffer do teclado

            System.out.println("Informe o cpf da pessoa, FIM para encerrar:\n");
            cpf_pessoa = ler.nextLine();

            if(cpf_pessoa.equalsIgnoreCase("FIM"))
                break;
            else if(!baseDados.pessoaExists(cpf_pessoa)) {
                throw new DadoNotOkException("O cpf informado nao existe na base de dados!");
            }

            System.out.println("\nInforme o numero do quarto");
            numero_quarto = ler.nextInt();

            if(!baseDados.quartoExists(numero_quarto)) {
                throw new DadoNotOkException("O numero informado nao existe na base de dados!");
            }

            Reserva novaReserva = new Reserva(cpf_pessoa, numero_quarto);
            novaReserva.setEstadoReserva(EstadoReserva.ATIVA);

            baseDados.addReserva(novaReserva);
        }

        baseDados.salvar();
    }
}
