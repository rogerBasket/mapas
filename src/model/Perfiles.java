package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfiles implements Serializable {
	private static final long serialVersionUID = 123L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_perfil")
	private int idPerfil;
	private String descripcion;
	@OneToMany(mappedBy = "perfil")
	private List<Usuarios> usuarios = new ArrayList<Usuarios>();
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "perfiles")
	private List<Paginas> paginas = new ArrayList<Paginas>();

	public Perfiles() {
		
	}

	public Perfiles(int idPerfil) {
		super();
		this.idPerfil = idPerfil;
	}
	
	public Perfiles(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getIdPerfil() {
		return idPerfil;
	}
	
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Paginas> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<Paginas> paginas) {
		this.paginas = paginas;
	}
}
