package teoria.outputstream;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        String cadena = "\nesto es una cadena";
        try (FileOutputStream out = new FileOutputStream("ficheros/salida/ejercicio1.txt")) {
            out.write(97);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Programa finalizado");
    }
}
