package teoria.miscelanea;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {
    private String nombre;
    private LocalDate fecha;

    public Persona(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format("%S, %s", nombre, fecha.toString());
    }
}
