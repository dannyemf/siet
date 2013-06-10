package sietice;

import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import javax.faces.FacesException;
import javax.faces.validator.LengthValidator;
import siet.servicio.ServicioCliente;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import sietice.reportes.RecursoFile;

public class Registrarcliente extends AbstractPageBean {

    private RecursoFile recursoAyuda;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        lengthValidatorApellido.setMaximum(40);
        lengthValidatorApellido.setMinimum(3);
        lengthValidatorApellidodos.setMinimum(3);
        lengthValidatorclave.setMinimum(5);
        lengthValidatorclave.setMaximum(15);
        lengthValidatorNombre.setMinimum(3);

        lengthValidatorconfclave.setMaximum(15);
        lengthValidatorconfclave.setMinimum(5);
        lengthValidatorcelular.setMinimum(9);
    }
   
    private LengthValidator lengthValidatorApellido = new LengthValidator();

    public LengthValidator getLengthValidatorApellido() {
        return lengthValidatorApellido;
    }

    public void setLengthValidatorApellido(LengthValidator lv) {
        this.lengthValidatorApellido = lv;
    }
    private LengthValidator lengthValidatorApellidodos = new LengthValidator();

    public LengthValidator getLengthValidatorApellidodos() {
        return lengthValidatorApellidodos;
    }

    public void setLengthValidatorApellidodos(LengthValidator lv) {
        this.lengthValidatorApellidodos = lv;
    }
    public LengthValidator lengthValidatorclave = new LengthValidator();

    public LengthValidator getLengthValidatorclave() {
        return lengthValidatorclave;
    }

    public void setLengthValidatorclave(LengthValidator lv) {
        this.lengthValidatorclave = lv;
    }
    public LengthValidator lengthValidatorconfclave = new LengthValidator();

    public LengthValidator getLengthValidatorconfclave() {
        return lengthValidatorconfclave;
    }

    public void setLengthValidatorconfclave(LengthValidator lv) {
        this.lengthValidatorconfclave = lv;
    }
    
    public LengthValidator lengthValidatorNombre = new LengthValidator();

    public LengthValidator getLengthValidatorNombre() {
        return lengthValidatorNombre;
    }

    public void setLengthValidatorNombre(LengthValidator lv) {
        this.lengthValidatorNombre = lv;
    }
    private LengthValidator lengthValidatorcelular = new LengthValidator();

    public LengthValidator getLengthValidatorcelular() {
        return lengthValidatorcelular;
    }

    public void setLengthValidatorcelular(LengthValidator lv) {
        this.lengthValidatorcelular = lv;
    }

    // </editor-fold>
    public Registrarcliente() {
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
   

    public ArrayList<SelectItem> getEstadoCivil() {
        return getServicioCliente().getEstadoCivil();
    }   

    public ArrayList<SelectItem> getSexo() {
        return getServicioCliente().getSexo();
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

    public ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }

    public String btnaceptar_action() {
        //setClave(ServicioCliente.getStringMessageDigest(clave));
        //0 getServicioCliente().getClienteEdicion().setClave(ServicioCliente.getStringMessageDigest(clave));           

        if (getServicioCliente().guardar()) {
            return "case-aceptarcliente";
        }

        return null;

    }

    public String hyperlink1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }          

    public RecursoFile getRecursoAyuda() {
        InterceptingServletSession e = (InterceptingServletSession) getExternalContext().getSession(true);
        String c = e.getServletContext().getRealPath("/") + "recursos" + File.separator + "Ayuda_Cliente.pdf";
        recursoAyuda = new RecursoFile(c);
        return recursoAyuda;
    }

    public void setRecursoAyuda(RecursoFile recursoAyuda) {
        this.recursoAyuda = recursoAyuda;
    }

    public String btnvolver1_action() {
        //return null means stay on the same page
        return "case-vol";
    }
    
}

