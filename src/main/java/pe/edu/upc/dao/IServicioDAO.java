package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Servicio;

@Repository
public interface IServicioDAO extends JpaRepository<Servicio,Integer>{

}
