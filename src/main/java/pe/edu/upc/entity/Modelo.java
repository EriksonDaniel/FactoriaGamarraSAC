package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Modelo")
public class Modelo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idModelo;
	
	@Column(name = "nombreModelo", length = 15)
	private String nombreModelo;
	
	@Column(name = "versionModelo", length = 15)
	private String versionModelo;

	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modelo(int idModelo, String nombreModelo, String versionModelo) {
		super();
		this.idModelo = idModelo;
		this.nombreModelo = nombreModelo;
		this.versionModelo = versionModelo;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public String getVersionModelo() {
		return versionModelo;
	}

	public void setVersionModelo(String versionModelo) {
		this.versionModelo = versionModelo;
	}

}
