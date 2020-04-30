package jpa;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;

@Entity

public class Entidad implements Serializable {
	
	@Id
	private String NIF;
	@Column(nullable = false)
	private String Nombre;
	private String Descripcion;
	@Column(unique= true)
	private String Email;
	@ManyToMany(mappedBy = "entidades")//pertenece
	private List <Afiliado> afiliados;
	
	@OneToMany//organiza
	private List <Actividad> actividadesO;
	
	public Entidad() { super(); }
	
	public void setNIF (String NIF) {this.NIF = NIF;}
	public String getNIF () {return this.NIF;}
	
	public void setNombre (String Nombre) {this.Nombre = Nombre;}
	public String getNombre () {return this.Nombre;}
	
	public void setDescripcion (String Descripcion) {this.Descripcion = Descripcion;}
	public String getDescripcion () {return this.Descripcion;}
	
	public void setEmail(String email){this.Email=email;}
	public String getEmail(){return this.Email;}
	
}
