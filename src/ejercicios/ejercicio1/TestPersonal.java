package ejercicios.ejercicio1;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TestPersonal {
    private static Scanner sc = new Scanner(System.in);
    private static Personal personal = null;
    public static void main(String[] args) {
        File file = null;
        while (true) {
            System.out.println("Introduce el nombre del fichero");
            file = new File("ficheros/ejercicio1/" + sc.next());
            if (file.exists())
                break;
        }
        //System.out.println(file + "  - " + file.length());
        Path path = file.toPath();
        try {
            List<Persona> listaPersonas = Auxiliar.obtenerListaPersonasDeFichero(path);
            //listaPersonas.forEach(System.out::println);
            personal = new Personal(listaPersonas);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int iOpcion = -1;
        while (true){
            mostrarMenu();
            System.out.println("introduce opción");
            String sOpcion = sc.next();
          //  int opcion = sc.nextInt();
            if (sOpcion.matches("[0-7]"))
                iOpcion = Integer.parseInt(sOpcion);

            switch (iOpcion) {
                case 0:
                    salir();
                    break;
                case 1:
                    boolean resultado1 = borrarPersona();
                    System.out.printf("Éxito de borrado: %B%n", resultado1);
                    break;
                case 2:
                    List<Persona> lista1 = solicitarPais();
                    for (Persona persona: lista1) {
                        System.out.println(persona);
                    }
                    break;
                case 3:
                    List<Persona> lista2 = solicitarGenero();
                    for (Persona persona: lista2) {
                        System.out.println(persona);
                    }
                    break;
                case 4:
                    boolean resultado2 = borrarPersonaPorEmail();
                    System.out.printf("Éxito de borrado: %B%n", resultado2);
                    break;
                case 5:
                    int resultado3 = solicitarEdad();
                    System.out.printf("Nº de valores superior a esa edad: %d%n", resultado3);
                    break;
                case 6:
                    boolean resultado5 = annadirPersona();
                    System.out.printf("Éxito de borrado: %B%n", resultado5);
                    break;
                case 7:
                    boolean resultado4 = actualizarEmail();
                    System.out.printf("Éxito de borrado: %B%n", resultado4);
                    break;
                default:
            }
       }

    }

    private static boolean actualizarEmail() {
        String emailAntiguo ="", emailNuevo="";
        while (true) {
            System.out.println("Introduce email antiguo");
            emailAntiguo =sc.next();
            if (emailAntiguo.matches("[a-zA-Z0-9\\.]{1,}@[a-zA-Z0-9]{1,}\\.[a-z]{2,3}"))
                break;
        }
        while (true) {
            System.out.println("Introduce email nuevo");
            emailNuevo =sc.next();
            if (emailNuevo.matches("[a-zA-Z0-9\\.]{1,}@[a-zA-Z0-9]{1,}\\.[a-z]{2,3}"))
                break;
        }
        return personal.actualizarCorreo(emailAntiguo, emailNuevo);
    }

    private static boolean annadirPersona() {
        //Durant,Phythian,dphythian0@nasa.gov,Male,1998/01/15,Brazil
        String firstName = "";
        String lastName = "";
        while (true) {
            System.out.println("Introduce first name");
            firstName = sc.next();
            if (Auxiliar.checkConjuntoCaracteres(firstName))
                break;
        }
        while (true){
            System.out.println("Introduce last name");
            lastName = sc.next();
            if (Auxiliar.checkConjuntoCaracteres(lastName))
                break;
        }
        String email = "";
        while (true) {
            System.out.println("Introduce email");
            email =sc.next();
            if (email.matches("[a-zA-Z0-9\\.]{1,}@[a-zA-Z0-9]{1,}\\.[a-z]{2,3}"))
                break;
        }
        String genero = "";
        while (true) {
            System.out.println("Introduce genero");
            genero = sc.next();
            if (genero.toLowerCase().matches("male|famale"))
                break;
        }
        String sBirthday = "";
        while (true) {
            System.out.println("Introduce birthday yyyy/mm/dd");
            sBirthday = sc.next();
            if (sBirthday.matches("\\d{4}/\\d{2}/\\d{2}" ))
                break;
        }
        LocalDate lBirthday = LocalDate.parse(sBirthday, Auxiliar.formatter);
        String pais = "";
        while (true) {
            System.out.println("Introduce country");
            pais = sc.next();
            if (Auxiliar.checkConjuntoCaracteres(pais))
                break;
        }
        Persona persona =  new Persona(firstName, lastName, email, genero, lBirthday, pais);
        return personal.annadirPersona(persona);
    }

    private static int solicitarEdad() {
        int edad = 0;
        while (true) {
            System.out.println("Introduce una edad:");
            String sEdad = sc.next();
            if (sEdad.matches("[0-9]{1,2}")){
                edad = Integer.parseInt(sEdad);
                break;
            }

        }

            return personal.obtenerNumeroPersonasEdadSuperior(edad);
    }

    private static boolean borrarPersona() {
        String firstName = "";
        String lastName = "";
        while (true) {
            System.out.println("Introduce first name");
            firstName = sc.next();
            if (Auxiliar.checkConjuntoCaracteres(firstName))
                break;
        }
        while (true){
            System.out.println("Introduce last name");
            lastName = sc.next();
            if (Auxiliar.checkConjuntoCaracteres(lastName))
                break;
        }
        Persona persona =  new Persona(firstName, lastName, null, null, null, null);
        return  personal.eliminarPersona(persona);

    }

    private static List<Persona> solicitarGenero() {
        String genero = "";
        while (true) {
            System.out.println("Introduce genero");
            genero = sc.next();
            if (genero.toLowerCase().matches("male|famale"))
                break;
        }
        return personal.listarPersonasPorGenero(genero);
    }

    private static List<Persona> solicitarPais() {
        String pais = "";
        while (true) {
            System.out.println("Introduce country");
            pais = sc.next();
            if (Auxiliar.checkConjuntoCaracteres(pais))
                break;
        }
        return personal.listarPersonasPorPais(pais);
    }

    private static boolean borrarPersonaPorEmail() {
        String email = "";
        while (true) {
            System.out.println("Introduce email");
            email =sc.next();
            if (email.matches("[a-zA-Z0-9\\.]{1,}@[a-zA-Z0-9]{1,}\\.[a-z]{2,3}"))
                break;
        }
        return  personal.eliminarPersonaPorEmail(email);
    }

    private static void salir() {
        Auxiliar.escribirFicheroPersonas(personal.getListPersonas());
        sc.close();
        System.out.println("Terminado programa");
        System.exit(0);
    }

    private static void mostrarMenu() {
        System.out.println("0 Salir de la aplicación");
        System.out.println("1 Borrar un objeto Persona");
        System.out.println("2 Solicitar un paı́s");
        System.out.println("3 Solicitar género");
        System.out.println("4 Borrar un objeto Persona por email");
        System.out.println("5 Solicitar una edad");
        System.out.println("6 Añadir un nuevo objeto Persona");
        System.out.println("7 Actualizar el email de un objeto Persona\n");

    }
}
