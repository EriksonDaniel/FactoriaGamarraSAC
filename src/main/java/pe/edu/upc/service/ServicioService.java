package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dao.IServicioDAO;
import pe.edu.upc.entity.Servicio;

@Service
public class ServicioService implements IServicioService{
	@Autowired
	private IServicioDAO dao;
	
	@Override
	public List<Servicio> findAll() {
		return dao.findAll();

	}

	@Override
	public void save(Servicio s) {
		dao.save(s);	
		
	}

	@Override
	public Servicio findById(int id) {
		return dao.findById(id).orElse(null);

	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

}
