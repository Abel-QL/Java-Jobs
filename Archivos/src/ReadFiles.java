void main() {
    var fileNameFile = "MiPrimerArchivo.txt";
    var file = new File(fileNameFile);
    try {
        System.out.println("Contenido del archivo: ");
        //abrir el archivo para leerlo jejeje 
        var reader = new BufferedReader(new FileReader(file));
        var lines = reader.readLine();
        //leer el archivo ya
        while (lines != null) {
            System.out.println(lines);
            lines = reader.readLine();
        }
        reader.close();
    } catch (Exception e) {
        System.out.println("error: " + e.getMessage());
    }
}
