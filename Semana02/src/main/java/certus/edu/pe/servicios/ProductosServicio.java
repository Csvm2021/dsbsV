package certus.edu.pe.servicios;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Productos;
import certus.edu.pe.repositorios.ProductosRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class ProductosServicio {
	
	private final ProductosRepositorio repositorio;
	
	@Autowired
    public ProductosServicio(ProductosRepositorio repositorio) {
        this.repositorio = repositorio;
    }

	public Productos crear(Productos productos) {
		return repositorio.save(productos);
	}
	
	public List<Productos> buscarTodo(){
		return (ArrayList<Productos>) repositorio.findAll();
	}
	
	public Productos buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Productos actualizar(Productos productosActualizar) {
		
		Productos productoActual = repositorio.findById(productosActualizar.getIdproducto()).get();
		
		productoActual.setIdproducto(productosActualizar.getIdproducto());
		productoActual.setNombre(productosActualizar.getNombre());
		productoActual.setProveedor(productosActualizar.getProveedor());
		productoActual.setPrecio(productosActualizar.getPrecio());
		productoActual.setDescripcion(productosActualizar.getDescripcion());
		productoActual.setStock(productosActualizar.getStock());
		productoActual.setCategoriasid(productosActualizar.getCategoriasid());
		
		
		Productos productoActualizado = repositorio.save(productoActual); // registra en base de datos
		return productoActualizado;
	}
	
	
	
	public void eliminarPorId(Integer id) {
		repositorio.deleteById(id);
		
	}
	
	public void actualizar(int id, Productos productos) {
		
		Productos productoActual = repositorio.findById(id).get();
		
		productoActual.setIdproducto(productos.getIdproducto());
		productoActual.setNombre(productos.getNombre());
		productoActual.setProveedor(productos.getProveedor());
		productoActual.setPrecio(productos.getPrecio());
		productoActual.setDescripcion(productos.getDescripcion());
		productoActual.setStock(productos.getStock());
		productoActual.setCategoriasid(productos.getCategoriasid());
		repositorio.save(productoActual);
		
	}
	
}

