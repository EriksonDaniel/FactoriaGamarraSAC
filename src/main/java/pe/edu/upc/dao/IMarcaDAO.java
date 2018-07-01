package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Marca;


@Repository
public interface IMarcaDAO extends JpaRepository<Marca,Integer>{

}

