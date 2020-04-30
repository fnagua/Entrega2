/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import jpa.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Iterator;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Actividad.estado;
import jpa.Actividad.tipo;
import sesiones.ControlAutorizacion;


@Named(value = "bd")
@RequestScoped
public class BD {
    
    private String usuario;
    private String contrasenia;
    
    private static List<Usuario> usuarios;
    private static List<Actividad> actividades;
    private static Actividad mostrarActividad;
    private static Usuario nuevousuario;
    private static Afiliado nuevoafiliado;
    private static Responsable nuevoresponsable;

    public static Afiliado getNuevoafiliado() {
        return nuevoafiliado;
    }

    public static void setNuevoafiliado(Afiliado nuevoafiliado) {
        BD.nuevoafiliado = nuevoafiliado;
    }

    public static Responsable getNuevoresponsable() {
        return nuevoresponsable;
    }

    public static void setNuevoresponsable(Responsable nuevoresponsable) {
        BD.nuevoresponsable = nuevoresponsable;
    }
    
    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        BD.usuarios = usuarios;
    }

    public static Actividad getMostrarActividad() {
        return mostrarActividad;
    }

    public static void setMostrarActividad(Actividad mostrarActividad) {
        BD.mostrarActividad = mostrarActividad;
    }

    public static Usuario getNuevoUsuario() {
        return nuevousuario;
    }

    public static void setNuevoUsuario(Usuario nuevoUsuario) {
        BD.nuevousuario = nuevoUsuario;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    @Inject
    private ControlAutorizacion ctrl;
    
    public BD() throws Exception {
        // USUARIOS
        usuarios = new ArrayList<Usuario>();
        
        usuarios.add(new Usuario("fran", "aasdf@uma.es","Francisco", "asdf asdf", "asdf", Usuario.Rol.VOLUNTARIO));
        usuarios.add(new Usuario("miguel", "assdf@uma.es","Francisco", "asdf asdf", "asdf", Usuario.Rol.AFILIADO));
        usuarios.add(new Usuario("raul", "asddf@uma.es","Francisco", "asdf asdf", "asdf", Usuario.Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("david", "asdff@uma.es","Francisco", "asdf asdf", "asdf", Usuario.Rol.RESPONSABLE));
    
        // ACTIVIDADES
        actividades = new ArrayList<Actividad>();
        
        
        actividades.add(new Actividad("Actividad_Disponible", tipo.Formacion,   estado.Disponible, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"), "Descripcion Actividad_Disponible", "Estepona"));
        actividades.add(new Actividad("Actividad_Disponible", tipo.Formacion,   estado.Disponible, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"), "Descripcion Actividad_Disponible", "Estepona"));
        actividades.add(new Actividad("Actividad_Finalizada", tipo.Formacion,   estado.Finalizada, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"), "Descripcion Actividad_Finalizada", "Málaga"));
        actividades.add(new Actividad("Actividad_Pendiente",  tipo.Voluntariado,estado.Pendiente, new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("11/06/2020"), "Descripcion Actividad_Pendiente", "Marbella"));
        actividades.add(new Actividad("Actividad_Pendiente",  tipo.Voluntariado,estado.Rechazada, new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("11/06/2020"), "Descripcion Actividad_Pendiente", "Marbella"));
    }
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public Actividad getActividad(Long id){
         Actividad res = null;
        for(Actividad a : actividades){
            if(a.getId()==id){
                res = a;
            }
        }
        return res;
     }
    public Actividad getActividad(){
        return mostrarActividad;
    }
    public List<Actividad> getActividades(){
        return actividades;
    }
    
    public List<Actividad> getActividadesDisponibles(){
        List<Actividad> ad = new ArrayList<Actividad>();
        
        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Disponible))
            ad.add(a);
        }
        
        return ad;
    }
    
    public List<Actividad> getActividadesFinalizadas(){
        List<Actividad> af = new ArrayList<Actividad>();
        
        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Finalizada))
            af.add(a);
        }
        
        return af;
    }
    
    public List<Actividad> getActividadesPendientes(){
        List<Actividad> ap = new ArrayList<Actividad>();
        
        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Pendiente))
            ap.add(a);
        }
        
        return ap;
    }
    
    public List<Actividad> getActividadesRechazadas(){
        List<Actividad> ar = new ArrayList<Actividad>();
        
        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Rechazada))
            ar.add(a);
        }
        
        return ar;
    }
    public String actividad(Long id){

        mostrarActividad = getActividad(id);
        
        return "actividad.xhtml";
    }
    public int getParticipantes(){
        return mostrarActividad.getUsuarios().size();
    }
    
    public void addUsuario(String usuario, String email, String nombre, String apellidos, String contrasenia, Usuario.Rol rol){
        usuarios.add(new Usuario(usuario, email, nombre, apellidos, contrasenia, rol));
    }
    
    public String autenticar() {
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        Boolean b = false;
        Iterator i = usuarios.iterator();
        
        Usuario u = null;
        
        while(i.hasNext() && !b) {//buscamos el usuario
            u = (Usuario) i.next();
            if(u.getUsuario().equals(usuario)) {
                b = true;
            }
        }
        
        if(b) {//usuario encontrado
            if(u.getContrasenia().equals(contrasenia)) {//contraseña correcta
                ctrl.setUsuario(u);
                ctrl.setLogeado(true);
                return ctrl.home();
            } else {//contraseña incorrecta
               FacesMessage fm = new FacesMessage("La contraseña no es correcta");
                FacesContext.getCurrentInstance().addMessage("login:pass", fm);
            }
        } else {//usuario no encontrado
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        }
        return "login.xhtml";
    }
    public String registrar(){
        
        return "lista.xhtml";
    }
    public String selecciona(String s){
        switch(s){
            case "2": Responsable res = new Responsable();
                break;
            case "3": Afiliado afi = new Afiliado();
                break;
        }
        return "";
    }
    
}
