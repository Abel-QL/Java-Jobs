import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnacksMachine {
    public static void main(String[] args) {
        snackMachine();
    }

    public static void snackMachine() {
        var exit = false;
        var console = new Scanner(System.in);
        //lista de productos niiga
        List<Snack> snacks = new ArrayList<>();
        System.out.println("--- PUNTO DE DROGA DYLON BABY 69 ---");
        Snacks.showSnacks();
        while (!exit) {
            try {
                var option = showMenu(console);
                exit = execOptions(option, console, snacks);


            } catch (Exception e) {
                System.out.println("EXPLOTO: " + e.getMessage() + " Tu codigo no sirve hermano, ¿que le vamos a hacer?");
            } finally {
                System.out.println();
            }
        }
    }

    private static int showMenu(Scanner console) {
        System.out.print("""
                +----------------------------+
                |        SNACK SHOP          |
                +----------------------------+
                | 1. Buy snack               |
                | 2. Show ticket             |
                | 3. Add new Snack           |
                | 4. EXIT                    |
                +----------------------------+
                Pick an option:\s""");
        return Integer.parseInt(console.nextLine());
    }

    private static boolean execOptions(int option, Scanner console,
                                       List<Snack> snacks) {
        var exit = false;
        switch (option) {
            case 1 -> buySnack(console, snacks);
            case 2 -> showSnacks(snacks);
            case 3 -> addSnacks(console);
            case 4 -> exit = true;
        }
        return exit;
    }

    private static void buySnack(Scanner console, List<Snack> snacks) {
        System.out.print("¿Que te quiere meter hoy? ");
        var snackId = Integer.parseInt(console.nextLine());
        var snackFound = false;
        for (var snack : Snacks.getSnacks()) {
            if (snackId == snack.getSnackId()) {
                snacks.add(snack);
                System.out.println("Se agrego " + snack.getSnackName());
                snackFound = true;
                break;
            }
        }
        if (!snackFound) {
            System.out.println("No se encontro esa vaina manito " + snackId);
        }
    }

    private static void showSnacks(List<Snack> snacks) {
        StringBuilder ticket = new StringBuilder("--- TOTAL DE VENTA ---");
        var total = 0.00;
        for (Snack snack : snacks) {
            ticket.append("\n\t- ").append(snack.getSnackName()).append(" - Price: ").append(snack.getSnackPrice()).append(" RD$");
            total += snack.getSnackPrice();
        }
        ticket.append(" \nTOTAL PRICE: ").append(total).append(" RD$");
        System.out.println(ticket);
    }

    private static void addSnacks(Scanner console) {
        System.out.print("Nombre del Snack: ");
        var snackName = console.nextLine();
        System.out.print("Precio: ");
        var snackPrice = Double.parseDouble(console.nextLine());
        Snacks.AddSnack(new Snack(snackName, snackPrice));
        System.out.println("Tu mierda se agrego al punto");
        Snacks.showSnacks();
    }
}