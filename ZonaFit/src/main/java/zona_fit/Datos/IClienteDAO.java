package zona_fit.Datos;

import zona_fit.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {
    List <Cliente> listarClientes();
    boolean buscarClientePorID(Cliente cliente);
    boolean registrarCliente(Cliente cliente);
    boolean actualizarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
}
