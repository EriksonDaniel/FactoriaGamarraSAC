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

import pe.edu.upc.entity.Vehiculo;
import pe.edu.upc.service.IColorService;
import pe.edu.upc.service.IMarcaService;
import pe.edu.upc.service.IVehiculoService;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IMarcaService marcaService;
	@Autowired
	private IColorService colorService;

	@RequestMapping("/list")
	public String listVehiculo(Map<String, Object> model) {
		model.put("vehiculos", vehiculoService.findAll());
		return "vehiculo/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/new")
	public String newVehiculo(Model model) {

		model.addAttribute("vehiculo", new Vehiculo());
		model.addAttribute("colores", colorService.findAll());
		model.addAttribute("marcas", marcaService.findAll());
		return "vehiculo/form";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/save")
	public String saveVehiculo(@Valid Vehiculo Vehiculo, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			return "Vehiculo/form";
		}
		vehiculoService.save(Vehiculo);
		model.addAttribute("colores", colorService.findAll());
		model.addAttribute("marcas", marcaService.findAll());
		status.setComplete();

		return "redirect:/vehiculo/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete")
	public String deleteVehiculo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {

		if (id != null && id > 0) {
			vehiculoService.deleteById(id);
			model.put("vehiculos", vehiculoService.findAll());
		}
		return "redirect:/vehiculo/list";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping("/update")
	public String updateVehiculo(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		Vehiculo veh = vehiculoService.findById(id);
		model.put("colores", colorService.findAll());
		model.put("marcas", marcaService.findAll());
		model.put("vehiculo", veh);
		return "/vehiculo/form";
	}
}
