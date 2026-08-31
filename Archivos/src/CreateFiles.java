import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFiles {
    public static void main(String[] args) {
        var nameFile = "MiPrimerArchivo.txt";
        var file = new File(nameFile);
        try {
        if (file.exists()) {
            System.out.println("El archivo ya existe brother, create otro o ponle otro nombre");
        }else   {
            var output = new PrintWriter(new FileWriter(file));
            output.close();
            System.out.println("se creo el archivo en: ");
        }
    } catch (IOException e) {
            System.out.println("Error al crear el archivo " + e);
        }
    }
    }

