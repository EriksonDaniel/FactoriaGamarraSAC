package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.GuiaRemision;

public interface IGuiaRemisionService {
	public List<GuiaRemision> findAll();

	public void save(GuiaRemision guiaRemision);

	public GuiaRemision findById(int id);

	public void deleteById(int id);
}
