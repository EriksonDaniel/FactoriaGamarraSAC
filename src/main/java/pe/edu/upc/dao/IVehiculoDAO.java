package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Vehiculo;

@Repository
public interface IVehiculoDAO extends JpaRepository<Vehiculo,Integer>{

}
