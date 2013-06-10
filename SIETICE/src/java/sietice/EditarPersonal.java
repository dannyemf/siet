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
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.ValidatorException;
import siet.modelo.Empleado;
import siet.servicio.ServicioCliente;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioEmpleado;
import siet.util.EncrypUtil;
import siet.util.StringUtil;



public class EditarPersonal extends AbstractPageBean {

    private String clave="";    

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

    public void editar(Empleado e){
        clave = "";        
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
    private ArrayList<SelectItem> estadocivil;
    private ArrayList<SelectItem> sexo;
     private ArrayList<SelectItem> estado;
    private ArrayList<SelectItem> rol;

    public ArrayList<SelectItem> getEstadoCivil() {
        estadocivil = new ArrayList<SelectItem>();
        estadocivil.add(new SelectItem("SOLTERO", "Soltero"));
        estadocivil.add(new SelectItem("CASADO", "Casado"));
         estadocivil.add(new SelectItem("VIUDO", "Viudo"));
        estadocivil.add(new SelectItem("DIVORCIADO", "Divorciado"));
        return estadocivil;
    }
    public void setEstadoCivil(ArrayList<SelectItem> estadoCivil) {
        this.estadocivil = estadoCivil;
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

    public ArrayList<SelectItem> getEstado() {
        estado = new ArrayList<SelectItem>();
        estado.add(new SelectItem("A","Activo"));
        estado.add(new SelectItem("P","Pasivo"));
        return estado;
    }

    public void setEstado(ArrayList<SelectItem> estado) {
        this.estado = estado;
    }

    public ArrayList<SelectItem> getRol() {
        rol = new ArrayList<SelectItem>();
        rol.add(new SelectItem("PT","PersonalTecnico"));
        rol.add(new SelectItem("admin","Administrador"));
        return rol;
    }

    public void setRol(ArrayList<SelectItem> rol) {
        this.rol = rol;
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
   
    public  ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }

     public  ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }
     
    public void txtcedula_validate(FacesContext context, UIComponent component, Object value) {
        boolean b = ServicioEmpleado.validarCedula(value.toString());
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

        Empleado e = getServicioEmpleado().getEmpleadoEdicion();

        if(!StringUtil.isNullOrEmpty(clave)){
            e.setClave(EncrypUtil.encriptar(clave));
        }

        getServicioEmpleado().guardar();
        // TODO: Replace with your code
        return "aceptar";
    }

    public String btncancelar_action() {
        //return null means stay on the same page
        return "cancelar";
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

    
    
}

