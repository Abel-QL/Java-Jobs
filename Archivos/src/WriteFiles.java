import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFiles {
    public static void main() {
        boolean anexar = false;
        var nameFile = "MiPrimerArchivo.txt";
        var file = new File(nameFile);
        try {
            anexar = file.exists();
            var exit = new PrintWriter(new FileWriter (nameFile, anexar));
            Scanner console = new Scanner (System.in);
            System.out.print("Ingrese el nuevo contenido del archivo: ");
            var content = console.nextLine();
            exit.println(content);
            exit.close();
        }catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
