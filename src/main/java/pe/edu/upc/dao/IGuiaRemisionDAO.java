package pe.edu.upc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.GuiaRemision;


@Repository 
public interface IGuiaRemisionDAO extends JpaRepository<GuiaRemision, Integer>{

}
