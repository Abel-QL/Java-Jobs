import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;
    //bloque inicializador sirve para inicializar la lsita de arriba
    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Tung tung droga sahur", 7000.00));
        snacks.add(new Snack("Cocaina", 420.00));
        snacks.add(new Snack("Marihuana", 40.00));
        snacks.add(new Snack("Crack", 90.00));
        snacks.add(new Snack("Fentanilo", 67.00));
        snacks.add(new Snack("Brownie", 70.00));
        
    }
    
    public static void AddSnack(Snack snack) {
        snacks.add(snack);
    }
    
    public static void showSnacks() {
        var stockSnacks ="";
        for (Snack snack : snacks) {
            stockSnacks += snack.toString() + "\n";
        }
        System.out.println("--- Stock del punto ---");
        System.out.println(stockSnacks);
    }
    
    public static List<Snack> getSnacks() {
        return snacks;
    }
}
