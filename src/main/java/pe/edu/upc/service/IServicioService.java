package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Servicio;

public interface IServicioService {
	public List<Servicio> findAll();

	public void save(Servicio s);

	public Servicio findById(int id);

	public void deleteById(int id);
}
