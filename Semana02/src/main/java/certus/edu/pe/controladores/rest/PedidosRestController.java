package certus.edu.pe.controladores.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import certus.edu.pe.modelo.Pedidos;
import certus.edu.pe.servicios.PedidosServicio;

@RestController
@RequestMapping("/rest/pedidos")
public class PedidosRestController {

@Autowired	//inyeccion de dependecias 
private PedidosServicio servicio;

@GetMapping //metodo buscar todo para taer todo la lista de pedidos
public ResponseEntity<Object> buscarTodo()	{
	List<Pedidos> listaPedidos = servicio.buscarTodo();
	
	  System.out.println("LISTA DE PEDIDOS : " + listaPedidos);
	  
	 return  new ResponseEntity<>(listaPedidos, HttpStatus.OK); //retorno http lo que quiere de decir atraves de la api mostrar un codigo 200 correcto
	
}

//buscar
@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@ResponseBody
public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
	Pedidos pedido = servicio.buscarPorId(id);
	if (pedido == null)

		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"El pedido no se a encontrado, id porporcionado no es correcto");
	return new ResponseEntity<Object>(pedido, HttpStatus.OK);

}

//crear
@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
              consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
		)
public  ResponseEntity <Object> crear (@RequestBody Pedidos pedido){
	
	    servicio.crear(pedido);
	    return new ResponseEntity<Object>("El pedido se ha creado correctamente", HttpStatus.OK);

}

//Actualizar
@PutMapping (value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
)
public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Pedidos pedido){
	
	servicio.actualizar(pedido);
	return new ResponseEntity<Object>("El pedido se ha actualizado correctamente", HttpStatus.OK);
	
	
}

//Eliminar
@DeleteMapping(value = "/{id}")
public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
    servicio.eliminarPedidos(id);
    return new ResponseEntity<Object>("El pedido se ha eliminado correctamente", HttpStatus.OK);
}

}
