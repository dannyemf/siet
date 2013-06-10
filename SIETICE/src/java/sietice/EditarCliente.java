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



public class EditarCliente extends AbstractPageBean {

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

    public EditarCliente() {
    }
    private String mensajecedula="";
    
    @Override
    public void init() {

        super.init();

        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
      
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
   
    @Override
    public void preprocess() {
    }

    @Override
    public void prerender() {
    }

    @Override
    public void destroy() {
    }


    protected ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

    protected ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }

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
    public String btnaceptar_action() {

        if(!StringUtil.isNullOrEmpty(clave)){
            getServicioCliente().getClienteEdicion().setClave(EncrypUtil.encriptar(clave));
        }

        // TODO: Process the button click action. Return value is a navigation
        getServicioCliente().guardar();// case name where null will return to the same page.
        return "case1";
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

    public String btncancelar_action() {
        //return null means stay on the same page
        return "case2";
    }

    public boolean isRenderConfirmClave(){
        if(StringUtil.isNullOrEmpty(clave)){
            return false;
        }

        return true;
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

