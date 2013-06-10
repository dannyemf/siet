/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import siet.dao.EmpleadoDAO;
import siet.servicio.ServicioEmpleado;
import siet.util.EncrypUtil;



public class LoginPersonal extends AbstractPageBean {

    private String mensaje = "";
    private String caso ="";
    private String clave = "";
    private String rolband="";
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private String Usuario;
    

    public LoginPersonal() {
    }

    @Override
    public void init() {

        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
      
    }

    @Override
    public void preprocess() {
    }

    @Override
    public void prerender() {
    }

    @Override
    public void destroy() {
    }

   


    protected ServicioEmpleado  getServicioEmpleado(){
    return (ServicioEmpleado)getBean("ServicioEmpleado");
    }

 

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Contraseña
     */
   

    /**
     * @return the caso
     */
    public String getCaso() {
        return caso;
    }

    /**
     * @param caso the caso to set
     */
    public void setCaso(String caso) {
        this.caso = caso;
    }

    /**
     * @return the Clave
     */
   

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
  
     public String btn_inicio_action() {
        //return null means stay on the same page
       mensaje= "";
        clave="";
        return "case1";
    }

    public String btningresar1_action() {
        //return null means stay on the same page

        String eclave = EncrypUtil.encriptar(clave);
        if(getServicioEmpleado().logearAdmin(Usuario, eclave))
        {
             Usuario="";
               mensaje= "";
               clave="";
               return "case-admin";
        }


        if(getServicioEmpleado().logear(Usuario,eclave)){

            Usuario="";
               mensaje= "";
               clave="";


            return "case-loginempleado";
        }else{

            mensaje = "Usuario o Contraseña Incorrectos";
            return null;

    }

    }

    /**
     * @return the rolband
     */
    public String getRolband() {
        return rolband;
    }

    /**
     * @param rolband the rolband to set
     */
    public void setRolband(String rolband) {
        this.rolband = rolband;
    }

    /**
     * @return the rol
     */
  
    
}

