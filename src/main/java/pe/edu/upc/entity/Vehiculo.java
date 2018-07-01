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
@Table(name = "Vehiculo")
public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVehiculo;

	@Column(name = "placaVehiculo", length = 15, nullable = true)
	private String placaVehiculo;
	
	@Column(name = "motorVehiculo", length = 15, nullable = true)
	private String motorVehiculo;
	
	@Column(name = "neumaticosVehiculo", length = 15, nullable = true)
	private String neumaticosVehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idMarca",nullable=false)
	private Marca marca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idColor",nullable=false)
	private Color color;

	public Vehiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(int idVehiculo, String placaVehiculo, String motorVehiculo, String neumaticosVehiculo, Marca marca,
			Color color) {
		super();
		this.idVehiculo = idVehiculo;
		this.placaVehiculo = placaVehiculo;
		this.motorVehiculo = motorVehiculo;
		this.neumaticosVehiculo = neumaticosVehiculo;
		this.marca = marca;
		this.color = color;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public String getMotorVehiculo() {
		return motorVehiculo;
	}

	public void setMotorVehiculo(String motorVehiculo) {
		this.motorVehiculo = motorVehiculo;
	}

	public String getNeumaticosVehiculo() {
		return neumaticosVehiculo;
	}

	public void setNeumaticosVehiculo(String neumaticosVehiculo) {
		this.neumaticosVehiculo = neumaticosVehiculo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
