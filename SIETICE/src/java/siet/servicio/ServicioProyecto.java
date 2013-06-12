/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.List;
import javax.faces.FacesException;
import siet.dao.ProyectoDAO;
import siet.dao.TipoViviendaDAO;
import siet.modelo.Auditoria;
import siet.modelo.Cliente;
import siet.modelo.Empleado;
import siet.modelo.Proyecto;
import siet.modelo.ProyectoCliente;
import siet.modelo.TipoVivienda;
import sietice.EditarProyecto;
import sietice.EditarProyectoCliente;
import sietice.EditarProyectoEmpleado;
import sietice.SietApplicationBean;


public class ServicioProyecto extends AbstractSessionBean {

    private ProyectoCliente proyectoClienteEdicion = null;
    private Proyecto proyectoEdicion = null;

   // private Proyecto proyectologeado = null;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">


    private void _init() throws Exception {
    }

    public ServicioProyecto() {
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

    public ServicioCliente getServicioCliente(){

        return (ServicioCliente)getBean("ServicioCliente");
    }


    public void nuevoProyectoCliente(){
        Cliente cli = getServicioCliente().getClienteLogeado();
        ProyectoCliente pro = new ProyectoDAO().buscarPorCliente(cli);
        if(pro == null){
            pro = new ProyectoCliente();
            pro.setPropietario(cli);
            Proyecto pr = (Proyecto)(new TipoViviendaDAO().buscarPrimero(Proyecto.class));
            TipoVivienda tv = (TipoVivienda)(new TipoViviendaDAO().buscarPrimero(TipoVivienda.class));

            pro.setProyecto(pr);
            pro.setTipoVivienda(tv);
        }
        //pro.setPropietario(getServicioCliente().getClienteLogeado());
        setProyectoClienteEdicion(pro);

        sietice.TipoVivienda ed = (sietice.TipoVivienda)getBean("TipoVivienda");
        ed.editar(pro);
    }

    public void nuevoProyecto(){
        Proyecto pro = new Proyecto();
        editarProyecto(pro);
    }

    // editar proyecto de
    public void editarProyectoCliente(ProyectoCliente pro){
        this.setProyectoClienteEdicion(pro);

        EditarProyectoCliente ed = (EditarProyectoCliente)getBean("EditarProyectoCliente");
        ed.editar(pro);

    }

    // editar proyecto de
    public void editarProyecto(Proyecto pro){
        this.proyectoEdicion = pro;
        ((EditarProyecto)getBean("EditarProyecto")).editar(pro);
    }

    public void editarProyectoEmpleado(ProyectoCliente pro){
        this.setProyectoClienteEdicion(pro);
        EditarProyectoEmpleado ed = (EditarProyectoEmpleado)getBean("EditarProyectoEmpleado");
        ed.editar(pro);
    }

    public boolean eliminarProyectoCliente(ProyectoCliente pro){
        return new ProyectoDAO().eliminar(pro);
    }

    public boolean eliminarProyecto(Proyecto pro){
        return new ProyectoDAO().eliminar(pro);
    }

    public boolean guardarProyectoCliente(){
        boolean b = false;
        if(getProyectoClienteEdicion().getId().longValue() == -1){
            b = new ProyectoDAO().guardar(proyectoClienteEdicion);
            if(b){
                getServicioAuditoria().auditar(new Auditoria(getServicioCliente().getClienteLogeado(),Auditoria.ACCION_CREACION, proyectoClienteEdicion.toString(), Auditoria.ENTIDAD_PROYECTO));
            }
        }else{
            b = new ProyectoDAO().actualizar(proyectoClienteEdicion);
            Cliente cli = getServicioCliente().getClienteLogeado();
            Empleado emp = getServicioEmpleado().getEmpleadoLogeado();
            if(b){
                if(cli != null){
                    getServicioAuditoria().auditar(new Auditoria(cli,Auditoria.ACCION_MODIFICACION, proyectoClienteEdicion.toString(), Auditoria.ENTIDAD_PROYECTO));
                }else{
                    getServicioAuditoria().auditar(new Auditoria(emp,Auditoria.ACCION_MODIFICACION, proyectoClienteEdicion.toString(), Auditoria.ENTIDAD_PROYECTO));
                }
            }
        }
        return b;
    }

    public boolean guardarProyecto(){
        boolean b = false;
        if(proyectoEdicion.getId().longValue() == -1){
            b = new ProyectoDAO().guardar(proyectoEdicion);
        }else{
            b = new ProyectoDAO().actualizar(proyectoEdicion);
        }
        return b;
    }

    public List<Proyecto> listarProyectos(){
        return new ProyectoDAO().buscarTodos(Proyecto.class);
    }

    public List<ProyectoCliente> listarProyectosClientes(){
        return new ProyectoDAO().buscarTodos(ProyectoCliente.class);
    }

    public List<ProyectoCliente> listarProyectosClientesPor(Proyecto p){
        return new ProyectoDAO().buscarProyectosClientesPor(p);
    }

    
    public ProyectoCliente buscarProyectoClientePor(Cliente c){
        return new ProyectoDAO().buscarPorCliente(c);
    }
    



   

    /**
     * @return the proyectoEdicion
     */
    public ProyectoCliente getProyectoClienteEdicion() {
        return proyectoClienteEdicion;
    }

    /**
     * @param proyectoEdicion the proyectoEdicion to set
     */
    public void setProyectoClienteEdicion(ProyectoCliente proyectoEdicion) {
        this.proyectoClienteEdicion = proyectoEdicion;
        EditarProyectoCliente ed = (EditarProyectoCliente)getBean("EditarProyectoCliente");
        ed.setTipo(proyectoEdicion.getTipoVivienda() != null ? proyectoEdicion.getTipoVivienda().getId() : null);
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
     * @return the proyectoEdicion
     */
    public Proyecto getProyectoEdicion() {
        return proyectoEdicion;
    }

    /**
     * @param proyectoEdicion the proyectoEdicion to set
     */
    public void setProyectoEdicion(Proyecto proyectoEdicion) {
        this.proyectoEdicion = proyectoEdicion;
    }

    /**
     * @param proyectoEdicion the proyectoEdicion to set
     */
    public Proyecto buscarPorId(Object id) {
        return (Proyecto)new ProyectoDAO().buscarPorId(Proyecto.class, id);
    }

}
