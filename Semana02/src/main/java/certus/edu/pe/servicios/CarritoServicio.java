package certus.edu.pe.servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import certus.edu.pe.modelo.Carrito;
import certus.edu.pe.repositorios.CarritoRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class CarritoServicio {
	@Autowired
	public CarritoRepositorio repositorio;
	
	
	public Carrito crear(Carrito carrito) {
		return repositorio.save(carrito);
	}
	
	public List<Carrito> buscarTodo(){
		return (ArrayList<Carrito>) repositorio.findAll();
	}
	
	public Carrito buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Carrito actualizar(Carrito carritoActualizar) {
		
		Carrito carritoActual = repositorio.findById(carritoActualizar.getIdcarrito()).get();
		
		carritoActual.setIdcarrito(carritoActualizar.getIdcarrito());
		carritoActual.setClientesid(carritoActualizar.getClientesid());
		carritoActual.setProductosid(carritoActualizar.getProductosid());
		carritoActual.setCantidad(carritoActualizar.getCantidad());
		
		Carrito carritoActualizado = repositorio.save(carritoActual);
		return carritoActualizado;
	}
	
	public void eliminarCarrito(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void actualizar(int id, Carrito carrito) {
		
		Carrito carritoActual = repositorio.findById(id).get();
		
		carritoActual.setIdcarrito(carrito.getIdcarrito());
		carritoActual.setClientesid(carrito.getClientesid());
		carritoActual.setProductosid(carrito.getProductosid());
		carritoActual.setCantidad(carrito.getCantidad());
		repositorio.save(carritoActual);
		
	}
}
