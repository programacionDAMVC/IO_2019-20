package teoria.outputstream;

import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("ficheros/entrada/elquijote.txt"));
              BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("ficheros/salida/ejercicio2.txt"))) {
            while (in.hasNextLine()) {
                out.write(in.nextLine().toUpperCase().getBytes());
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fin de programa");

    }
}
