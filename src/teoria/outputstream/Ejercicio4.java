package teoria.outputstream;

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        String cadena = "cadena";
        int entero = 2;
        double racional = Math.PI;
        long enterolargo = 5L;
        char caracter = 'n';
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("ficheros/salida/ejercicio4.dat")))) {
            out.writeUTF(cadena);
            out.writeInt(entero);
            out.writeDouble(racional);
            out.writeLong(enterolargo);
            out.writeChar(caracter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fin de programa");

    }
}
