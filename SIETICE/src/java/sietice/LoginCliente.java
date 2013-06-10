package sietice;

import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import siet.dao.ProyectoDAO;
import siet.modelo.Cliente;
import siet.modelo.ProyectoCliente;
import siet.servicio.ServicioCliente;
import siet.util.EncrypUtil;
import sietice.reportes.RecursoFile;



public class LoginCliente extends AbstractPageBean {

   private String mensaje="";
    String cedula = "";
    private String clave = "";
    private RecursoFile recursoAyuda;
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    private void _init() throws Exception {
    }

    public LoginCliente() {
    }

    @Override
    public void init() {
// Perform initializations inherited from our superclass
        // Perform initializations inherited from our superclass
        super.init();
// Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
// <editor-fold defaultstate="collapsed" desc="Visual-Web-managed Component Initialization">
// Initialize automatically managed components
        // *Note* - this logic should NOT be modified
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

    

    protected ServicioCliente getServicioCliente(){
        return (ServicioCliente)getBean("ServicioCliente");
    }
  
    public String btnaceptar_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
         String eclave = EncrypUtil.encriptar(clave);
         System.out.println("CALVE antes log"+eclave);
        boolean b = getServicioCliente().logear(cedula,eclave);
        if( b == false){
            mensaje="Número de Cédula o Clave Incorrectos";
            return null;
        }
        
        Cliente c = getServicioCliente().getClienteLogeado();
        ProyectoCliente p = new ProyectoDAO().buscarPorCliente(c);
        if(p !=null && p.getEstado().equals("APROBADO")){
             mensaje="";
            cedula="";
            return  "case-aprobado";
        }
        cedula="";
        return "case-aceptaclient";
    }

    public String btnregistrarse_action() {
        mensaje="";
        cedula="";
      getServicioCliente().nuevo();
        return "case-registrarse";
    }

    public void textArea1_processValueChange(ValueChangeEvent vce) {
    }

    public void txtclave_processValueChange(ValueChangeEvent vce) {
    }

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

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String commandLink1_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnvolver_action() {
       mensaje="";
       cedula="";
        return "case-inicio";
    }

    /**
     * @return the recursoAyuda
     */
    public RecursoFile getRecursoAyuda() {
        InterceptingServletSession e = (InterceptingServletSession)getExternalContext().getSession(true);
        String c = e.getServletContext().getRealPath("/")+"recursos"+File.separator+"Ayuda_Cliente.pdf";
        recursoAyuda = new RecursoFile(c);
        return recursoAyuda;
    }

    /**
     * @param recursoAyuda the recursoAyuda to set
     */
    public void setRecursoAyuda(RecursoFile recursoAyuda) {
        this.recursoAyuda = recursoAyuda;
    }

    /**
     * @return the usuario
     */
   
    
}

