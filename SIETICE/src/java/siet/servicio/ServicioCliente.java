/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package siet.servicio;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import siet.dao.ClienteDAO;
import siet.modelo.Auditoria;
import siet.modelo.Cliente;
import siet.util.CedulaUtil;
import siet.util.EncrypUtil;
import siet.util.StringUtil;
import sietice.SietApplicationBean;
import sietice.EditarCliente;

public class ServicioCliente extends AbstractSessionBean {

    private Cliente clienteEdicion = null;
    private Cliente clienteLogeado = null;    

    private ArrayList<SelectItem> estadoCivil;
    private ArrayList<SelectItem> sexo;

    private String clave = "";
    private String confirmclave = "";

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private void _init() throws Exception {
    }

    public ServicioCliente() {
    }

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

    @Override
    public void passivate() {
    }

    @Override
    public void activate() {
    }

    @Override
    public void destroy() {
    }

    public void nuevo() {
        Cliente cli = new Cliente();
        clienteEdicion = cli;

        clave ="";
        confirmclave = "";
    }

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
        sexo.add(new SelectItem("M", "Masculino"));
        sexo.add(new SelectItem("F", "Femenino"));
        return sexo;
    }

    public void editar(Cliente cli) {
        this.clienteEdicion = cli;

        clave ="";
        confirmclave = "";
    }

    public boolean eliminar(Cliente cli) {
        boolean b = new ClienteDAO().eliminar(cli);
        //  if(b){
        //    getServicioAuditoria().auditar(new Auditoria(getServicioEmpleado().getEmpleadoLogeado(), Auditoria.ACCION_ELIMINACION, cli.toString(), Auditoria.ENTIDAD_CLIENTE));
        // }
        return b;
    }

    public boolean guardar() {
        
        if(!StringUtil.isNullOrEmpty(clave)){
            clienteEdicion.setClave(EncrypUtil.encriptar(clave));
        }

        if (clienteEdicion.getId().longValue() == -1) {
            return new ClienteDAO().guardar(clienteEdicion);
        } else {
            return new ClienteDAO().actualizar(clienteEdicion);
        }
    }

    public List<Cliente> listarTodos() {
        return new ClienteDAO().buscarTodos();
    }

    public List<Cliente> listarCriterio(String ap) {
        return new ClienteDAO().buscarPorApellidos(ap);
    }

    public void clave_validate(FacesContext context, UIComponent component, Object value) {
        if (!StringUtil.isNullOrEmpty(value) && value.toString().trim().length() < 5) {
            FacesMessage fm = new FacesMessage("Longitud mínima de 5 caracteres");
            throw new ValidatorException(fm);
        }
    }

    public void confclave_validate(FacesContext context, UIComponent component, Object value) {
        String clientId = component.getClientId(context);

        Object clave = ((UIInput) component.getParent().findComponent(clientId.substring(0, clientId.indexOf(":")) + ":secretclave")).getValue();

        if (StringUtil.isNullOrEmpty(value) && !StringUtil.isNullOrEmpty(clave)) {
            FacesMessage fm = new FacesMessage("Por favor confirme la clave");
            throw new ValidatorException(fm);
        }

        if (!StringUtil.isNullOrEmpty(value) && value.toString().trim().length() < 5) {
            FacesMessage fm = new FacesMessage("Longitud mínima de 5 caracteres");
            throw new ValidatorException(fm);
        }

        if (!StringUtil.isNullOrEmpty(value) && value.equals(clave) == false) {
            FacesMessage fm = new FacesMessage("Por favor confirme la clave con el mismo valor");
            throw new ValidatorException(fm);
        }
    }

    public void txtcedula_validate(FacesContext context, UIComponent component, Object value) {

        boolean b = CedulaUtil.validar(value.toString());
        if (!b) {
            FacesMessage m = new FacesMessage("Cédula incorrecta");
            throw new ValidatorException(m);
        }

        Cliente e = new ClienteDAO().buscarPorCedulaCR(value.toString(), clienteEdicion);
        if (e != null) {
            FacesMessage m = new FacesMessage("Ya existe un usuario registrado");
            throw new ValidatorException(m);
        }
    }

    public void txtcelular_validate(FacesContext context, UIComponent component, Object value) {
        // boolean b = ServicioCliente.validarCedula(value.toString());
        if (value.toString().length() < 9) {
            FacesMessage m = new FacesMessage("Número de Celular incompleto");
            throw new ValidatorException(m);
        }
    }

    public boolean isRequiredConfirmClave(){
        if(StringUtil.isNullOrEmpty(clave)){
            return false;
        }
        return true;
    }

    public boolean logear(String cedula, String clave) {
        System.out.println("logear () " + clave);

        Cliente e = new ClienteDAO().buscarPorCedula(cedula);

        if (e != null) {
            if (e.getClave().equals(clave)) {
                System.out.println(e.getClave());
                System.out.println(clave);
                clienteLogeado = e;
                getServicioAuditoria().auditar(new Auditoria(e, Auditoria.ACCION_LOGIN, "", Auditoria.ENTIDAD_CLIENTE));
                return true;
            }
        }
        return false;
    }

    public boolean salir() {
        getServicioAuditoria().auditar(new Auditoria(clienteLogeado, Auditoria.ACCION_LOGOFF, "", Auditoria.ENTIDAD_CLIENTE));
        clienteLogeado = null;
        return true;
    }

    public Cliente buscarPorCedula(String ci) {
        return new ClienteDAO().buscarPorCedula(ci);
    }

    public Cliente getClienteEdicion() {
        return clienteEdicion;
    }

    public Cliente getClienteLogeado() {
        return clienteLogeado;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SietApplicationBean getSietApplicationBean() {
        return (SietApplicationBean) getBean("SietApplicationBean");
    }

    public ServicioAuditoria getServicioAuditoria() {
        return (ServicioAuditoria) getBean("ServicioAuditoria");
    }

    public ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
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
