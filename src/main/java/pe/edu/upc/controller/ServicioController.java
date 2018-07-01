package pe.edu.upc.controller;

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

import pe.edu.upc.entity.Servicio;
import pe.edu.upc.service.IServicioService;

@Controller
@SessionAttributes("servicio")
@RequestMapping("/servicio/")
public class ServicioController {
	@Autowired
	private IServicioService servicioService;

	@RequestMapping("/list")
	public String listServicio(Model model) {
		model.addAttribute("servicios", servicioService.findAll());
		return "servicio/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/new")
	public String newServicio(Model model) {
		
		model.addAttribute("servicio", new Servicio());
		return "servicio/form";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/save")
	public String saveServicio(@Valid Servicio servicio, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "servicio/form";
		}
		servicioService.save(servicio);
		status.setComplete();
		return "redirect:/servicio/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteServicio(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		if (id != null && id > 0) {
			servicioService.deleteById(id);
			model.put("servicios", servicioService.findAll());
		}
		return "redirect:/servicio/list";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public String updateModelo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		Servicio ser = servicioService.findById(id);
		model.put("servicio", ser);
		return "/servicio/form";
	}
}
