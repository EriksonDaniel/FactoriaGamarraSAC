package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Modelo;

public interface IModeloService {
	public List<Modelo> findAll();

	public void save(Modelo modelo);

	public Modelo findById(int id);

	public void deleteById(int id);
	
}
