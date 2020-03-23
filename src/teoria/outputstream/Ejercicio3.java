package teoria.outputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("ficheros/salida/ejercicio3.txt", true)) {
            // 122 - 97 = 25
            // el mas pequeño sería 0, al sumar 97 nos daría 97
            // el mas grande sería 25, al sumar 97 nos daría 122
            // cualquier otro, ejemplo 5, al sumar 97 nos da 102
            Random random = new Random();
            int aleatorio = random.nextInt(26);
            int resultado = aleatorio + 97 ;
            System.out.printf("RESULTADO: %d%n", resultado );
            out.write((resultado + "").getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
