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
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioEmpleado;
import siet.servicio.ServicioCliente;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditarCliente.java
 * @version Created on 18/06/2010, 07:35:32 PM
 * @author Desarrollador
 */

public class EditarClienteEmpleado extends AbstractPageBean {   

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        lengthValidatorapellido.setMaximum(15);
        lengthValidatordoapellido.setMaximum(15);
        lengthValidatordoapellido.setMinimum(3);
        lengthValidatorcelular.setMaximum(9);
        lengthValidatorcedula.setMaximum(10);
        lengthValidatorcedula.setMinimum(10);
        lengthValidatornombre.setMaximum(30);
        lengthValidatorclave.setMaximum(15);
        lengthValidatorclave.setMinimum(5);
        lengthValidatorconfclave.setMaximum(15);
        lengthValidatorcelular.setMinimum(9);
        lengthValidatorconfclave.setMinimum(5);
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
    private LengthValidator lengthValidatorcelular = new LengthValidator();

    public LengthValidator getLengthValidatorcelular() {
        return lengthValidatorcelular;
    }

    public void setLengthValidatorcelular(LengthValidator lv) {
        this.lengthValidatorcelular = lv;
    }
    private LengthValidator lengthValidatorcedula = new LengthValidator();

    public LengthValidator getLengthValidatorcedula() {
        return lengthValidatorcedula;
    }

    public void setLengthValidatorcedula(LengthValidator lv) {
        this.lengthValidatorcedula = lv;
    }
    private LengthValidator lengthValidatornombre = new LengthValidator();

    public LengthValidator getLengthValidatornombre() {
        return lengthValidatornombre;
    }

    public void setLengthValidatornombre(LengthValidator lv) {
        this.lengthValidatornombre = lv;
    }
    private LengthValidator lengthValidatorclave = new LengthValidator();

    public LengthValidator getLengthValidatorclave() {
        return lengthValidatorclave;
    }

    public void setLengthValidatorclave(LengthValidator lv) {
        this.lengthValidatorclave = lv;
    }
    private LengthValidator lengthValidatorconfclave = new LengthValidator();

    public LengthValidator getLengthValidatorconfclave() {
        return lengthValidatorconfclave;
    }

    public void setLengthValidatorconfclave(LengthValidator lv) {
        this.lengthValidatorconfclave = lv;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditarClienteEmpleado() {
    }
    
    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     *
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("EditarCliente Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    public ArrayList<SelectItem> getEstadoCivil() {
        return getServicioCliente().getEstadoCivil();
    }   

    public ArrayList<SelectItem> getSexo() {
        return getServicioCliente().getSexo();
    }
    
    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
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
    @Override
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
    @Override
    public void destroy() {
    }

    

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    public  ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }
    
    public String btnaceptar_action() {
        // TODO: Process the button click action. Return value is a navigation        
        getServicioCliente().guardar();// case name where null will return to the same page.
        return "case1";
    }    

    public String btn_volver1_action() {
        //return null means stay on the same page
        return "case-vol";
    }    

}

