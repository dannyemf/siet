/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sietice;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.model.SelectItem;
import javax.faces.validator.LengthValidator;
import siet.servicio.ServicioCliente;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioEmpleado;

public class EditarPersonal extends AbstractPageBean {    

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        lengthValidatorapellido.setMaximum(15);
        lengthValidatorapellido.setMinimum(3);
        lengthValidatordoapellido.setMaximum(15);
        lengthValidatordoapellido.setMinimum(3);
        lengthValidatornombre.setMaximum(15);
        lengthValidatornombre.setMinimum(3);
        lengthValidatorcelular.setMaximum(9);
        lengthValidatorcelular.setMinimum(9);
    }
    
    private LengthValidator lengthValidatorapellido = new LengthValidator();

    public LengthValidator getLengthValidatorapellido() {
        return lengthValidatorapellido;
    }

    public void setLengthValidatorapellido(LengthValidator lv) {
        this.lengthValidatorapellido = lv;
    }
    private LengthValidator lengthValidatordoapellido = new LengthValidator();

    public LengthValidator getLengthValidatordoapellido() {
        return lengthValidatordoapellido;
    }

    public void setLengthValidatordoapellido(LengthValidator lv) {
        this.lengthValidatordoapellido = lv;
    }
    private LengthValidator lengthValidatornombre = new LengthValidator();

    public LengthValidator getLengthValidatornombre() {
        return lengthValidatornombre;
    }

    public void setLengthValidatornombre(LengthValidator lv) {
        this.lengthValidatornombre = lv;
    }
    private LengthValidator lengthValidatorcelular = new LengthValidator();

    public LengthValidator getLengthValidatorcelular() {
        return lengthValidatorcelular;
    }

    public void setLengthValidatorcelular(LengthValidator lv) {
        this.lengthValidatorcelular = lv;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditarPersonal() {
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

    public ArrayList<SelectItem> getSexo(){
        return ((ServicioEmpleado)getBean("ServicioEmpleado")).getSexo();
    }

    public ArrayList<SelectItem> getEstadoCivil(){
        return ((ServicioEmpleado)getBean("ServicioEmpleado")).getEstadoCivil();
    }

    public ArrayList<SelectItem> getRol(){
        return ((ServicioEmpleado)getBean("ServicioEmpleado")).getRol();
    }

    public ArrayList<SelectItem> getEstado(){
        return ((ServicioEmpleado)getBean("ServicioEmpleado")).getEstado();
    }

    protected ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

    public ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }

    public ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }

        

    public String btnaceptar_action() {
        getServicioEmpleado().guardar();
        // TODO: Replace with your code
        return "aceptar";
    }

    public String btncancelar_action() {
        //return null means stay on the same page
        getServicioEmpleado().setEmpleadoEdicion(null);
        return "cancelar";
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }
    
}

