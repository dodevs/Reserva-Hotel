package io.dodev.java.seria.dom;

public enum EstadoReserva {
    ATIVA ("Ativa"),
    FINALIZADA ("Finalizada"),
    CANCELADA ("Cancelada");

    private final String name;

    EstadoReserva(String name) {
        this.name = name;
    }

    public boolean equalsName(String other) {
        return name.equals(other);
    }

    public String toString() {
        return this.name;
    }
}