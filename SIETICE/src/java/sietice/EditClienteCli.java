/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.ValidatorException;
import siet.servicio.ServicioCliente;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioDocumentacion;
import siet.servicio.ServicioEmpleado;
import siet.util.EncrypUtil;
import siet.util.StringUtil;
import sietice.reportes.RecursoFile;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditClienteCli.java
 * @version Created on 24/06/2010, 12:52:09 AM
 * @author Desarrollador
 */

public class EditClienteCli extends AbstractPageBean {

    private String clave="";
    private String confirmclave ="";

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
     private RecursoFile recursoAyuda;
    private void _init() throws Exception {
        lengthValidatorapellido.setMaximum(15);
        lengthValidatorclave.setMaximum(15);
        lengthValidatorclave.setMinimum(5);
        lengthValidatorconfclave.setMaximum(15);
        lengthValidatorconfclave.setMinimum(5);
        lengthValidatornombre.setMaximum(15);
        lengthValidatornombre.setMinimum(3);
    }
    private LengthValidator lengthValidatorapellido = new LengthValidator();

    public LengthValidator getLengthValidatorapellido() {
        return lengthValidatorapellido;
    }

    public void setLengthValidatorapellido(LengthValidator lv) {
        this.lengthValidatorapellido = lv;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditClienteCli() {
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
            log("EditClienteCli Initialization Failure", e);
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
    protected ServicioCliente getservicio$ServicioCliente() {
        return (ServicioCliente) getBean("servicio$ServicioCliente");
    }

    

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioProyecto getservicio$ServicioProyecto() {
        return (ServicioProyecto) getBean("servicio$ServicioProyecto");
    }

   

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioDocumentacion getservicio$ServicioDocumentacion() {
        return (ServicioDocumentacion) getBean("servicio$ServicioDocumentacion");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioEmpleado getservicio$ServicioEmpleado() {
        return (ServicioEmpleado) getBean("servicio$ServicioEmpleado");
    }

    public void txtcedula_validate(FacesContext context, UIComponent component, Object value) {
        boolean b = getServicioCliente().validarCedula(value.toString());
        if(!b){
            FacesMessage m = new FacesMessage("Cedula incorrecta");
            throw new ValidatorException(m);
        }
    }
    public  ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }

    public String btnaceptar_action() {

        String oldClave = getServicioCliente().getClienteEdicion().getClave();

        if(!StringUtil.isNullOrEmpty(clave)){
            if(clave.equals(confirmclave)){
                getServicioCliente().getClienteEdicion().setClave(EncrypUtil.encriptar(clave));
            }else{
                FacesContext.getCurrentInstance().addMessage("formEditCliente:secretconfclave", new FacesMessage("La confirmación de la clave no es correcta"));
                return null;
            }
        }

        boolean b = getServicioCliente().guardar();

        //Si hubo error al guardar restauro la clave inicial
        if(!b){
            getServicioCliente().getClienteEdicion().setClave(oldClave);
        }

        return "case1";
    }
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
    public void txtcelular_validate(FacesContext context, UIComponent component, Object value) {
       // boolean b = ServicioCliente.validarCedula(value.toString());
            if(value.toString().length()< 9){
                FacesMessage m = new FacesMessage(" Error Número de Celular incompleto");
                throw new ValidatorException(m);
            }


    }

    public String btnvolver1_action() {
        //return null means stay on the same page
        return "case2";
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

