package teoria.inputstream;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("ficheros/entrada/imagen1.jpg"));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("ficheros/salida/imagen1_copiada.jpg"));)
              {
            int byteLeido;
            while ((byteLeido = in.read()) != -1) {
                out.write(byteLeido);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Imagen copiada");
    }
}
