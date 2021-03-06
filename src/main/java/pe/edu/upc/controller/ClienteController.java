package pe.edu.upc.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;
@Controller
@SessionAttributes("cliente")
@RequestMapping("/cliente/")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping(value = "/list")
	public String listCliente(Model model) {		
		model.addAttribute("clientes",clienteService.findAll());
		return "cliente/list";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/new")
	public String newCliente(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/form";
	}

	@Secured("ROLE_ADMIN")
	@PostMapping(value = "/save")
	public String saveCliente(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "cliente/form";
		}	

		clienteService.save(cliente);
		status.setComplete();
		return "redirect:/cliente/list";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteCliente(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		if (id != null && id > 0) {
			clienteService.deleteById(id);
			model.put("clientes", clienteService.findAll());
		}
		return "redirect:/cliente/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public String updateCliente(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		Cliente cli = clienteService.findById(id);
		model.put("cliente", cli);
		return "/cliente/form";
	}
	
}
