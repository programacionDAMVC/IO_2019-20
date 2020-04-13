package ejercicios.ejercicio2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        int numero = generarRandomEntero();
        System.out.println(numero);
        List<Integer> listaEnteros = devolverDiezNumerosPrimos(numero);
        File fileOriginal = volcarDatosFichero(listaEnteros);
        System.out.println("Tamaño fichero " + fileOriginal.length());
        File fileCopia = crearCopiaSeguridad(fileOriginal);
        System.out.println("Tamaño fichero " + fileCopia.length());
        if (fileCopia.length() == fileOriginal.length())
            System.out.println("Los dos fichero tienen el mismo tamaño");
        mostrarPantallaFicheroBinario(fileOriginal);
        File fileLista = crearFicheroConLista(listaEnteros);
        System.out.println("Tamaño fichero " + fileLista.length());
        System.out.println(leerFicheroConLista(fileLista));

    }
    //Generamos un número entero aleatorio entre 0 y 100.
    public static int generarRandomEntero(){
        return new Random().nextInt(100);
    }
    //Buscamos los diez primeros primos a partir de ese número, ejemplo obtenemos de forma
    //aleatoria el 10, pues tendríamos 11, 13, 17
    public static List<Integer> devolverDiezNumerosPrimos(int numero) {
        List<Integer> listaPrimos = new ArrayList<>();
        int contadorPrimos = 0;
        do {
            numero++;
            if ( esPrimo(numero)){
                listaPrimos.add(numero);
                contadorPrimos++;
            }

        } while (contadorPrimos < 10);
        return listaPrimos;
    }

    private static boolean esPrimo(int numero) {
        for (int i = 2; i< numero; i++){
            if (numero % i == 0)
                return false;
        }
        return true;
    }
   // Volcamos esos números a un fichero binario, lógicamente no como texto, tenemos que
   // escribir como números enteros. A ese fichero binario le llamamos binario1.dat
    public static File volcarDatosFichero(List<Integer> listaEnteros){
        File fileOut = new File("ficheros/ejercicio2/binario1.dat");
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileOut))) {
            for (Integer numeroEntero: listaEnteros) {
                out.writeInt(numeroEntero);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileOut;
    }

    //Posteriormente, usando la clase Files, hacemos una copia de seguridad del mismo y lo
    //denominamos binario1_back.dat
    public static File crearCopiaSeguridad (File file) {
        File fileOut = new File("ficheros/ejercicio2/binario1_back.dat");
        try {
            Files.copy(file.toPath(), fileOut.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileOut;
    }
    //Leemos el fichero original, binario, con la correspondiente clase, recuerda que tienes que
    //leer datos de tipo entero. Los mostramos en pantalla
    public static void mostrarPantallaFicheroBinario (File file){
        try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            while (in.available() != 0)
                System.out.println(in.readInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Escogemos todos los números y los añadimos a una lista dináminca. Y esa lista, recuerda
    //que es un objeto y que la subclase de List debe implementar la interfaz Serializable, la
    //vamos a volcar a otro fichero binario, denominado binario2.dat
    public static File crearFicheroConLista(List<Integer> listaEnteros){
        File fileOut = new File("ficheros/ejercicio2/binario2.dat");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileOut))) {
          out.writeObject(listaEnteros);
          out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileOut;
    }

    //Posteriormente leemos el fichero con la correspondiente clase para poder hacer esto y lo
    //mostramos por pantalla.
    public static List<Integer> leerFicheroConLista(File file) {
        List<Integer> listaEnteros = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            listaEnteros = (List<Integer>) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaEnteros;
    }





}
