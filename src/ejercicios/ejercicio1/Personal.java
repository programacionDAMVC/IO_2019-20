package ejercicios.ejercicio1;

import sun.management.counter.perf.PerfStringCounter;

import java.util.ArrayList;
import java.util.List;

public class Personal {
    private  List<Persona> listPersonas;

    public Personal(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public boolean annadirPersona(Persona persona) {
        return listPersonas.add(persona);
    }
    public boolean eliminarPersona(Persona persona) {
        return listPersonas.remove(persona);
    }
    public List<Persona> listarPersonasPorPais(String pais) {
        List<Persona> listaPersonasPorPais = new ArrayList<>();
        for (Persona persona: listPersonas) {
            if (persona.getCountry().equalsIgnoreCase(pais))
                listaPersonasPorPais.add(persona);
        }
        return listaPersonasPorPais;
    }
    public List<Persona> listarPersonasPorGenero(String genero) {
        List<Persona> listaPersonasPorGenero = new ArrayList<>();
        for (Persona persona: listPersonas) {
            if (persona.getGender().equalsIgnoreCase(genero))
                listaPersonasPorGenero.add(persona);
        }
        return listaPersonasPorGenero;
    }
    public boolean eliminarPersonaPorEmail (String email) {
        for (Persona persona: listPersonas) {
            if (persona.getEmail().equalsIgnoreCase(email))
                return listPersonas.remove(persona); //Corie,Quibell,cquibellh@g.co,Female,1994/07/12,Philippines

        }
        return  false;
    }
    public int obtenerNumeroPersonasEdadSuperior(int edad) {
        int contador = 0;
        for (Persona persona: listPersonas) {
            if (Auxiliar.calcularAnnosTranscurridos(persona.getBirthday()) > edad)
                contador++;
        }
        return contador;
    }
    public boolean actualizarCorreo(String emailAntiguo, String emailNuevo) {
        for (Persona persona: listPersonas) {
            if (persona.getEmail().equalsIgnoreCase(emailAntiguo)) {
                persona.setEmail(emailNuevo);
                return true;
            }
        }
        return false;
    }
}
