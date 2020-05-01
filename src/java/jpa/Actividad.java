/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David
 */
@Entity
public class Actividad implements Serializable {
    
    public enum estado { Disponible, Finalizada, Pendiente, Rechazada };
    
    public enum tipo { Formacion, Voluntariado };

    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private tipo tipo;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private estado estado;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
   
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    private String descripcion;
    
    private String NumParticipantes;
    
    private String Lugar;
    
    private String valoraciones;
    
    @ManyToMany//requiere
    @JoinTable(name = "ACTIVIDAD_CURSOS", joinColumns = { @JoinColumn(name = "actividad_fk") }, inverseJoinColumns = { @JoinColumn(name = "cursos_fk") })
    private List<Curso> cursos;
    
    @ManyToMany//participa
    @JoinTable(name = "ACTIVIDAD_USUARIOS", joinColumns = { @JoinColumn(name = "actividad_fk") }, inverseJoinColumns = { @JoinColumn(name = "usuarios_fk") })
    private List<Usuario> usuarios;

    public String getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(String valoraciones) {
        this.valoraciones = valoraciones;
    }
    
    

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    public void addUser(Usuario u){
        usuarios.add(u);
    }
    public List<Usuario> getUsuarios() {
        if(usuarios==null)return new ArrayList<Usuario>();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Ambito> getAmbitos() {
        return ambitos;
    }

    public void setAmbitos(List<Ambito> ambitos) {
        this.ambitos = ambitos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Entidad getEntidadesO() {
        return entidadesO;
    }

    public void setEntidadesO(Entidad entidadesO) {
        this.entidadesO = entidadesO;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Afiliado afiliado) {
        this.afiliado = afiliado;
    }
    
    @ManyToMany//requiere
    @JoinTable(name = "ACTIVIDAD_AMBITOS", joinColumns = { @JoinColumn(name = "actividad_fk") }, inverseJoinColumns = { @JoinColumn(name = "ambitos_fk") })
    private List<Ambito> ambitos;
    
    @ManyToOne//propone
    private Usuario usuario;
    
    @ManyToOne//valida
    private Responsable responsable;
    
    @ManyToOne//organiza
    private Entidad entidadesO;
    
    @ManyToOne//Valida
    private Afiliado afiliado;
    
    public Actividad (String nombre, tipo tipo, estado estado, Date fechaInicio, Date fechaFin, String descripcion, String lugar) {
    setNombre(nombre);
    setTipo(tipo);
    setEstado(estado);
    setFechaInicio(fechaInicio);
    setFechaFin(fechaFin);
    setDescripcion(descripcion);
    setLugar(lugar);
    }
    
    public Long getId() {
        return id;
    }
    //No se debe modificar NUNCA
    private void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public estado getEstado() {
        return estado;
    }

    public void setEstado(estado estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fechaInicio);
        return strDate;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fechaFin);
        return strDate;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
    public String getNumParticipantes(){
        return this.NumParticipantes;
    }
    
    public void setNumParticipantes(String num){
        this.NumParticipantes=num;
    }
    
    public String getLugar(){
        return(this.Lugar);
    }
    
    public void setLugar(String lugar){
        this.Lugar=lugar;
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
