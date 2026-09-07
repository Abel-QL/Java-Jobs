package zona_fit.Datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static zona_fit.conexion.Conexion.getConnection;

public class ClienteDAO implements IClienteDAO {
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try (Connection conn = getConnection()) {
            try {
                var sql = "SELECT * FROM cliente ORDER BY ID ASC";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("ID"));
                    cliente.setName(rs.getString("NOMBRE"));
                    cliente.setLastName(rs.getString("APELLIDO"));
                    cliente.setMembresia(rs.getInt("MEMBRESIA"));
                    clientes.add(cliente);
                }
            } catch (Exception e) {
                System.out.println("Error al obtener los datos del cliente" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion" + e.getMessage());
        }

        return clientes;
    }

    @Override
    public boolean buscarClientePorID(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        try (Connection conn = getConnection()) {
            try {
                var sql = "SELECT * FROM cliente WHERE ID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, cliente.getId());
                rs = ps.executeQuery();
                if (rs.next()) {
                    cliente.setName(rs.getString("NOMBRE"));
                    cliente.setLastName(rs.getString("APELLIDO"));
                    cliente.setMembresia(rs.getInt("MEMBRESIA"));
                    return true;
                } else return false;
            } catch (Exception e) {
                System.out.println("Error al obtener los datos del cliente" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean registrarCliente(Cliente cliente) {
        var sql = "INSERT INTO cliente(NOMBRE, APELLIDO, MEMBRESIA) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getName());
            ps.setString(2, cliente.getLastName());
            ps.setInt(3, cliente.getMembresia());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar el cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        var sql = "UPDATE cliente SET NOMBRE = ?, APELLIDO = ?, MEMBRESIA = ? WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getName());
            ps.setString(2, cliente.getLastName());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        var sql = "DELETE FROM cliente WHERE ID = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cliente.getId());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar el cliente " + e.getMessage());
        }
        return false;
    }

    /*
    //probar funcionamiento
    static void main() {

        IClienteDAO dao = new ClienteDAO();
       
        
        System.out.println("Clientes prueba ");
         
        IClienteDAO dao = new ClienteDAO();
        List<Cliente> listaClientes = dao.listarClientes();
        listaClientes.forEach(System.out::println);
         
        var cliente1 = new Cliente(3);
        var find = dao.buscarClientePorID(cliente1);
        if (find) {
            System.out.println("El cliente existe en el sistema: " + cliente1);
        } else {
            System.out.println("no existe el cliente en el sistema: " + cliente1.getId());
        }
         
        
        var nuevo = new Cliente("Ramon", "Caceres", 440);
        var registrar = dao.registrarCliente(nuevo);

        if (registrar) {
            dao.listarClientes();
            System.out.println("Registro exitoso" + nuevo);
        } else {
            System.out.println("Registro no existe" + nuevo);
        }
        List<Cliente> listaClientes = dao.listarClientes();
        listaClientes.forEach(System.out::println);


        var modificacion =  new Cliente(3, "Abelito", "Quezada Lorenzo", 100);
        var actualizado = dao.actualizarCliente(modificacion);
        if (actualizado) {
            System.out.println("Cliente actualizado correctamente: " +  modificacion);
            
        }else  {
            System.out.println("Cliente no encontrado" +  modificacion);
        }
    
        
        var eliminarClientes = new Cliente(5);
        var eliminado = dao.eliminarCliente(eliminarClientes);
        if (eliminado) {
            System.out.println("Cliente eliminado correctamente " + eliminarClientes.getId());
        } else {
            System.out.println("Cliente no eliminado correctamente " + eliminarClientes.getId());
        }


        List<Cliente> listaClientes = dao.listarClientes();
        listaClientes.forEach(System.out::println);
        
 
    }
    
     */
}
 