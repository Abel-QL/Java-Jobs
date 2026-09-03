package Services;

import Domain.Snack;
import java.util.ArrayList;
import java.util.List;


public class ServiceSnacksList  implements IServiceSnacks {
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

    
    public void addSnack(Snack snack) {
        snacks.add(snack);
    }
    
    public  void showSnack() {
        StringBuilder stockSnacks = new StringBuilder();
        for (Snack snack : snacks) {
            stockSnacks.append(snack.toString()).append("\n");
        }
        System.out.println("--- Stock del punto ---");
        System.out.println(stockSnacks);
    }
    
    public  List<Snack> getSnacks() {
        return snacks;
    }
}
