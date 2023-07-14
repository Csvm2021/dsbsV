package certus.edu.pe.servicios;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import certus.edu.pe.modelo.Categorias;
import certus.edu.pe.repositorios.CategoriasRepositorio;

@Service
@Transactional
public class CategoriasServicio {

	@Autowired // Inyección de dependencia
	private CategoriasRepositorio repositorio;
	
	public CategoriasServicio() {
		
	}
	
	public List<Categorias> buscarTodo(){
		return (ArrayList<Categorias>) repositorio.findAll();
	}
	
	public Categorias actualizar(Categorias CategoriaActualizar) {
		
		Categorias CategoriaActual = repositorio.findById(CategoriaActualizar.getIdcategoria()).get();
		
		CategoriaActual.setIdcategoria(CategoriaActualizar.getIdcategoria());
		CategoriaActual.setNombre(CategoriaActualizar.getNombre());
		CategoriaActual.setDescripcion(CategoriaActualizar.getDescripcion());

		
		Categorias CategoriaActualizado = repositorio.save(CategoriaActual);// registra en base de datos
		return CategoriaActualizado;
		}
	
	
	public Categorias crear(Categorias Categorias) {
		return repositorio.save(Categorias);
	}
	
	public Categorias buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void eliminarCategorias(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void actualizar(int id, Categorias categorias) {
		
		Categorias categoriaActual = repositorio.findById(id).get();
		
		categoriaActual.setIdcategoria(categorias.getIdcategoria());
		categoriaActual.setNombre(categorias.getNombre());
		categoriaActual.setDescripcion(categorias.getDescripcion());
		
		repositorio.save(categoriaActual);
		
	}
	
}
