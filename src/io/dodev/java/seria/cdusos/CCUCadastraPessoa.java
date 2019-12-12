package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.dom.Pessoa;
import io.dodev.java.seria.exceptions.DadoExistemteException;
import io.dodev.java.seria.util.ConsoleIO;
import io.dodev.java.seria.util.Empacotamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CCUCadastraPessoa {
    public static void executar(BaseDeDados baseDados) throws IOException {
        String nome, cpf;

        Scanner ler = new Scanner(System.in);
        System.in.read(); // Esvazia o buffer

        while(true) {
            ConsoleIO.cls();

            System.out.println("Cadastro de Pessoas\n");
            System.out.print("Informe o CPF:\n");
            cpf = ler.nextLine();

            if(cpf.equalsIgnoreCase("FIM"))
                break;
            else if(baseDados.pessoaExists(cpf)) {
                throw new DadoExistemteException("CPF ja cadastrado!");
            }

            System.out.print("Informe o nome da pessoa:\n");
            nome = ler.nextLine();

            Pessoa novaPessoa = new Pessoa(cpf,nome);
            baseDados.addPessoa(novaPessoa);

            ler.nextLine(); // esvazia o buffer do teclado
        }

        baseDados.salvar();
    }
}
