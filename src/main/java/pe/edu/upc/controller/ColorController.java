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

import pe.edu.upc.entity.Color;
import pe.edu.upc.service.IColorService;

@Controller
@SessionAttributes("color")
@RequestMapping("/color/")
public class ColorController {
	@Autowired
	private IColorService colorService;

	@RequestMapping("/list")
	public String listcolor(Map<String, Object> model) {

		model.put("colores", colorService.findAll());
		return "color/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/new")
	public String newcolor(Model model) {

		Color color = new Color();
		model.addAttribute("color", color);

		return "color/form";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/save")
	public String savecolor(@Valid Color color, BindingResult result, Model model,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "color/form";
		}

		colorService.save(color);
		status.setComplete();
		return "redirect:/color/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deletecolor(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		if (id != null && id > 0) {
			colorService.deleteById(id);
			model.put("colores", colorService.findAll());
		}
		return "redirect:/color/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public String updatecolor(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		Color col = colorService.findById(id);
		model.put("color", col);
		return "/color/form";
	}
	
}

