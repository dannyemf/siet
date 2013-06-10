/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.List;
import javax.faces.FacesException;
import siet.dao.ClienteDAO;
import siet.modelo.Auditoria;
import siet.modelo.Cliente;
import sietice.SietApplicationBean;
import sietice.EditarCliente;




public class ServicioCliente extends AbstractSessionBean {

    private Cliente clienteEdicion = null;
    private Cliente clienteLogeado = null;
    private String confirmarClave;

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

    public void nuevo(){
        Cliente cli = new Cliente();
        clienteEdicion = cli;
        confirmarClave = "";                
    }
    public boolean verificacontraseña(){
    return true;

    }
    public void editar(Cliente cli){
        this.clienteEdicion = cli;
        confirmarClave = cli.getClave();

        EditarCliente b = (EditarCliente)getBean("EditarCliente");
        b.setClave("");
        b.setConfirmclave("");
    }

    public boolean  eliminar(Cliente cli){
        boolean b = new ClienteDAO().eliminar(cli);
      //  if(b){
        //    getServicioAuditoria().auditar(new Auditoria(getServicioEmpleado().getEmpleadoLogeado(), Auditoria.ACCION_ELIMINACION, cli.toString(), Auditoria.ENTIDAD_CLIENTE));
       // }
        return b;
    }

    public boolean guardar(){
        if(clienteEdicion.getId().longValue() == -1){
            return new ClienteDAO().guardar(clienteEdicion);
        }else{
            return new ClienteDAO().actualizar(clienteEdicion);
        }
    }

    public List<Cliente> listarTodos(){
        return new ClienteDAO().buscarTodos();
    }

    public List<Cliente> listarCriterio(String ap){
            return  new ClienteDAO().buscarPorApellidos(ap);
    }

   

   public boolean logear(String cedula, String clave){
       System.out.println("logear () "+clave);

        Cliente e = new ClienteDAO().buscarPorCedula(cedula);

        if(e != null ){
                if (e.getClave().equals(clave)){
                    System.out.println(e.getClave());
                    System.out.println(clave);
                     clienteLogeado = e;
                     getServicioAuditoria().auditar(new Auditoria(e, Auditoria.ACCION_LOGIN, "", Auditoria.ENTIDAD_CLIENTE));
                     return true;
                }
        }
        return false;
    }
     public boolean salir(){
         getServicioAuditoria().auditar(new Auditoria(clienteLogeado, Auditoria.ACCION_LOGOFF, "", Auditoria.ENTIDAD_CLIENTE));
         clienteLogeado = null;
         return true;
    }
    public Cliente buscarPorCedula(String ci){
        return new ClienteDAO().buscarPorCedula(ci);
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

    public ServicioAuditoria getServicioAuditoria(){
        return (ServicioAuditoria)getBean("ServicioAuditoria");
    }

    public ServicioEmpleado getServicioEmpleado(){
        return (ServicioEmpleado)getBean("ServicioEmpleado");
    }

    /**
     * @return the confirmarClave
     */
    public String getConfirmarClave() {
        return confirmarClave;
    }

    /**
     * @param confirmarClave the confirmarClave to set
     */
    public void setConfirmarClave(String confirmarClave) {
        this.confirmarClave = confirmarClave;
    }

    
}
