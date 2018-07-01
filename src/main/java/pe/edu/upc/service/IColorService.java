package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Color;

public interface IColorService {
	public List<Color> findAll();

	public void save(Color color);

	public Color findById(int id);

	public void deleteById(int id);


}
