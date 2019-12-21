package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.dom.Pessoa;
import io.dodev.java.seria.util.ConsoleIO;

import java.io.IOException;
import java.util.Collection;

public class CCUListaPessoas {
    public static void executar(BaseDeDados baseDados) throws IOException {
        Collection<Pessoa> pessoas = baseDados.getPessoas();

        ConsoleIO.cls();
        System.in.read(new byte[System.in.available()]);

        for(Pessoa item: pessoas) {
            System.out.printf("Nome.........: %s\n", item.getNome());
            System.out.printf("CPF..........: %s\n", item.getCpf());
        }

        System.out.println("Pressione <Enter> para voltar");
        System.in.read();
        CCUConsultas.executar(baseDados);
    }
}
