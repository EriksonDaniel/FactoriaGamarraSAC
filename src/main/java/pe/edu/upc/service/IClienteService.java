package pe.edu.upc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pe.edu.upc.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findById(int id);

	public void deleteById(int id);
	
	public Page<Cliente> findAll(Pageable pageable);


}