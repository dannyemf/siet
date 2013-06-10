/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.List;
import javax.faces.FacesException;
import siet.dao.EmpleadoDAO;
import siet.modelo.Auditoria;
import siet.modelo.Empleado;
import siet.util.EncrypUtil;
import siet.util.StringUtil;
import sietice.EditarPersonal;
import sietice.SietApplicationBean;


public class ServicioEmpleado extends AbstractSessionBean {

    private Empleado empleadoEdicion = null;
    private Empleado empleadoLogeado = null;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">


    private void _init() throws Exception {
    }

    public ServicioEmpleado() {
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

    public void nuevo(){
        Empleado cli = new Empleado();
        setEmpleadoEdicion(cli);
        EditarPersonal e = (EditarPersonal)getBean("EditarPersonal");
        e.editar(cli);
    }
    public void editar(Empleado cli){
        this.setEmpleadoEdicion(cli);
        EditarPersonal e = (EditarPersonal)getBean("EditarPersonal");
        e.editar(cli);
    }
    public boolean guardar(){
        if(getEmpleadoEdicion().getId().longValue() == -1){
            boolean b = new EmpleadoDAO().guardar(getEmpleadoEdicion());
            getServicioAuditoria().auditar(new Auditoria(empleadoLogeado, Auditoria.ACCION_CREACION, empleadoEdicion.toString(), Auditoria.ENTIDAD_EMPLEADO));
            return b;
        }else{
            boolean b = new EmpleadoDAO().actualizar(getEmpleadoEdicion());
            if(b){
                getServicioAuditoria().auditar(new Auditoria(empleadoLogeado, Auditoria.ACCION_MODIFICACION, empleadoEdicion.toString(), Auditoria.ENTIDAD_EMPLEADO));
            }
            return b;
        }
    }

    public List<Empleado> listarTodos(){
        return new EmpleadoDAO().buscarTodos();
    }
     public List<Empleado> listarCriterio(String ap){
            return  new EmpleadoDAO().buscarPorApellidos(ap);
    }

    public Empleado buscarPorCedula(String ci){
        return new EmpleadoDAO().buscarPorCedula(ci);
    }

    public List buscarPorApellidos(String ap){
        return new EmpleadoDAO().buscarPorApellidos(ap);
    }    

   public boolean logear(String usuario, String clave) {
        Empleado e = new EmpleadoDAO().buscarPorCedula(usuario);
        if(e != null){
            System.out.println(clave+"-"+e.getClave()+"-"+e.getClave().equals(clave));
            if(e.getClave().equals(clave)){
                getServicioAuditoria().auditar(new Auditoria(e, Auditoria.ACCION_LOGIN, "", Auditoria.ENTIDAD_EMPLEADO));
                setEmpleadoLogeado(e);
                
            return true;
            }
        }
        return false;
    }
 public static boolean validarCedula(String cedula){
        int sumaA = 0;
        int sumaB = 0;
        if (cedula.length() != 10){
            return false;
        }
        try {
            new Long(cedula);
        } catch (Exception e) {
            return false;
        }
        for(int i=0; i<9; i++){
            if (i == 1 || i == 3 || i == 5 || i == 7){
                sumaA = sumaA + (new Integer(cedula.substring(i,i+1)));
            }else{
                int valmul = (new Integer(cedula.substring(i, i+1))) * 2;
                if(valmul>9){
                    valmul=valmul-9;
                }
                sumaB=sumaB+valmul;
            }
        }
        //paso 3
        int total = sumaA + sumaB;
        int residuo = total / 10;
        int Vericador = total-(residuo * 10);
        Vericador = 10-Vericador;
        if (Vericador == new Integer(cedula.substring(9, 10))){
            System.out.println(cedula+" ok");
            return true;
        }
         System.out.println(cedula+" invalida");
        return false;

    }

     public Empleado buscarPorId(Object id){
        return new EmpleadoDAO().buscarPorId(id);
    }
 public boolean salir(){
         getServicioAuditoria().auditar(new Auditoria(empleadoLogeado, Auditoria.ACCION_LOGOFF, "", Auditoria.ENTIDAD_EMPLEADO));
         empleadoLogeado = null;
         return true;
    }

   public boolean logearAdmin(String usuario, String clave){
        Empleado e = new EmpleadoDAO().buscarPorCedula(usuario);
        
        if(e != null)
        {
            System.out.println(clave+"-"+e.getClave()+"-"+e.getClave().equals(clave));
            if(e.getClave().equals(clave) || StringUtil.isNullOrEmpty(e.getClave()))
            {
                if(e.getRol().toString().equals("admin")||e.getRol().toString().equals("A"))
                {
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

    public ServicioAuditoria getServicioAuditoria(){
        return (ServicioAuditoria)getBean("ServicioAuditoria");
    }

}
