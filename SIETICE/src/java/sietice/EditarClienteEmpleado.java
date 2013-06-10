/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.ValidatorException;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioEmpleado;
import siet.servicio.ServicioCliente;
import siet.util.EncrypUtil;
import siet.util.StringUtil;

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

    private String clave = "";
    private String confirmclave = "";

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
    private String mensajecedula="";
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
private ArrayList<SelectItem> estadoCivil;
    private ArrayList<SelectItem> sexo;

    public ArrayList<SelectItem> getEstadoCivil() {
        estadoCivil = new ArrayList<SelectItem>();
        estadoCivil.add(new SelectItem("SOLTERO", "Soltero"));
        estadoCivil.add(new SelectItem("CASADO", "Casado"));
         estadoCivil.add(new SelectItem("VIUDO", "Viudo"));
        estadoCivil.add(new SelectItem("DIVORCIADO", "Divorciado"));
        return estadoCivil;
    }
    public void setEstadoCivil(ArrayList<SelectItem> estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public ArrayList<SelectItem> getSexo() {
        sexo = new ArrayList<SelectItem>();
        sexo.add(new SelectItem("M","Masculino"));
        sexo.add(new SelectItem("F","Femenino"));
        return sexo;
    }

    public void setSexo(ArrayList<SelectItem> sexo) {
        this.sexo = sexo;
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

    public void txtcedula_validate(FacesContext context, UIComponent component, Object value) {
        boolean b = ServicioCliente.validarCedula(value.toString());
        if(!b){
            FacesMessage m = new FacesMessage("Cedula incorrecta");
            throw new ValidatorException(m);
        }
    }

    public void txtcelular_validate(FacesContext context, UIComponent component, Object value) {
       // boolean b = ServicioCliente.validarCedula(value.toString());
            if(value.toString().length()< 9){
                FacesMessage m = new FacesMessage(" Error Número de Celular incompleto");
                throw new ValidatorException(m);
            }


    }

    public boolean isRenderConfirmClave(){
        if(StringUtil.isNullOrEmpty(clave)){
            return false;
        }
        return true;
    }

    public String btnaceptar_action() {
        // TODO: Process the button click action. Return value is a navigation
        if(!StringUtil.isNullOrEmpty(clave)){
            getServicioCliente().getClienteEdicion().setClave(EncrypUtil.encriptar(getClave()));
        }
        getServicioCliente().guardar();// case name where null will return to the same page.
        return "case1";
    }

    public void clave_validate(FacesContext context, UIComponent component, Object value) {
        if(!StringUtil.isNullOrEmpty(value) && value.toString().trim().length() < 5){
            FacesMessage fm = new FacesMessage("Longitud mínima de 5 caracteres");
            throw new ValidatorException(fm);
        }
    }

    public void confclave_validate(FacesContext context, UIComponent component, Object value) {
        Object clave = ((UIInput)component.getParent().findComponent("formEditCli:secretclave")).getValue();

        if(StringUtil.isNullOrEmpty(value) && !StringUtil.isNullOrEmpty(clave)){
            FacesMessage fm = new FacesMessage("Por favor confirme la clave");
            throw new ValidatorException(fm);
        }

        if(!StringUtil.isNullOrEmpty(value) && value.toString().trim().length() < 5){
            FacesMessage fm = new FacesMessage("Longitud mínima de 5 caracteres");
            throw new ValidatorException(fm);
        }

        if(!StringUtil.isNullOrEmpty(value) && value.equals(clave) == false){
            FacesMessage fm = new FacesMessage("Por favor confirme la clave con el mismo valor");
            throw new ValidatorException(fm);
        }
    }

    /**
     * @return the mensajecedula
     */
    public String getMensajecedula() {
        return mensajecedula;
    }

    /**
     * @param mensajecedula the mensajecedula to set
     */
    public void setMensajecedula(String mensajecedula) {
        this.mensajecedula = mensajecedula;
    }

    public String btn_volver1_action() {
        //return null means stay on the same page
        return "case-vol";
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
     * @return the confirmclave
     */
    public String getConfirmclave() {
        return confirmclave;
    }

    /**
     * @param confirmclave the confirmclave to set
     */
    public void setConfirmclave(String confirmclave) {
        this.confirmclave = confirmclave;
    }

}

