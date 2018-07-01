package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "GuiaRemision")
public class GuiaRemision implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGuiaRemision;
	
	@Column(name = "observacionGuiaRemision", length = 70, nullable = false)
	private String observacionGuiaRemision;
	
	@Column(name = "fechaEntrega")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEntrega;
	
	
	@Column(name = "fechaDevolucion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaDevolucion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicio")
	private Servicio servicio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVehiculo")
	private Vehiculo vehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	private String fechaStringEntrega;

	private String fechaStringDevolucion;

	public GuiaRemision() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GuiaRemision(int idGuiaRemision, String observacionGuiaRemision, Date fechaEntrega, Date fechaDevolucion,
			Servicio servicio, Vehiculo vehiculo, Cliente cliente, String fechaStringEntrega,
			String fechaStringDevolucion) {
		super();
		this.idGuiaRemision = idGuiaRemision;
		this.observacionGuiaRemision = observacionGuiaRemision;
		this.fechaEntrega = fechaEntrega;
		this.fechaDevolucion = fechaDevolucion;
		this.servicio = servicio;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.fechaStringEntrega = fechaStringEntrega;
		this.fechaStringDevolucion = fechaStringDevolucion;
	}

	public int getIdGuiaRemision() {
		return idGuiaRemision;
	}

	public void setIdGuiaRemision(int idGuiaRemision) {
		this.idGuiaRemision = idGuiaRemision;
	}

	public String getObservacionGuiaRemision() {
		return observacionGuiaRemision;
	}

	public void setObservacionGuiaRemision(String observacionGuiaRemision) {
		this.observacionGuiaRemision = observacionGuiaRemision;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFechaStringEntrega() {
		return fechaStringEntrega;
	}

	public void setFechaStringEntrega(String fechaStringEntrega) {
		this.fechaStringEntrega = fechaStringEntrega;
	}

	public String getFechaStringDevolucion() {
		return fechaStringDevolucion;
	}

	public void setFechaStringDevolucion(String fechaStringDevolucion) {
		this.fechaStringDevolucion = fechaStringDevolucion;
	}

}
