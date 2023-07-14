package certus.edu.pe.servicios;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import certus.edu.pe.modelo.Clientes;
import certus.edu.pe.repositorios.ClientesRepositorio;


@Service
@Transactional
public class ClientesServicio {

	@Autowired // Inyección de dependencia
	private ClientesRepositorio repositorio;
	
	public Clientes crear(Clientes cliente) {
		return repositorio.save(cliente);
	}
	
	public List<Clientes> buscarTodo(){
		return (ArrayList<Clientes>) repositorio.findAll();
	}
	
	public Clientes buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Clientes actualizar(Clientes clienteActualizar) {
		
		Clientes clienteActual = repositorio.findById(clienteActualizar.getIdcliente()).get();
		
		clienteActual.setIdcliente(clienteActualizar.getIdcliente());
		clienteActual.setNombre(clienteActualizar.getNombre());
		clienteActual.setApellido(clienteActualizar.getApellido());
		clienteActual.setDireccion(clienteActualizar.getDireccion());
		clienteActual.setTelefono(clienteActualizar.getTelefono());
		clienteActual.setMetodopago(clienteActualizar.getMetodopago());
		
		Clientes clienteActualizado = repositorio.save(clienteActual); // registra en base de datos
		return clienteActualizado;
	}	
	
	public void eliminarCliente(Integer id) {
		repositorio.deleteById(id);
		
	}
	
	public void actualizar(int id, Clientes clientes) {
		
		Clientes clienteActual = repositorio.findById(id).get();
		
		clienteActual.setIdcliente(clientes.getIdcliente());
		clienteActual.setNombre(clientes.getNombre());
		clienteActual.setApellido(clientes.getApellido());
		clienteActual.setDireccion(clientes.getDireccion());
		clienteActual.setTelefono(clientes.getTelefono());
		clienteActual.setMetodopago(clientes.getMetodopago());
		
		repositorio.save(clienteActual);
		
	}
	
}
