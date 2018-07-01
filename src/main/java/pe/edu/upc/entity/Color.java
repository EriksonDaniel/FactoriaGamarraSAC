package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Color")
public class Color implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idColor;

	@Column(name = "nombreColor", length = 15, nullable = false)
	private String nombreColor;

	@Column(name = "detalleColor", length = 6, nullable = false)
	private String detalleColor;

	public Color(int idColor, String nombreColor, String detalleColor) {
		super();
		this.idColor = idColor;
		this.nombreColor = nombreColor;
		this.detalleColor = detalleColor;
	}

	public Color() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getNombreColor() {
		return nombreColor;
	}

	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}

	public String getDetalleColor() {
		return detalleColor;
	}

	public void setDetalleColor(String detalleColor) {
		this.detalleColor = detalleColor;
	}
}
