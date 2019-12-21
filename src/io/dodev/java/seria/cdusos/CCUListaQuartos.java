package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.dom.Quarto;
import io.dodev.java.seria.util.ConsoleIO;
import io.dodev.java.seria.util.Empacotamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CCUListaQuartos {

    public static void executar(BaseDeDados baseDados) throws IOException {
        Collection<Quarto> quartos = baseDados.getQuartos();

        ConsoleIO.cls();
        System.in.read(new byte[System.in.available()]);

        for (Quarto item : quartos) {
            System.out.printf("Andar: %d\n", item.getAndar());
            System.out.printf("Numero: %d\n\n", item.getNumero());
        }

        System.out.println("Pressione <Enter> para voltar");
        System.in.read();
        CCUConsultas.executar(baseDados);
    }
}
