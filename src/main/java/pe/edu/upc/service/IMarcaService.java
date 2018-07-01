package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Marca;

public interface IMarcaService {
	public List<Marca> findAll();

	public void save(Marca marca);

	public Marca findById(int id);

	public void deleteById(int id);
}
