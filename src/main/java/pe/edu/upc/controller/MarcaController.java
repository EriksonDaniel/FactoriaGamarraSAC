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
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Marca;
import pe.edu.upc.service.IMarcaService;
import pe.edu.upc.service.IModeloService;

@Controller
@RequestMapping("/marca")
public class MarcaController {
	@Autowired
	private IMarcaService marcaService;

	@Autowired
	private IModeloService modeloService;

	@RequestMapping("/list")
	public String listMarca(Map<String, Object> model) {
		model.put("marcas", marcaService.findAll());
		return "marca/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/new")
	public String newMarca(Model model) {

		model.addAttribute("marca", new Marca());
		model.addAttribute("modelos", modeloService.findAll());
		return "marca/form";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/save")
	public String saveMarca(@Valid Marca marca, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "marca/form";
		}
		marcaService.save(marca);

		model.addAttribute("modelos", modeloService.findAll());
		status.setComplete();

		return "redirect:/marca/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteMarca(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		if (id != null && id > 0) {
			marcaService.deleteById(id);
			model.put("marcas", marcaService.findAll());
		}
		return "redirect:/marca/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public String updateMarca(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		Marca mod = marcaService.findById(id);
		model.put("modelos", modeloService.findAll());
		model.put("marca", mod);
		return "/marca/form";
	}
}
