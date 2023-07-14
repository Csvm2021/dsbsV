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

import certus.edu.pe.modelo.Productos;
import certus.edu.pe.servicios.ProductosServicio;

@Controller
@RequestMapping("/productos")
public class ProductosWebController {
	
	@Autowired
	private ProductosServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarProductos (Model model) {
		List <Productos> listarProductos = servicio.buscarTodo();
		System.out.println("LISTA DE PRODUCTOS : " + listarProductos);
		model.addAttribute("listaProductos", listarProductos);
		return "/moduloProductos/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoProducto(Model model) {
		Productos productos = new Productos ();
		model.addAttribute("productos",productos);
		return "/moduloProductos/nuevoProducto";	
	}
	
	@RequestMapping(value ="/guardar", method= RequestMethod.POST)
	public String crearProducto(@ModelAttribute("productos") @Valid Productos productos, BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
		    	return "/moduloProductos/nuevoProducto";
		    }
			servicio.crear(productos);
		    return "redirect:/productos/listarTodo";
		
	}
	
	 @RequestMapping(value ="/actualizar/{id}")
	public ModelAndView editarProducto(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("/moduloProductos/editarProducto");
		Productos productos = servicio.buscarPorId(id);
		mav.addObject("productos",productos);
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String elimnarProducto(@PathVariable(name="id") int id) {
		servicio.eliminarPorId(id);
		return "redirect:/productos/listarTodo";
	}

}
