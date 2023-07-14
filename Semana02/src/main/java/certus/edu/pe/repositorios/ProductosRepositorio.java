package certus.edu.pe.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import certus.edu.pe.modelo.Productos;

public interface ProductosRepositorio extends JpaRepository<Productos, Integer> {
	
}