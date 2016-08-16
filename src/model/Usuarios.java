package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {
	private static final long serialVersionUID = 123L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private int idUsuario;
	private String user;
	private String pass;
	private Date cumple;
	private String mail;
	@ManyToOne//(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil")
	private Perfiles perfil;
	@OneToMany(mappedBy = "usuario")
	@Cascade(CascadeType.DELETE)
	private List<Mapas> mapas = new ArrayList<Mapas>();

	public Usuarios() {
		
	}
	
	public Usuarios(int idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}

	public Usuarios(String user, String pass, Date cumple, String mail, Perfiles perfil) {
		super();
		this.user = user;
		this.pass = pass;
		this.cumple = cumple;
		this.mail = mail;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Date getCumple() {
		return cumple;
	}

	public void setCumple(Date cumple) {
		this.cumple = cumple;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Perfiles getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfiles perfil) {
		this.perfil = perfil;
	}
	
	public List<Mapas> getMapas() {
		return mapas;
	}

	public void setMapas(List<Mapas> mapas) {
		this.mapas = mapas;
	}
}
