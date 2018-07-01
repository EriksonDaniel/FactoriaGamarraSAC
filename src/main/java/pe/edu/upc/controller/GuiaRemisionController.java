package pe.edu.upc.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.GuiaRemision;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.IGuiaRemisionService;
import pe.edu.upc.service.IServicioService;
import pe.edu.upc.service.IVehiculoService;

@Controller
@SessionAttributes("guiaRemision")
@RequestMapping("/guiaRemision/")
public class GuiaRemisionController {
	@Autowired
	private IServicioService servicioService;

	@Autowired
	private IVehiculoService vehiculoService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IGuiaRemisionService guiaRemisionService;

	@RequestMapping("/list")
	public String listGuiaRemision(Map<String, Object> model) {
		model.put("guiaRemisiones", guiaRemisionService.findAll());
		return "guiaRemision/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/new")
	public String newGuiaRemision(Model model) {

		model.addAttribute("guiaRemision", new GuiaRemision());
		model.addAttribute("servicios", servicioService.findAll());
		model.addAttribute("vehiculos", vehiculoService.findAll());
		model.addAttribute("clientes", clienteService.findAll());
		return "guiaRemision/form";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/save")
	public String saveGuiaRemision(@Valid GuiaRemision guiaRemision, BindingResult result, Model model,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "guiaRemision/form";
		}
		guiaRemisionService.save(guiaRemision);

		model.addAttribute("servicios", servicioService.findAll());
		model.addAttribute("vehiculos", vehiculoService.findAll());
		model.addAttribute("clientes", clienteService.findAll());
		status.setComplete();

		return "redirect:/guiaRemision/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteGuiaRemision(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		if (id != null && id > 0) {
			guiaRemisionService.deleteById(id);
			model.put("GuiaRemisiones", guiaRemisionService.findAll());
		}
		return "redirect:/guiaRemision/list";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public String updateGuiaRemision(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		GuiaRemision guir = guiaRemisionService.findById(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		guir.setFechaStringEntrega(sdf.format(guir.getFechaEntrega()));
		guir.setFechaStringDevolucion(sdf.format(guir.getFechaDevolucion()));
		model.put("servicios", servicioService.findAll());
		model.put("vehiculos", vehiculoService.findAll());
		model.put("clientes", clienteService.findAll());
		model.put("guiaRemision", guir);
		return "/guiaRemision/form";
	}
}
