
package sietice;

import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import javax.faces.FacesException;
import siet.modelo.Empleado;
import siet.servicio.ServicioEmpleado;
import sietice.reportes.RecursoFile;


public class PaginaEmpleado extends AbstractPageBean {
     private RecursoFile recursoAyuda;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    
    public PaginaEmpleado() {
    }

    @Override
    public void init() {
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


    public  ServicioEmpleado getServicioEmpleado(){
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }

    public RecursoFile getRecursoAyuda() {
        InterceptingServletSession e = (InterceptingServletSession)getExternalContext().getSession(true);
        String c = e.getServletContext().getRealPath("/")+"recursos"+File.separator+"Ayuda_Personal.pdf";
        recursoAyuda = new RecursoFile(c);
        return recursoAyuda;
    }
   
    public String btnempleados_action() {

     getServicioEmpleado().listarTodos();
        return "case-adminemplead";
    }

    public String btnclientes_action() {
     
        return "case1";
    }

    public String btnproyectos_action() {
     
        return "case-adminpro";
    }

   

    public String btnsalir_action() {
        getServicioEmpleado().salir();
        return "case-salir";
    }

  

    public String button1_action() {
         Empleado e = (Empleado)getServicioEmpleado().getEmpleadoLogeado();
        getServicioEmpleado().editar(e);
        return "case2";
      
    }
}
