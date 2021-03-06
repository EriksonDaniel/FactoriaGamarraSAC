package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Modelo;

@Repository 
public interface IModeloDAO extends JpaRepository<Modelo, Integer>{

}