package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Vehiculo;

public interface IVehiculoService {
	public List<Vehiculo> findAll();

	public void save(Vehiculo vehiculo);

	public Vehiculo findById(int id);

	public void deleteById(int id);

}