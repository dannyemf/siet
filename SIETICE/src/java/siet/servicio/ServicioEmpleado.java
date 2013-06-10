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
import siet.dao.EmpleadoDAO;
import siet.modelo.Auditoria;
import siet.modelo.Empleado;
import siet.util.CedulaUtil;
import siet.util.EncrypUtil;
import siet.util.StringUtil;
import sietice.SietApplicationBean;

public class ServicioEmpleado extends AbstractSessionBean {

    private Empleado empleadoEdicion = null;
    private Empleado empleadoLogeado = null;
    
    private ArrayList<SelectItem> estadocivil;
    private ArrayList<SelectItem> sexo;
    private ArrayList<SelectItem> estado;
    private ArrayList<SelectItem> rol;
    private String clave = "";
    private String confirmclave = "";

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private void _init() throws Exception {
    }

    public ServicioEmpleado() {
    }

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
        sexo.add(new SelectItem("M", "Masculino"));
        sexo.add(new SelectItem("F", "Femenino"));
        return sexo;
    }

    public void setSexo(ArrayList<SelectItem> sexo) {
        this.sexo = sexo;
    }

    public ArrayList<SelectItem> getEstado() {
        estado = new ArrayList<SelectItem>();
        estado.add(new SelectItem("A", "Activo"));
        estado.add(new SelectItem("P", "Pasivo"));
        return estado;
    }

    public void setEstado(ArrayList<SelectItem> estado) {
        this.estado = estado;
    }

    public ArrayList<SelectItem> getRol() {
        rol = new ArrayList<SelectItem>();
        rol.add(new SelectItem("PT", "PersonalTécnico"));
        rol.add(new SelectItem("A", "Administrador"));
        return rol;
    }

    public void setRol(ArrayList<SelectItem> rol) {
        this.rol = rol;
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

    public void clave_validate(FacesContext context, UIComponent component, Object value) {
        if (!StringUtil.isNullOrEmpty(value) && value.toString().trim().length() < 5) {
            FacesMessage fm = new FacesMessage("Longitud mínima de 5 caracteres");
            throw new ValidatorException(fm);
        }
    }

    public void confclave_validate(FacesContext context, UIComponent component, Object value) {
        String clientId = component.getClientId(context);
        
        Object clave = ((UIInput) component.getParent().findComponent(clientId.substring(0,clientId.indexOf(":")) + ":secretclave")).getValue();

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
        if(!b){
            FacesMessage m = new FacesMessage("Cédula incorrecta");
            throw new ValidatorException(m);
        }

        Empleado e =  new EmpleadoDAO().buscarPorCedulaER(value.toString(), empleadoEdicion);
        if(e != null){
             FacesMessage m = new FacesMessage("Ya existe un empleado registrado");
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

    public void nuevo() {
        Empleado cli = new Empleado();                
        setEmpleadoEdicion(cli);

        clave = "";
        confirmclave = "";
    }

    public void editar(Empleado cli) {
        this.setEmpleadoEdicion(cli);

        clave = "";
        confirmclave = "";
    }

    public boolean guardar() {

        Empleado e = getEmpleadoEdicion();

        if (!StringUtil.isNullOrEmpty(clave)) {
            e.setClave(EncrypUtil.encriptar(clave));
        }

        if (e.getId().longValue() == -1) {
            boolean b = new EmpleadoDAO().guardar(e);
            getServicioAuditoria().auditar(new Auditoria(empleadoLogeado, Auditoria.ACCION_CREACION, e.toString(), Auditoria.ENTIDAD_EMPLEADO));
            if(b) empleadoEdicion = null;
            return b;
        } else {
            boolean b = new EmpleadoDAO().actualizar(e);
            if (b) {
                getServicioAuditoria().auditar(new Auditoria(empleadoLogeado, Auditoria.ACCION_MODIFICACION, e.toString(), Auditoria.ENTIDAD_EMPLEADO));
            }
            if(b) empleadoEdicion = null;
            return b;
        }
    }

    public List<Empleado> listarTodos() {
        return new EmpleadoDAO().buscarTodos();
    }

    public List<Empleado> listarCriterio(String ap) {
        return new EmpleadoDAO().buscarPorApellidos(ap);
    }

    public Empleado buscarPorCedula(String ci) {
        return new EmpleadoDAO().buscarPorCedula(ci);
    }

    public List buscarPorApellidos(String ap) {
        return new EmpleadoDAO().buscarPorApellidos(ap);
    }

    public boolean logear(String usuario, String clave) {
        Empleado e = new EmpleadoDAO().buscarPorCedula(usuario);
        if (e != null) {
            System.out.println(clave + "-" + e.getClave() + "-" + e.getClave().equals(clave));
            if (e.getClave().equals(clave) || StringUtil.isNullOrEmpty(e.getClave())) {
                getServicioAuditoria().auditar(new Auditoria(e, Auditoria.ACCION_LOGIN, "", Auditoria.ENTIDAD_EMPLEADO));
                setEmpleadoLogeado(e);

                return true;
            }
        }
        return false;
    }    

    public Empleado buscarPorId(Object id) {
        return new EmpleadoDAO().buscarPorId(id);
    }

    public boolean salir() {
        getServicioAuditoria().auditar(new Auditoria(empleadoLogeado, Auditoria.ACCION_LOGOFF, "", Auditoria.ENTIDAD_EMPLEADO));
        empleadoLogeado = null;
        return true;
    }

    public boolean logearAdmin(String usuario, String clave) {
        Empleado e = new EmpleadoDAO().buscarPorCedula(usuario);

        if (e != null) {
            System.out.println(clave + "-" + e.getClave() + "-" + e.getClave().equals(clave));
            if (e.getClave().equals(clave) || StringUtil.isNullOrEmpty(e.getClave())) {
                if (e.getRol().toString().equals("admin") || e.getRol().toString().equals("A")) {
                    setEmpleadoLogeado(e);
                    getServicioAuditoria().auditar(new Auditoria(e, Auditoria.ACCION_LOGIN, "", Auditoria.ENTIDAD_EMPLEADO));
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * @return the empleadoEdicion
     */
    public Empleado getEmpleadoEdicion() {
        return empleadoEdicion;
    }

    /**
     * @param empleadoEdicion the empleadoEdicion to set
     */
    public void setEmpleadoEdicion(Empleado empleadoEdicion) {
        this.empleadoEdicion = empleadoEdicion;
    }

    /**
     * @return the empleadoLogeado
     */
    public Empleado getEmpleadoLogeado() {
        return empleadoLogeado;
    }

    /**
     * @param empleadoLogeado the empleadoLogeado to set
     */
    public void setEmpleadoLogeado(Empleado empleadoLogeado) {
        this.empleadoLogeado = empleadoLogeado;
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
