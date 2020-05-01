/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import java.io.Serializable;
import jpa.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Actividad.estado;
import jpa.Actividad.tipo;
import sesiones.ControlAutorizacion;


@Named(value = "bd")
//@ViewScoped
@SessionScoped
//@RequestScoped
public class BD implements Serializable {

    private String usuario;
    private String contrasenia;

    private static List<Usuario> usuarios;
    private static List<Actividad> actividades;
    private static Actividad mostrarActividad;

    private String tipoUsuario;
    private String usuarioo;
    private String email;
    private String nombre;
    private String apellidos;
    private String contraseniaa;
    private String numero;
    private String descripcion;
    private String dni;

    private String elegir;
    private Usuario.Rol rol;

    @Inject
    private ControlAutorizacion ctrl;
    
    public static void setActividades(List<Actividad> actividades) {
        BD.actividades = actividades;
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
    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

    public BD() throws Exception {
        // USUARIOS
        usuarios = new ArrayList<Usuario>();

        usuarios.add(new Usuario("fran", "aasdf@uma.es","Francisco", "asdf asdf", "asdf", Usuario.Rol.VOLUNTARIO));
        usuarios.add(new Usuario("miguel", "assdf@uma.es","Miguel", "asdf asdf", "asdf", Usuario.Rol.AFILIADO));
        usuarios.add(new Usuario("raul", "asddf@uma.es","Raul", "asdf asdf", "asdf", Usuario.Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("david", "asdff@uma.es","David", "asdf asdf", "asdf", Usuario.Rol.RESPONSABLE));

        // ACTIVIDADES
        actividades = new ArrayList<Actividad>();


        actividades.add(new Actividad("Actividad_Disponible", tipo.Formacion,   estado.Disponible, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"), "Descripcion Actividad_Disponible", "Estepona"));
        actividades.add(new Actividad("Actividad_Disponible", tipo.Formacion,   estado.Disponible, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"), "Descripcion Actividad_Disponible", "Estepona"));
        actividades.add(new Actividad("Actividad_Finalizada", tipo.Formacion,   estado.Finalizada, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"), "Descripcion Actividad_Finalizada", "Málaga"));
        actividades.add(new Actividad("Actividad_Pendiente",  tipo.Voluntariado,estado.Pendiente, new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("11/06/2020"), "Descripcion Actividad_Pendiente", "Marbella"));
        actividades.add(new Actividad("Actividad_Pendiente",  tipo.Voluntariado,estado.Rechazada, new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("11/06/2020"), "Descripcion Actividad_Pendiente", "Marbella"));
    }
    public void addUser(Usuario u){
        usuarios.add(u);
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

   public String getTipo() {
        return tipoUsuario;
    }

    public void setTipo(String tipo) {
        this.tipoUsuario = tipo;
    }

    public String getUsuarioo() {
        return usuarioo;
    }

    public void setUsuarioo(String usuario) {
        this.usuarioo = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContraseniaa() {
        return contraseniaa;
    }

    public void setContraseniaa(String contrasenia) {
        this.contraseniaa = contrasenia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public String registrar(){
        Usuario user = new Usuario(usuarioo,email,nombre,apellidos,contraseniaa,rol);
        usuarios.add(user);
        return "login.xhtml";
    }

    public String getElegir() {
        return elegir;
    }

    public void setElegir(String elegir) {
        this.elegir = elegir;
    }
    public String elegir(){
        String s="";
        switch(elegir){
            case "1": rol=Usuario.Rol.VOLUNTARIO; s="registroVoluntario.xhtml";
            break;
            case "2": rol=Usuario.Rol.RESPONSABLE; s="registroResponsable.xhtml";
            break;
            case "3": rol=Usuario.Rol.AFILIADO; s="registroAfiliado.xhtml";
            break;
        }
         return s;
    }
    
    public String modificarUsuario() {
        Usuario user = ctrl.getUsuario();
        if(!nombre.equals("")) {
            user.setNombre(nombre);
            nombre="";
        }
        if(!apellidos.equals("")) {
            user.setApellidos(apellidos);
            apellidos="";
        }
        
        if(!usuarioo.equals("")) {
            user.setUsuario(usuarioo);
            usuarioo="";
        }
        
        if(!email.equals("")) {
            user.setEmail(email);
            email="";
        }
        ctrl.setUsuario(user);
        return "perfil.xhtml";
    }
}
