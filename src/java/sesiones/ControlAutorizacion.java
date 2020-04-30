/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesiones;

import jpa.Usuario;
import jpa.Usuario;
import static jpa.Usuario.Rol.ADMINISTRADOR;
import static jpa.Usuario.Rol.VOLUNTARIO;
import static jpa.Usuario.Rol.RESPONSABLE;
import static jpa.Usuario.Rol.AFILIADO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author francis
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;
    private boolean logged;
    public boolean isLogeado() {
        return logged;
    }

    public void setLogeado(boolean logeado) {
        this.logged = logeado;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public String perfil(){
        return "perfil.xhtml";
    }
    public String registro(){
        return "registro.xhtml";
    }
    public String login(){
        return "login.xhtml";
    }
    public String home() {
        
        return "lista.xhtml";
        
    }
    public String editarPerfil(){
        return "editar-perfil.xhtml";
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "lista.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
