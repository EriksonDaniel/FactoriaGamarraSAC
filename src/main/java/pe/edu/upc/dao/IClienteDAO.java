package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, Integer>{

}
