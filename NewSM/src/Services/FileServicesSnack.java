package Services;

import Domain.Snack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileServicesSnack implements IServiceSnacks {
    private static final String FILE_NAME = "Snacks.txt";

    private final List<Snack> snacks = new ArrayList<>();

    public FileServicesSnack() {
        var file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("se creo el archivo");
                    loadSnacks(); 
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        } else {
            this.snacks.addAll(ObtenerSnacks()); 
        }
    }
    private void loadSnacks() {
        this.addSnack(new Snack("Pollo chips", 200));
        this.addSnack(new Snack("Flor de jamaica", 20));
        this.addSnack(new Snack("Papas fritas de carne", 120));
        this.addSnack(new Snack("Bate tun tun sahur", 25));
        this.addSnack(new Snack("Jugo de tiburon", 35));
        this.addSnack(new Snack("Jugo de cebolla", 5));


    }

    @Override
    public void addSnack(Snack snack) {
        //guardamos el snack en la memoria
        this.snacks.add(snack);
        //guardamos el snack en el archivo
        this.addSnackFile(snack);
    }
    
    /* hola 
     private void addSnackFile(Snack snack) {
        var file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                var output = new PrintWriter(new FileWriter(file, true));
                output.write(snack.toString());
                output.close();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }*/

    private void addSnackFile(Snack snack) {
        try (var output = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            output.println(snack.write());
        } catch (IOException e) {
            System.err.println("Error al guardar el snack: " + e.getMessage());
        }
    }


    @Override
    public void showSnack() {
        System.out.println(" --- INVENTARIO DEL SNACK ---");
        var inventarySnacks = "";
        for (var snack : this.snacks) {
            inventarySnacks += snack.toString() + "\n";
        }
        System.out.println(inventarySnacks);

    }

    @Override
    public List<Snack> getSnacks() {    
       
        return this.snacks;
    }

    public List<Snack> ObtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get( FILE_NAME));
            for(String linea : lineas) {
                String[] lineaSnack =  linea.split(",");
                var snackId = lineaSnack[0];
                var snackName = lineaSnack[1];
                var snackPrice =  Double.parseDouble(lineaSnack[2]);
                var snack  =  new Snack(snackName, snackPrice);
                snacks.add(snack);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el snack: " + e.getMessage());
        }
        return snacks;
    }
}
