package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Marca")
public class Marca implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMarca;
	
	@Column(name = "nombreMarca", length = 15, nullable = true)
	private String nombreMarca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idModelo",nullable=false)
	private Modelo modelo;

	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marca(int idMarca, String nombreMarca, Modelo modelo) {
		super();
		this.idMarca = idMarca;
		this.nombreMarca = nombreMarca;
		this.modelo = modelo;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}
