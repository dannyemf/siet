package sietice;

import com.icesoft.faces.webapp.http.servlet.InterceptingServletSession;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.CharacterConverter;
import javax.faces.validator.LengthValidator;
import siet.servicio.ServicioCliente;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import siet.modelo.Cliente;
import siet.dao.ClienteDAO;
import sietice.reportes.RecursoFile;
import siet.util.EncrypUtil;


public class Registrarcliente extends AbstractPageBean {
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
    private DefaultSelectItemsArray dropdown1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems1() {
        return dropdown1DefaultItems1;
    }

    public void setDropdown1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray dropsexoDefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropsexoDefaultItems() {
        return dropsexoDefaultItems;
    }

    public void setDropsexoDefaultItems(DefaultSelectItemsArray dsia) {
        this.dropsexoDefaultItems = dsia;
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
    private CharacterConverter characterConverter1 = new CharacterConverter();

    public CharacterConverter getCharacterConverter1() {
        return characterConverter1;
    }

    public void setCharacterConverter1(CharacterConverter cc) {
        this.characterConverter1 = cc;
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
    public  LengthValidator lengthValidatorconfclave = new LengthValidator();

    public LengthValidator getLengthValidatorconfclave() {
        return lengthValidatorconfclave;
    }

    public void setLengthValidatorconfclave(LengthValidator lv) {
        this.lengthValidatorconfclave = lv;
    }
    private DefaultSelectItemsArray dropdown3DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown3DefaultItems() {
        return dropdown3DefaultItems;
    }

    public void setDropdown3DefaultItems(DefaultSelectItemsArray dsia) {
        this.dropdown3DefaultItems = dsia;
    }
    private DefaultSelectItemsArray dropdown1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems4() {
        return dropdown1DefaultItems4;
    }

    public void setDropdown1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray dropdown1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems5() {
        return dropdown1DefaultItems5;
    }

    public void setDropdown1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray dropdown1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems6() {
        return dropdown1DefaultItems6;
    }

    public void setDropdown1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems6 = dsia;
    }
    private DefaultSelectItemsArray dropdown2DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown2DefaultItems1() {
        return dropdown2DefaultItems1;
    }

    public void setDropdown2DefaultItems1(DefaultSelectItemsArray dsia) {
        this.dropdown2DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray dropdown2DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown2DefaultItems2() {
        return dropdown2DefaultItems2;
    }

    public void setDropdown2DefaultItems2(DefaultSelectItemsArray dsia) {
        this.dropdown2DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray dropdown2DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown2DefaultItems3() {
        return dropdown2DefaultItems3;
    }

    public void setDropdown2DefaultItems3(DefaultSelectItemsArray dsia) {
        this.dropdown2DefaultItems3 = dsia;
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
    private String clave="";
    private String confirmclave ="";
    
    private String mensajecedula="";
 private RecursoFile recursoAyuda;
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

    
    
    public ServicioCliente getServicioCliente() {
        return (ServicioCliente) getBean("ServicioCliente");
    }
    	    

    public String btnaceptar_action() {
           //setClave(ServicioCliente.getStringMessageDigest(clave));
           //0 getServicioCliente().getClienteEdicion().setClave(ServicioCliente.getStringMessageDigest(clave));
          mensajecedula = "";
          Cliente c = getServicioCliente().getClienteEdicion();

          if(clave.equals(confirmclave)){
                c.setClave(EncrypUtil.encriptar(clave) );
                System.out.println("clave antes de guardar"+getClave()+" "+clave);
                
                if(getServicioCliente().guardar()){
                    return "case-aceptarcliente";
                }
          }else{
              FacesContext.getCurrentInstance().addMessage("formRegistrar:secretconfclave", new FacesMessage("La confirmación de la clave no es correcta"));
          }




          return null;

    }
   
    public String hyperlink1_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
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

    
  public void txtcedula_validate(FacesContext context, UIComponent component, Object value) {
        boolean b = ServicioCliente.validarCedula(value.toString());
            if(!b){
                FacesMessage m = new FacesMessage("Cedula incorrecta");
                throw new ValidatorException(m);
            }

            Cliente cli =  new ClienteDAO().buscarPorCedula(value.toString());
            if(cli != null)
            {
                 FacesMessage m = new FacesMessage(" Error Usuario Registrado ");
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
 public RecursoFile getRecursoAyuda() {
        InterceptingServletSession e = (InterceptingServletSession)getExternalContext().getSession(true);
        String c = e.getServletContext().getRealPath("/")+"recursos"+File.separator+"Ayuda_Cliente.pdf";
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

    public String txtcelular_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtdireccion_action() {

          
        return null;
    }

    
}

