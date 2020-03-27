package teoria.miscelanea;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Ejercicio2 {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ficheros/salida/ejercicio5.dat"))) {
            Persona p1 = new Persona("juanito", LocalDate.of(2000, 10, 10));
            Persona p2 = new Persona("felipe", LocalDate.now());
            oos.writeObject(p1);
            oos.writeObject(p2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fin de programa");
    }
}
