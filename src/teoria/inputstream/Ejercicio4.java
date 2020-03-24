package teoria.inputstream;


import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) {
      /*  String cadena = "cadena";
        int entero = 2;
        double racional = Math.PI;
        long enterolargo = 5L;
        char caracter = 'n';*/
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("ficheros/salida/ejercicio4.dat")))) {
          //  out.writeUTF(cadena);
            String cadena = in.readUTF();
            System.out.println(cadena);
          //  out.writeInt(entero);
            int entero = in.readInt();
            System.out.println(entero);
          //  out.writeDouble(racional);
            double racional = in.readDouble();
            System.out.println(racional);
         //   out.writeLong(enterolargo);
            long numeroLargo = in.readLong();
            System.out.println(numeroLargo);
         //   out.writeChar(caracter);
            char caracter = in.readChar();
            System.out.println(caracter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fin de programa");


    }
}
