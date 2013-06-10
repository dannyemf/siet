/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.ValidatorException;
import siet.dao.EmpleadoDAO;
import siet.modelo.Empleado;
import siet.servicio.ServicioEmpleado;
import siet.util.EncrypUtil;



public class RegistrarPersonal extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        lengthValidatordoapellido.setMaximum(30);
        lengthValidatordoapellido.setMinimum(3);
        lengthValidatorapellido.setMaximum(30);
        lengthValidatornombre.setMaximum(30);
        lengthValidatornombre.setMinimum(3);
        lengthValidatorcelular.setMaximum(9);
        lengthValidatorcelular.setMinimum(9);
        lengthValidatorclave.setMaximum(15);
        lengthValidatorusuario.setMaximum(15);
        lengthValidatorclave.setMinimum(5);
        lengthValidatorusuario.setMinimum(5);
    }
    private DefaultSelectItemsArray dropdown1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems1() {
        return dropdown1DefaultItems1;
    }

    public void setDropdown1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray drpdownrolDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDrpdownrolDefaultItems() {
        return drpdownrolDefaultItems;
    }

    public void setDrpdownrolDefaultItems(DefaultSelectItemsArray dsia) {
        this.drpdownrolDefaultItems = dsia;
    }
    private DefaultSelectItemsArray dropdown1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems2() {
        return dropdown1DefaultItems2;
    }

    public void setDropdown1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray dropdown1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems3() {
        return dropdown1DefaultItems3;
    }

    public void setDropdown1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems3 = dsia;
    }
    private LengthValidator lengthValidatordoapellido = new LengthValidator();

    public LengthValidator getLengthValidatordoapellido() {
        return lengthValidatordoapellido;
    }

    public void setLengthValidatordoapellido(LengthValidator lv) {
        this.lengthValidatordoapellido = lv;
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
    private LengthValidator lengthValidatorcelular = new LengthValidator();

    public LengthValidator getLengthValidatorcelular() {
        return lengthValidatorcelular;
    }

    public void setLengthValidatorcelular(LengthValidator lv) {
        this.lengthValidatorcelular = lv;
    }
    private LengthValidator lengthValidatorclave = new LengthValidator();

    public LengthValidator getLengthValidatorclave() {
        return lengthValidatorclave;
    }

    public void setLengthValidatorclave(LengthValidator lv) {
        this.lengthValidatorclave = lv;
    }
    private LengthValidator lengthValidatorusuario = new LengthValidator();

    public LengthValidator getLengthValidatorusuario() {
        return lengthValidatorusuario;
    }

    public void setLengthValidatorusuario(LengthValidator lv) {
        this.lengthValidatorusuario = lv;
    }

    // </editor-fold>

   
    public RegistrarPersonal() {
    }

   
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
            log("EditarPersonal Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }
    private ArrayList<SelectItem> estadocivil;
    private ArrayList<SelectItem> sexo;
     private ArrayList<SelectItem> estado;
    private ArrayList<SelectItem> rol;
     private String mensajecedula="";

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
        rol.add(new SelectItem("A","Administrador"));
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

   


     public ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }

   

     public void txtcedula_validate(FacesContext context, UIComponent component, Object value) {
        boolean b = getServicioEmpleado().validarCedula(value.toString());
        if(!b){
            FacesMessage m = new FacesMessage("Cedula incorrecta");
            throw new ValidatorException(m);
        }
         Empleado e =  new EmpleadoDAO().buscarPorCedulaER(value.toString());
        if(e != null)
        {
             FacesMessage m = new FacesMessage(" Error Empleado Registrado ");
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
        e.setClave(EncrypUtil.encriptar(e.getClave()));

        if(getServicioEmpleado().guardar())
            {
            return "caceptarp";
            }
            else {
            return  null;
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

    public String btncancelar_action() {
        //return null means stay on the same page
        return "ccancelp";
    }
    
}

