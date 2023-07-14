package certus.edu.pe.controladores.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import certus.edu.pe.modelo.Clientes;
import certus.edu.pe.servicios.ClientesServicio;


@Controller
@RequestMapping("/clientes")
public class ClientesWebController {

	@Autowired
	private ClientesServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarClientes (Model model) {
		
		List <Clientes> listaClientes = servicio.buscarTodo();
		System.out.println("LISTA DE CLIENTES : " + listaClientes);
		model.addAttribute("listaClientes", listaClientes);
		return "/moduloClientes/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoCliente(Model model) {
		Clientes cliente = new Clientes ();
		model.addAttribute("clientes", cliente);
		return "/moduloClientes/nuevoCliente";	
	}
	
	@RequestMapping(value ="/guardar", method= RequestMethod.POST)
	public String crearCliente(@ModelAttribute("clientes")@Valid Clientes cliente, BindingResult bindingResult) {
		    if(bindingResult.hasErrors()) {
		    	return "/moduloClientes/nuevoCliente";
		    }
			servicio.crear(cliente);
		    return "redirect:/clientes/listarTodo";
		
	}
	
	 @RequestMapping(value ="/actualizar/{id}")
	public ModelAndView editarCliente(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("/moduloClientes/editarCliente");
		Clientes clientes = servicio.buscarPorId(id);
		mav.addObject("clientes",clientes);
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String EliminarCliente(@PathVariable(name="id") int id) {
		servicio.eliminarCliente(id);
		return "redirect:/clientes/listarTodo";
	}
	
}