package teoria.outputstream;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {

        int contadorProductos = 0, acumuladorCantidad = 0; //para acumular nº productos y acumular la cantidad de producto, lo pide el ejercicio

        //leemos el fichero con Scanner, esa va a ser la regla general para ficheros de texto, leer siempre con Scanner
        //nos da muchas posibilidades, mas que los Reader que hemos planteado en este tema.
        try (Scanner in = new Scanner(new File("ficheros/entrada/productos.csv")); //excepciones con java 1.7, los flujos siempre se cierran solos
             //definimos el flujo de salida para escribir en fichero, copiado de api java BufferedWriter, cambiando solo el nombre del fichero:
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ficheros/salida/productos.txt")))){
            while (in.hasNextLine()){
              //  System.out.println(in.nextLine()); lo primero que hago es comprobar que leeo correctamente el archivo, lo hago al principio y luego comento
              // 35;Tea - Black Currant;239-cp-76;South Africa   este es el formato que tengo, hago split por ;
              // tokens[0];tokens[1], tokens[2],tokens[3]  se van a leer como String
              String[] tokens = in.nextLine().split(";");
              //me interesa el token[0], primero hago programación segura, compruebo que es un ñúmero con expresión regular
              //sabido que es un número, lo transformo a int con Integer.parseInt, ya no puede saltar excepción
              //si ese valor es inferior a 10, me quedo con el mismo, en este caso me pide la cantidad y el código de producto que es tokens[2]
              if (tokens[0].matches("[0-9]+")){
                  int cantidad = Integer.parseInt(tokens[0]);
                  if (cantidad < 10) {
                      contadorProductos++;
                      acumuladorCantidad += cantidad;
                      String codigo = tokens[2];
                     // System.out.printf("Cantidad: %d - Código: %S%n", cantidad, codigo); comprobación de salida correcta, lo hago al principio y luego comento
                     //similar que enviar a consola, pero quito System para volcar al flujo, reocordar out es una referencia a PrintWriter, definida al principio
                      out.printf("Cantidad: %d - Código: %S%n", cantidad, codigo);  //esto va al fichero definido en el PrintWriter out = ....
                      out.flush(); //no olvidar nunca el flush
                  }
              }
            }

            out.printf("%n%nTOTAL PRODUCTOS: %d, CANTIDAD TOTAL: %d%n", contadorProductos, acumuladorCantidad); //esto va al fichero definido en el PrintWriter out = ....
            out.flush(); //no olvidar nunca el flush

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());  //después de saber que el programa funciona correctamente

        } catch (IOException e) {
         //   e.printStackTrace();
            System.out.println(e.getMessage());  //después de saber que el programa funciona correctamente
        }

        System.out.printf("FIN DE PROGRAMA");  //por lo menos dar un aviso
    }
}
