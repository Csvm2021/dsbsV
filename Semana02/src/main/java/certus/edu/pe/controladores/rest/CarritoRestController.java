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
import certus.edu.pe.modelo.Carrito;
import certus.edu.pe.servicios.CarritoServicio;

@RestController
@RequestMapping("/rest/carrito")
@CrossOrigin(origins = "http://localhost:4200")
public class CarritoRestController {
	@Autowired	
	private CarritoServicio servicio;

	@GetMapping
	public ResponseEntity<Object> buscarTodo()	{
		List<Carrito> listaCarrito = servicio.buscarTodo();
		
		  System.out.println("LISTA DE carrito : " + listaCarrito);
		  
		 return  new ResponseEntity<>(listaCarrito, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
		Carrito carrito = servicio.buscarPorId(id);
		if (carrito == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Carrito no encontrado, el id proporcionado no es el correcto");
		return new ResponseEntity<Object>(carrito, HttpStatus.OK);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
            	 consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public  ResponseEntity <Object> crear (@RequestBody Carrito carrito){
	    	servicio.crear(carrito);
	    	return new ResponseEntity<Object>("La carrito ha sido creado correctamente", HttpStatus.OK);
		}
	
	@PutMapping (value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
								  consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Carrito carrito){
			servicio.actualizar(carrito);
			return new ResponseEntity<Object>("La carrito ha sido actualizado correctamente", HttpStatus.OK);	
		}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
	    servicio.eliminarCarrito(id);
	    return new ResponseEntity<Object>("La carrito ha sido eliminado correctamente", HttpStatus.OK);
	}
}
