/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import java.io.Serializable;
import java.text.ParseException;
import jpa.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Iterator;
//import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
//import javax.faces.bean.ViewScoped;
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
    
    //BD en si misma
    private List<Usuario> usuarios;
    private List<Actividad> actividades;

    //atributos del login
    @Inject
    private ControlAutorizacion ctrl;
    private String usuario;
    private String contrasenia;
    
    
    //Actividad Actual
    private Actividad mostrarActividad;

    
    //atributos del registro y edición de perfil
    private String tipoUsuario;
    private String usuarioo;
    private String email;
    private String nombre;
    private String apellidos;
    private String contraseniaa;
    private String contraseniaa2;
    private String numero;
    private String descripcion;
    private String dni;
    private Usuario.Rol rol;
    
    
    //selección de tipo de perfil
    private String elegir;
    

    //atributos de Proponer actividad
    private String nombrea;
    private String fechaInicioa;
    private String fechaFina;
    private String numParticipantesa;
    private String lugara;
    private String descripciona;
    private String tipoa;
    private String valoracion;
    private String val;  
    

    public BD() throws Exception {
        // USUARIOS
        usuarios = new ArrayList<>();

        usuarios.add(new Usuario("fran", "aasdf@uma.es","Francisco", "asdf asdf", "asdf", Usuario.Rol.VOLUNTARIO));
        usuarios.add(new Usuario("miguel", "assdf@uma.es","Miguel", "asdf asdf", "asdf", Usuario.Rol.AFILIADO));
        usuarios.add(new Usuario("raul", "asddf@uma.es","Raul", "asdf asdf", "asdf", Usuario.Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("david", "asdff@uma.es","David", "asdf asdf", "asdf", Usuario.Rol.RESPONSABLE));

        // ACTIVIDADES
        actividades = new ArrayList<>();

        actividades.add(new Actividad("Actividad_Disponible", tipo.Formacion,   estado.Disponible, new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020"), "Descripcion Actividad_Disponible", "Estepona"));
        actividades.add(new Actividad("Actividad_Finalizada", tipo.Formacion,   estado.Finalizada, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"), "Descripcion Actividad_Finalizada", "Málaga"));
        actividades.add(new Actividad("Actividad_Pendiente",  tipo.Voluntariado,estado.Pendiente, new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("11/06/2020"), "Descripcion Actividad_Pendiente", "Marbella"));
        actividades.add(new Actividad("Actividad_Rechazada",  tipo.Voluntariado,estado.Rechazada, new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2020"), new SimpleDateFormat("dd/MM/yyyy").parse("11/06/2020"), "Descripcion Actividad_Pendiente", "Marbella"));
    }
    
    
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }
    
    public String getTipoa() {
        return tipoa;
    }

    public void setTipoa(String tipoa) {
        this.tipoa = tipoa;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getContraseniaa2() {
        return contraseniaa2;
    }

    public void setContraseniaa2(String contraseniaa2) {
        this.contraseniaa2 = contraseniaa2;
    }

    public Usuario.Rol getRol() {
        return rol;
    }

    public void setRol(Usuario.Rol rol) {
        this.rol = rol;
    }
    
    
    
    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Actividad getMostrarActividad() {
        return mostrarActividad;
    }

    public void setMostrarActividad(Actividad mostrarActividad) {
        this.mostrarActividad = mostrarActividad;
    }
    
    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    public Actividad getActividad(){
        return mostrarActividad;
    }
    
    public List<Actividad> getActividades(){
        return actividades;
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
    
    public String getElegir() {
        return elegir;
    }

    public void setElegir(String elegir) {
        this.elegir = elegir;
    }
    
    public String getNombrea() {
        return nombrea;
    }

    public void setNombrea(String nombrea) {
        this.nombrea = nombrea;
    }

    public String getFechaInicioa() {
        return fechaInicioa;
    }

    public void setFechaInicioa(String fechaInicioa) {
        this.fechaInicioa = fechaInicioa;
    }

    public String getFechaFina() {
        return fechaFina;
    }

    public void setFechaFina(String fechaFina) {
        this.fechaFina = fechaFina;
    }

    public String getNumParticipantesa() {
        return numParticipantesa;
    }

    public void setNumParticipantesa(String numParticipantesa) {
        this.numParticipantesa = numParticipantesa;
    }

    public String getLugara() {
        return lugara;
    }

    public void setLugara(String lugara) {
        this.lugara = lugara;
    }
    
    public String getDescripciona() {
        return descripciona;
    }

    public void setDescripciona(String descripciona) {
        this.descripciona = descripciona;
    }
    
    //busca actividad por id
    public Actividad getActividad(Long id){
         Actividad res = null;
        for(Actividad a : actividades){
            if(a.getId() == id){
                res = a;
            }
        }
        return res;
     }
   
    //buscan actividades según estado
    public List<Actividad> getActividadesDisponibles(){
        List<Actividad> ad = new ArrayList<>();

        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Disponible))
            ad.add(a);
        }

        return ad;
    }
    public List<Actividad> getActividadesFinalizadas(){
        List<Actividad> af = new ArrayList<>();

        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Finalizada))
            af.add(a);
        }

        return af;
    }
    public List<Actividad> getActividadesPendientes(){
        List<Actividad> ap = new ArrayList<>();

        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Pendiente))
            ap.add(a);
        }

        return ap;
    }
    public List<Actividad> getActividadesRechazadas(){
        List<Actividad> ar = new ArrayList<>();

        for (Actividad a : actividades) {
            if(a.getEstado().equals(estado.Rechazada))
            ar.add(a);
        }

        return ar;
    }
    
    //muestra actividad seleccionada
    public String actividad(Actividad a){ 
        setMostrarActividad(a);
        return "actividad.xhtml?faces-redirect=true";
    }
    
    //numero de participantes
    public int getParticipantes(){
        if(mostrarActividad.getUsuarios()==null){
            return 0;
        }
        return mostrarActividad.getUsuarios().size();
    }

    //añade un usuario por sus parámetros
    public void addUsuario(String usuario, String email, String nombre, String apellidos, String contrasenia, Usuario.Rol rol){
        usuarios.add(new Usuario(usuario, email, nombre, apellidos, contrasenia, rol));
    }
    
    //logea un usuario comprobando que es correcto
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
                return ctrl.home();
            } else {//contraseña incorrecta
                FacesMessage fm = new FacesMessage("La contraseña no es correcta");
                ctx.addMessage("login:pass", fm);
            }
        } else {//usuario no encontrado
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            ctx.addMessage("login:user", fm);
        }
        return "login.xhtml";
    }

    //registran un usuario comprobando las entradas
    public String registrarVoluntario(){
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        if (usuarioo.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Nombre de Usuaro\" vacío");
            ctx.addMessage("registroVoluntario:inputUserName", fm);
            return "registroVoluntario.xhtml";
        }
        
        if (email.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Email\" vacío");
            ctx.addMessage("registroVoluntario:inputEmailAddress", fm);
            return "registroVoluntario.xhtml";
        }
        
        if (nombre.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Nombre\" vacío");
            ctx.addMessage("registroVoluntario:inputName", fm);
            return "registroVoluntario.xhtml";
        }
        
        if (apellidos.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Apellidos\" vacío");
            ctx.addMessage("registroVoluntario:inputLastName", fm);
            return "registroVoluntario.xhtml";
        }
        
        if (contraseniaa.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Password\" vacío");
            ctx.addMessage("registroVoluntario:inputPassword", fm);
            return "registroVoluntario.xhtml";
        }
        
        if (!contraseniaa2.equals(contraseniaa)) {
            FacesMessage fm = new FacesMessage("Las contraseñas no coinciden");
            ctx.addMessage("registroVoluntario:inputConfirmPassword", fm);
            return "registroVoluntario.xhtml";
        }
        
        Usuario user = new Usuario(usuarioo,email,nombre,apellidos,contraseniaa,rol);
        usuarios.add(user);
        email="";
        nombre="";
        apellidos="";
        usuarioo="";
        return "login.xhtml";
    }
    public String registrarAfiliado(){
        
        if (usuarioo.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Nombre de Usuaro\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroAfiliado:inputUserName", fm);
            return "registroAfiliado.xhtml";
        }
        
        if (email.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Email\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroAfiliado:inputEmailAddress", fm);
            return "registroAfiliado.xhtml";
        }
        
        if (nombre.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Nombre\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroAfiliado:inputName", fm);
            return "registroAfiliado.xhtml";
        }
        
        if (apellidos.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Apellidos\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroAfiliado:inputLastName", fm);
            return "registroAfiliado.xhtml";
        }
        
        if (contraseniaa.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Password\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroAfiliado:inputPassword", fm);
            return "registroAfiliado.xhtml";
        }
        
        if (!contraseniaa2.equals(contraseniaa)) {
            FacesMessage fm = new FacesMessage("Las contraseñas no coinciden");
            FacesContext.getCurrentInstance().addMessage("registroAfiliado:inputPassword", fm);
            return "registroAfiliado.xhtml";
        }
        
        if (dni.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"DNI\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroAfiliado:inputDNI", fm);
            return "registroAfiliado.xhtml";
        }
        
        Usuario user = new Usuario(usuarioo,email,nombre,apellidos,contraseniaa,rol);
        usuarios.add(user);
        email="";
        nombre="";
        apellidos="";
        usuarioo="";
        return "login.xhtml";
    }
    public String registrarResponsable(){
        
        if (usuarioo.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Nombre de Usuaro\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroResponsable:inputUserName", fm);
            return "registroResponsable.xhtml";
        }
        
        if (email.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Email\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroResponsable:inputEmailAddress", fm);
            return "registroResponsable.xhtml";
        }
        
        if (nombre.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Nombre\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroResponsable:inputName", fm);
            return "registroResponsable.xhtml";
        }
        
        if (apellidos.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Apellidos\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroResponsable:inputLastName", fm);
            return "registroResponsable.xhtml";
        }
        
        if (contraseniaa.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Password\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroResponsable:inputPassword", fm);
            return "registroResponsable.xhtml";
        }
        
        if (!contraseniaa2.equals(contraseniaa)) {
            FacesMessage fm = new FacesMessage("Las contraseñas no coinciden");
            FacesContext.getCurrentInstance().addMessage("registroResponsable:inputPassword", fm);
            return "registroResponsable.xhtml";
        }
        
        if (dni.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"DNI\" vacío");
            FacesContext.getCurrentInstance().addMessage("registroResponsable:inputDNI", fm);
            return "registroResponsable.xhtml";
        }
        Usuario user = new Usuario(usuarioo,email,nombre,apellidos,contraseniaa,rol);
        usuarios.add(user);
        email="";
        nombre="";
        apellidos="";
        usuarioo="";
        return "login.xhtml";
    }
    
    //selecciona el rol del registro
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
    
    //modifica un usuario comprobando las entradas
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
        return "perfil.xhtml?faces-redirect=true";
    }

    //aniade una nueva actividad pendiente comprobando las entradas
    public String proponer()throws Exception {
        //Comprobar nulls
        if(nombrea.isEmpty()) {
            FacesMessage fm = new FacesMessage("Campo \"Nombre\" vacío");
            FacesContext.getCurrentInstance().addMessage("proponer:fechaInicio", fm);
            return "proponer.xhtml";
        }
        if (!comprobarIntervaloFechas()) { //Comprueba formato y cronología
            return "proponer.xhtml?faces-redirect=true";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        tipo tip;
        if(tipoa.equals("1")){
            tip = tipo.Voluntariado;
        }else{
            tip = tipo.Formacion;
        }
        Actividad acti = new Actividad(nombrea,tip,estado.Pendiente, sdf.parse(fechaInicioa), sdf.parse(fechaFina), descripciona, lugara);
        actividades.add(acti);
        nombrea="";
        fechaInicioa=null;
        fechaFina=null;
        descripciona="";
        lugara="";
        setMostrarActividad(acti);
        return "actividad.xhtml?faces-redirect=true";
        
    }

    //aniade una valoración de una actividad
    public void valorar(){
        StringBuilder sb = new StringBuilder();
        sb.append("Estoy ");
        switch(valoracion){
            case "1": sb.append("nada satisfecho");
            break;
            case "2": sb.append("poco satisfecho");
            break;
            case "3": sb.append("satisfecho");
            break;
            case "4": sb.append("muy satisfecho");
            break;
            case "5": sb.append("totalmente satisfecho");
            break;
        }
        sb.append(" con esta actividad. \n");
        sb.append(val);
        mostrarActividad.setValoraciones(sb.toString());
        valoracion="";
        val="";
    }
    
    //cambia el estado de una actividad
    public String validar(){//ADMIN,RESPONSABLE,AFILIADO
        mostrarActividad.setEstado(estado.Disponible);
        return "listaVal.xhtml?faces-redirect=true";
    }
    public String rechazar(){//ADMIN,RESPONSABLE,AFILIADO
        mostrarActividad.setEstado(estado.Rechazada);
        return "listaVal.xhtml?faces-redirect=true";
    }
    
    //aniade al usuario logeado a la actividad seleccionada
    public String aniadirUsuario(){//todos ##LISTO##
        mostrarActividad.addUser(ctrl.getUsuario());
        return "actividad.xhtml?faces-redirect=true";
    }
    //quita al usuario logeado a la actividad seleccionada
    public String quitarUsuario(){//todos ##LISTO##
        mostrarActividad.removeUser(ctrl.getUsuario());
        return "actividad.xhtml?faces-redirect=true";
    }
    
    //quita una actividad
    public String eliminar(){//ADMIN,RESPONSABLE
        if(actividades.remove(mostrarActividad)){
            return "listaVal.xhtml?faces-redirect=true";
        }
        return "lista.xhtml?faces-redirect=true";
    }
    
    //devuelve los usuarios de la actividad actual
    public List<Usuario> usuarios(){
        return mostrarActividad.getUsuarios();
    }
    
    //dice si un usuario está o no en una actividad
    public boolean isUsuarioActividad(){
        return mostrarActividad.isUser(ctrl.getUsuario());
    }
    
    //dicen el estado de una actividad
    public boolean isDisponible(){
        return mostrarActividad.getEstado().equals(Actividad.estado.Disponible);
    }
    public boolean isPendiente(){
        return mostrarActividad.getEstado().equals(Actividad.estado.Pendiente);
    }
    
    //comprueba que una fecha sea correcta
    public boolean comprobarFecha(String f) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(f);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    //comprueba la coherencia entre fechas
    public boolean comprobarIntervaloFechas() {
        if(!comprobarFecha(fechaInicioa) ) {
            FacesMessage fm = new FacesMessage("Formato de fecha incorrecto, recuerde usar dd/MM/yyyy (01/01/2020)");
            FacesContext.getCurrentInstance().addMessage("proponer:fechaInicio", fm);
            fechaInicioa=null;
            return false;
        }
        if(!comprobarFecha(fechaFina) ) {
            FacesMessage fm = new FacesMessage("Formato de fecha incorrecto, recuerde usar dd/MM/yyyy (01/01/2020)");
            FacesContext.getCurrentInstance().addMessage("proponer:fechaFin", fm);
            fechaFina=null;
            return false;
        }
        if(fechaInicioa.compareTo(fechaFina) > 0) {
            FacesMessage fm = new FacesMessage("La fecha de inicio es posterior a la fecha de fin.");
            FacesContext.getCurrentInstance().addMessage("proponer:fechaInicio", fm);
            FacesContext.getCurrentInstance().addMessage("proponer:fechaFin", fm);
            fechaInicioa=null;
            fechaFina=null;
            return false;
         }
        return true;
    }
}
