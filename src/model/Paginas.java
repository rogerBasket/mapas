package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "paginas")
public class Paginas implements Serializable {
	private static final long serialVersionUID = 123L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pagina")
	private int idPagina;
	private String nombre;
	@ManyToMany
	@JoinTable(name = "perfiles_paginas", 
		joinColumns = {@JoinColumn(name = "id_pagina")},
		inverseJoinColumns = {@JoinColumn(name = "id_perfil")}
	)
	private List<Perfiles> perfiles = new ArrayList<Perfiles>();

	public Paginas() {
		
	}
	
	public Paginas(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public int getIdPagina() {
		return idPagina;
	}
	
	public void setIdPagina(int idPagina) {
		this.idPagina = idPagina;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Perfiles> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfiles> perfiles) {
		this.perfiles = perfiles;
	}
}
