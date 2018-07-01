package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dao.IModeloDAO;
import pe.edu.upc.entity.Modelo;

@Service
public class ModeloService implements IModeloService{
	@Autowired
	private IModeloDAO dao;
	
	@Override
	public List<Modelo> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(Modelo modelo) {
		dao.save(modelo);
	}

	@Override
	public Modelo findById(int id) {
		return dao.findById(id).orElse(null);

	} 

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}



}
