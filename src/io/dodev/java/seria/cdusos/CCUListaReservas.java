package io.dodev.java.seria.cdusos;

import io.dodev.java.seria.dados.BaseDeDados;
import io.dodev.java.seria.dom.Reserva;
import io.dodev.java.seria.util.ConsoleIO;

import java.io.IOException;
import java.util.Collection;

public class CCUListaReservas {

    public static void executar(BaseDeDados baseDados) throws IOException {
        Collection<Reserva> reservas = baseDados.getReservas();

        ConsoleIO.cls();
        System.in.read();

        for (Reserva r: reservas) {
            System.out.printf("ID Reserva: %d\n", r.getId());
            System.out.println("Pessoa:");
            System.out.printf("\tNome: %s\n", r.getPessoa().getNome());
            System.out.printf("\tCPF: %s\n", r.getPessoa().getCpf());
            System.out.println("Quarto:");
            System.out.printf("\tNumero: %d\n", r.getQuarto().getNumero());
            System.out.printf("\tAndar: %d\n", r.getQuarto().getAndar());
            System.out.printf("Estado: %s\n", r.getEstadoReserva());
        }

        System.out.println("Pressione <Enter> para voltar");
        System.in.read();
        CCUConsultas.executar(baseDados);
    }
}
