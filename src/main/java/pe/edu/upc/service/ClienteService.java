package pe.edu.upc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.dao.IClienteDAO;
import pe.edu.upc.entity.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDAO dao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) dao.findAll();

	}

	@Override
	public void save(Cliente cliente) {
		dao.save(cliente);

	}

	@Override
	public Cliente findById(int id) {
		return dao.findById(id).orElse(null);

	} 

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);

	}
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

}

