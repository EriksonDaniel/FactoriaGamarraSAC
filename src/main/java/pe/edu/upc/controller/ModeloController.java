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

import pe.edu.upc.entity.Modelo;
import pe.edu.upc.service.IModeloService;

@Controller
@SessionAttributes("modelo")
@RequestMapping("/modelo/")
public class ModeloController {
	@Autowired
	private IModeloService modeloService;

	@RequestMapping("/list")
	public String listModelo(Model model) {
		model.addAttribute("modelos", modeloService.findAll());
		return "modelo/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/new")
	public String newModelo(Model model) {

		Modelo modelo = new Modelo();
		model.addAttribute("modelo", modelo);
		return "modelo/form";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/save")
	public String saveModelo(@Valid Modelo modelo, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "modelo/form";
		}

		modeloService.save(modelo);
		status.setComplete();
		return "redirect:/modelo/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteModelo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		if (id != null && id > 0) {
			modeloService.deleteById(id);
			model.put("modelos", modeloService.findAll());
		}
		return "redirect:/modelo/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public String updateModelo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		Modelo mod = modeloService.findById(id);
		model.put("modelo", mod);
		return "/modelo/form";
	}
}
