package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mapas")
public class Mapas implements Serializable {
	private static final long serialVersionUID = 123L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_mapa")
	private int idMapa;
	private double latitud1;
	private double longitud1;
	private double latitud2;
	private double longitud2;
	@Temporal(TemporalType.TIMESTAMP)
	private Date nombre = new Date();
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuarios usuario;
	
	public Mapas() {
		super();
	}
	
	public Mapas(int idMapa) {
		super();
		this.idMapa = idMapa;
	}
	
	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
	}

	public double getLatitud1() {
		return latitud1;
	}

	public double getLongitud1() {
		return longitud1;
	}

	public double getLatitud2() {
		return latitud2;
	}

	public double getLongitud2() {
		return longitud2;
	}

	public void setLatitud1(double latitud1) {
		this.latitud1 = latitud1;
	}

	public void setLongitud1(double longitud1) {
		this.longitud1 = longitud1;
	}

	public void setLatitud2(double latitud2) {
		this.latitud2 = latitud2;
	}

	public void setLongitud2(double longitud2) {
		this.longitud2 = longitud2;
	}
	
	public Date getNombre() {
		return nombre;
	}

	public void setNombre(Date nombre) {
		this.nombre = nombre;
	}
	
	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
}
