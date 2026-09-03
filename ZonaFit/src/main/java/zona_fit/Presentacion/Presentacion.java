package zona_fit.Presentacion;

import zona_fit.Datos.ClienteDAO;
import zona_fit.Datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class Presentacion {
    static void main() {
        PresentacionFit();
    }

    public static void PresentacionFit() {
        var exit = false;
        IClienteDAO dao = new ClienteDAO();

        System.out.println("Zona Fit  -  para ponerse roca");

        try (Scanner console = new Scanner(System.in)) {
            while (!exit) {
                try {
                    var option = showMenu(console);
                    exit = execOption(console, option, dao);
                } catch (Exception e) {
                    System.out.println("Error en el sistema de presentacion: " + e.getMessage());
                }
            }
        }
    }

    private static int showMenu(Scanner console) {
        System.out.print("""
                +----------------------------+
                |         ZONA FIT           |
                +----------------------------+
                | 1. Registrar cliente       |
                | 2. Listar clientes         |
                | 3. Actualizar cliente      |
                | 4. Eliminar cliente        |
                | 5. Buscar cliente por ID   |
                | 6. EXIT                    |
                +----------------------------+
                Seleccione una opción:\s""");
        return Integer.parseInt(console.nextLine());
    }

    private static boolean execOption(Scanner console, int opcion, IClienteDAO dao) {
        var exit = false;
        switch (opcion) {
            case 1 -> registrarCliente(console, dao);
            case 2 -> listarClientes(dao);
            case 3 -> actualizarCliente(console, dao);
            case 4 -> eliminarCliente(console, dao);
            case 5 -> buscarCliente(console, dao);
            case 6 -> exit = true;
        }
        return exit;
    }

    private static void registrarCliente(Scanner console, IClienteDAO dao) {
        System.out.print("Introduce el nombre del cliente: \n");
        var name = console.nextLine();
        System.out.print("Introduce la apellido del cliente: \n");
        var apellido = console.nextLine();
        System.out.print("Introduce la membresia del cliente: \n");
        var membresia = Integer.parseInt(console.nextLine());     

        if (membresia <= 0) {
            System.out.println("Debe introducir un valor de membresía válido (mayor a 0)");
            return;
        }

        var cliente = new Cliente(name, apellido, membresia);
        var registrar = dao.registrarCliente(cliente);
        if (registrar)
            System.out.println("Cliente registrado: " + cliente);
        else
            System.out.println("Cliente no registrado: " + cliente);

    }

    private static void listarClientes(IClienteDAO dao) {
        System.out.println("Lista de clientes:");
        var clientes = dao.listarClientes();
        clientes.forEach(c -> System.out.println(c.toString()));
    }

    private static void actualizarCliente(Scanner console, IClienteDAO dao) {
        System.out.println("Actualizando cliente por ID: ");
        System.out.print("Introduce el ID del cliente a actualizar: ");
        var id = Integer.parseInt(console.nextLine());
        System.out.print("Introduce el nombre del cliente: ");
        var name = console.nextLine();
        System.out.print("Introduce el apellido del cliente: ");
        var apellido = console.nextLine();
        System.out.print("Introduce la membresia del cliente: \n");
        var membresia = Integer.parseInt(console.nextLine());

        if (membresia <= 0 || id <= 0) {
            System.out.println("Debe introducir un valor de id o membresía válido (mayor a 0)");
            return;
        }

        var cliente = new Cliente(id, name, apellido, membresia);
        var actualizado = dao.actualizarCliente(cliente);
        if (actualizado)
            System.out.println("Cliente actualizado: " + cliente);
        else
            System.out.println("Cliente no actualizado: " + cliente);
    }

    private static void eliminarCliente(Scanner console, IClienteDAO dao) {
        var id = leerEnteroPositivo(console, "Introduce el ID del cliente a eliminar: ");
        var cliente = new Cliente(id);
        var eliminado = dao.eliminarCliente(cliente);
        System.out.println(eliminado ? "Cliente eliminado: " + cliente : "Cliente no eliminado: " + cliente);
        listarClientes(dao);
    }

    private static void buscarCliente(Scanner console, IClienteDAO dao) {
        var id = leerEnteroPositivo(console, "Introduce el ID del cliente: ");
        var cliente = new Cliente(id);
        var find = dao.buscarClientePorID(cliente);
        System.out.println(find ? "Cliente encontrado: " + cliente : "Cliente no encontrado: " + cliente);
    }

    private static int leerEnteroPositivo(Scanner console, String mensaje) {
        System.out.print(mensaje);
        var valor = Integer.parseInt(console.nextLine());
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor debe ser mayor a 0");
        }
        return valor;
    }

}
