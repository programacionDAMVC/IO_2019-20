package teoria.ultima;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        File file = new File("ficheros/entrada/productos.csv");
        if (!file.exists()){
            System.out.println("No existe el fichero");
            return;
        }
        System.out.printf("%S: %d bytes%n", file.getAbsolutePath(), file.length());
        File.createTempFile("fichero", "tmp");

        Path path = Paths.get("ficheros/entrada/productos.csv");
        System.out.println(path.getNameCount());
        Scanner in = new Scanner(path);
        File file1 = new File("..");
        File[] ficheros = file1.listFiles();
        for (File f: ficheros) {
            System.out.printf("%S - %d%n", f.getAbsolutePath(), f.length());
        }
    //    Files.copy(Paths.get("ficheros/entrada/productos.csv"), Paths.get("ficheros/salida/productos_back.csv"));
        List<String> lineas = Files.readAllLines(Paths.get("ficheros/salida/productos_back.csv"));
        for (String linea: lineas) {
            System.out.println(linea);
        }
    }
}
