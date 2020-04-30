package jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import jpa.Actividad;

@Entity
public class Curso implements Serializable {
    
	private static final long serialVersionUID = 1L;
        @Id @GeneratedValue
        Long id;
	@Column(nullable = false)
	private String Nombre_Titulacion;
	private Integer Curso;
	
	@ManyToMany(mappedBy = "cursos")//requiere
	private List<Actividad> actividades;
        
        @ManyToMany//estudia
        @JoinTable(name = "CURSO_USUARIOS", joinColumns = { @JoinColumn(name = "curso_fk") }, inverseJoinColumns = { @JoinColumn(name = "usuarios_fk") })
        private List<Usuario> usuarios;

	public Curso() {
		super();
	}
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public String getNombre_Titulacion(){
		return this.Nombre_Titulacion;
	}
	public void setNombre_Titulacion(String titulacion) {
		this.Nombre_Titulacion=titulacion;
	}
	public Integer getCurso() {
		return this.Curso;
	}
	public void setCurso(int i) {
		this.Curso=i;
	}
        
        @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Artist[ id=" + id + " ]";
    }
        
}
