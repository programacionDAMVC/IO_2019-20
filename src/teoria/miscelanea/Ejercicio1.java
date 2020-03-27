package teoria.miscelanea;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio1 {
    public static void main(String[] args) {
        try (RandomAccessFile inOut = new RandomAccessFile("ficheros/salida/ejercici5.dat", "rw")) {
            for (int i = 0; i < 200; i++) {
                inOut.writeInt(i);
            }
            inOut.seek(0);
            System.out.println(inOut.readInt());
            System.out.println(inOut.readInt());
            inOut.seek(0);
            System.out.println(inOut.readLong());
            System.out.println(inOut.readLong());
            System.out.println(inOut.readInt());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
