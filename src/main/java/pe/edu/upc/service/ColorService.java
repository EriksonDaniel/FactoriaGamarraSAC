package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dao.IColorDAO;
import pe.edu.upc.entity.Color;

@Service
public class ColorService implements IColorService {
	@Autowired
	private IColorDAO dao;
	
	@Override
	public List<Color> findAll() {
		return dao.findAll();
	}

	@Override
	public void save(Color color) {
		dao.save(color);
		
	}

	@Override
	public Color findById(int id) {
		return dao.findById(id).orElse(null);

	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}



}
