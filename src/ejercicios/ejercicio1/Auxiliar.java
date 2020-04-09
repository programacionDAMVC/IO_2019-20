package ejercicios.ejercicio1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auxiliar {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    public static int calcularAnnosTranscurridos(LocalDate fecha) {
        //Period period = Period.between(fecha, LocalDate.now());
       // return period.getYears();
        return Period.between(fecha, LocalDate.now()).getYears();
    }

    public static List<Persona> obtenerListaPersonasDeFichero(Path path) throws IOException {
        List<Persona> listaPersonas = new ArrayList<>();
        List<String> lineas = Files.readAllLines(path);
        lineas.remove(0);
        for (String linea: lineas) {
            //Durant,Phythian,dphythian0@nasa.gov,Male,1998/01/15,Brazil según csv
            String[] tokens = linea.split(",");
            //fecha viene 1998/01/15 lo tenemos que convertir a 1998-01-15
            LocalDate birthday = LocalDate.parse(tokens[4], formatter);
            Persona persona = new Persona(tokens[0], tokens[1], tokens[2],tokens[3], birthday, tokens[5]);
            listaPersonas.add(persona);
        }
        return listaPersonas;
    }

    public static void escribirFicheroPersonas (List<Persona> listaPersonas) {
        //personal_fecha_hora.csv
        String nombreFichero = "ficheros/ejercicio1/personal_" + LocalDateTime.now().toString() + ".csv";
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(nombreFichero)))) {
            out.println("first_name,last_name,email,gender,birthday,country");
            out.flush();
            for (Persona persona: listaPersonas ) {
                out.println(persona);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkConjuntoCaracteres (String palabras){

        return palabras.toLowerCase().matches("[a-zñáéíóúü ]{2,}");
    }


    public static void main(String[] args) throws IOException {
       // System.out.println(calcularAnnosTranscurridos(LocalDate.of(2000, 4, 1)));
       /* List<Persona> lista = obtenerListaPersonasDeFichero(Paths.get("ficheros/entrada/personal.csv"));
        lista.forEach(System.out::println);
        escribirFicheroPersonas(lista);*/
        System.out.println(checkConjuntoCaracteres("amigo de amigos"));
    }
}
