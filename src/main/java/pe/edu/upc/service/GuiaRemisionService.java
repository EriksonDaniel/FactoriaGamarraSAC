package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dao.IGuiaRemisionDAO;
import pe.edu.upc.entity.GuiaRemision;

@Service
public class GuiaRemisionService implements IGuiaRemisionService{
	@Autowired
	private IGuiaRemisionDAO dao;
	
	@Override
	public List<GuiaRemision> findAll() {
		return dao.findAll();

	}

	@Override
	public void save(GuiaRemision guiaRemision) {
		dao.save(guiaRemision);
		
	}

	@Override
	public GuiaRemision findById(int id) {
		return dao.findById(id).orElse(null);

	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

}
