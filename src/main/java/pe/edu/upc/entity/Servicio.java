package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio")
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;
	
	@Column(name = "nombreServicio", length = 30, nullable = false)
	private String nombreServicio;
	
	@Column(name = "detalleServicio", length = 70, nullable = false)
	private String detalleServicio;

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicio(int idServicio, String nombreServicio, String detalleServicio) {
		super();
		this.idServicio = idServicio;
		this.nombreServicio = nombreServicio;
		this.detalleServicio = detalleServicio;
	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getDetalleServicio() {
		return detalleServicio;
	}

	public void setDetalleServicio(String detalleServicio) {
		this.detalleServicio = detalleServicio;
	}

}
