package certus.edu.pe.controladores.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import certus.edu.pe.modelo.Productos;
import certus.edu.pe.servicios.ProductosServicio;


@RestController
@RequestMapping("/rest/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductosRestController {
	
	@Autowired	
	private ProductosServicio servicio;
	
	@GetMapping
    public ResponseEntity<List<Productos>> buscarTodo() {
        List<Productos> listaProductos = servicio.buscarTodo();
        return new ResponseEntity<>(listaProductos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Productos> buscarPorId(@PathVariable("id") int id) {
        Productos producto = servicio.buscarPorId(id);
        if (producto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Producto no encontrado, el ID proporcionado no es correcto");
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> crear(@RequestBody Productos producto) {
        servicio.crear(producto);
        return new ResponseEntity<>("Producto creado correctamente", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<String> actualizar(@PathVariable("id") int id, @RequestBody Productos producto) {
        servicio.actualizar(id, producto);
        return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        servicio.eliminarPorId(id);
        return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
    }
	
	/*@GetMapping
	public ResponseEntity<Object> buscarTodo()	{
		List<Productos> listaProductos = servicio.buscarTodo();
		
		  System.out.println("LISTA DE PRODUCTOS : " + listaProductos);
		  
		 return  new ResponseEntity<>(listaProductos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
		Productos producto = servicio.buscarPorId(id);
		if (producto == null)

			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Producto no encontrado, id porporcionado no es correcto");
		return new ResponseEntity<Object>(producto, HttpStatus.OK);

	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
		)
	public  ResponseEntity <Object> crear (@RequestBody Productos producto){
	
	    servicio.crear(producto);
	    return new ResponseEntity<Object>("Producto creado correctamente", HttpStatus.OK);
	}
	

	@PutMapping (value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
			)
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Productos producto){
	
	servicio.actualizar(producto);
	return new ResponseEntity<Object>("Producto actualizado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
	    servicio.eliminarPorId(id);
	    return new ResponseEntity<Object>("Producto eliminado correctamente", HttpStatus.OK);
	}*/
	
}
