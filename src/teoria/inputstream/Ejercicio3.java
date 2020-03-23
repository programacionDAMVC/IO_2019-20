package teoria.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("ficheros/entrada/tiempo2.csv"), "ISO-8859-1")) {
            while (in.hasNextLine())
                System.out.println(in.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
