package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dao.IMarcaDAO;
import pe.edu.upc.entity.Marca;

@Service
public class MarcaService implements IMarcaService{
	@Autowired
	private IMarcaDAO dao;

	@Override
	public List<Marca> findAll() {
		return dao.findAll();

	}

	@Override
	public void save(Marca marca) {
		dao.save(marca);
		
	}

	@Override
	public Marca findById(int id) {
		return dao.findById(id).orElse(null);

	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

}
