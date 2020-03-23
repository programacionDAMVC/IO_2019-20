package teoria.inputstream;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {
      /*  try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("ficheros/entrada/tiempo1.csv"))) {
            int byteLeido;
            while ((byteLeido = in.read()) != -1)
                System.out.print((char) byteLeido);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try (BufferedReader in = new BufferedReader(new FileReader("ficheros/entrada/tiempo1.csv"))) {
            String linea;
            while ((linea = in.readLine()) != null)
                System.out.println(linea);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
