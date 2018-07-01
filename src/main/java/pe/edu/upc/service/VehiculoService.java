package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dao.IVehiculoDAO;
import pe.edu.upc.entity.Vehiculo;

@Service
public class VehiculoService implements IVehiculoService{
	@Autowired
	private IVehiculoDAO dao;
	@Override
	public List<Vehiculo> findAll() {
		return dao.findAll();

	}

	@Override
	public void save(Vehiculo vehiculo) {
		dao.save(vehiculo);
		
	}

	@Override
	public Vehiculo findById(int id) {
		return dao.findById(id).orElse(null);

	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

}

