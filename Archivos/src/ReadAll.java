import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadAll {
    public static void main() {
        var nameFile = "MiPrimerArchivo.txt";
        try{
            List<String> lines = Files.readAllLines(Paths.get(nameFile));
            System.out.println("Contenido: ");
            for (String line : lines) {
                System.out.println(line);
            }
        }
        catch (Exception e) {   
            System.out.println("error: " + e.getMessage());
        }
    }
}
