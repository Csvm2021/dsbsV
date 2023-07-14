package certus.edu.pe.servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import certus.edu.pe.modelo.Pedidos;
import certus.edu.pe.repositorios.PedidosRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class PedidosServicio {
	
	@Autowired //inyeccion de dependencias
	public PedidosRepositorio repositorio;
	
	
	public Pedidos crear(Pedidos pedidos) {
		return repositorio.save(pedidos);
	}
	
	//BUSCAR TODOS 
	public List<Pedidos> buscarTodo(){
		return (ArrayList<Pedidos>) repositorio.findAll();
	}
	
	//BUSCAR POR ID
	public Pedidos buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	//ACTUALIZAR 
public Pedidos actualizar(Pedidos pedidosActualizar) {

	  Pedidos pedidoActual = repositorio.findById(pedidosActualizar.getIdpedido()).get();
		
		pedidoActual.setIdpedido(pedidosActualizar.getIdpedido());
		pedidoActual.setFecha(pedidosActualizar.getFecha());
		pedidoActual.setTotal(pedidosActualizar.getTotal());
        pedidoActual.setClientesid(pedidosActualizar.getClientesid());
				
		Pedidos pedidosActualizado = repositorio.save(pedidoActual);
		return pedidosActualizado;
	}

//ELIMINAR

public void eliminarPedidos(Integer id) {
	repositorio.deleteById(id);
}

//ACTUALIZAR

public void actualizar(int id, Pedidos pedido) {
	
	Pedidos pedidoActual = repositorio.findById(id).get();
	
	pedidoActual.setIdpedido(pedido.getIdpedido());
	pedidoActual.setFecha(pedido.getFecha());
	pedidoActual.setTotal(pedido.getTotal());
    pedidoActual.setClientesid(pedido.getClientesid());
 
    
	repositorio.save(pedidoActual);
	
  }



}
