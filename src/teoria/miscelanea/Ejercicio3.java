package teoria.miscelanea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio3 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ficheros/salida/ejercicio5.dat"))) {
            Persona p1 = (Persona) ois.readObject();
            System.out.println(p1);
            Persona p2 = (Persona) ois.readObject();
            System.out.println(p2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
