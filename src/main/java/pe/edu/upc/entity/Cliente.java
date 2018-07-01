package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(name = "nombreCliente", length = 15, nullable = false)
	private String nombreCliente;
	
	@Column(name = "apellidoCliente", length = 15, nullable = false)
	private String apellidoCliente;
	
	@Column(name = "dniCliente", length = 15, nullable = false)
	private String dniCliente;
	
	@Column(name = "razonSocialCliente", length = 15, nullable = false)
	private String razonSocialCliente;
	
	@Column(name = "direccionCliente", length = 70, nullable = false)
	private String direccionCliente;
	
	@Column(name = "rucCliente", length = 15, nullable = false)
	private String rucCliente;
	
	@Column(name = "telefonoCliente", length = 15, nullable = false)
	private String telefonoCliente;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String dniCliente,
			String razonSocialCliente, String direccionCliente, String rucCliente, String telefonoCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dniCliente = dniCliente;
		this.razonSocialCliente = razonSocialCliente;
		this.direccionCliente = direccionCliente;
		this.rucCliente = rucCliente;
		this.telefonoCliente = telefonoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getRazonSocialCliente() {
		return razonSocialCliente;
	}

	public void setRazonSocialCliente(String razonSocialCliente) {
		this.razonSocialCliente = razonSocialCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getRucCliente() {
		return rucCliente;
	}

	public void setRucCliente(String rucCliente) {
		this.rucCliente = rucCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
}
