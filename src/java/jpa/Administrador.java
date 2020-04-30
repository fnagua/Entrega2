package jpa;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Administrador extends Usuario_old implements Serializable {
	
        @ManyToMany//administra
        @JoinTable(name = "ADMINISTRADOR_USUARIOS", joinColumns = { @JoinColumn(name = "administrador_fk") }, inverseJoinColumns = { @JoinColumn(name = "usuarios_fk") })
	private List<Usuario_old> usuarios;
        
	@ManyToMany//crea
        @JoinTable(name = "ADMINISTRADOR_AMBITOS", joinColumns = { @JoinColumn(name = "administrador_fk") }, inverseJoinColumns = { @JoinColumn(name = "ambitos_fk") })
	private List<Ambito> ambitos;
	
	public Administrador() {
		super();
	}
        
}
