/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;

import sietice.*;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.FacesException;
import siet.dao.AuditoriaDAO;
import siet.dao.ClienteDAO;
import siet.dao.EmpleadoDAO;
import siet.modelo.Auditoria;
import siet.modelo.Cliente;
import siet.modelo.Empleado;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version ServicioAuditoria.java
 * @version Created on 11/12/2010, 09:38:46 PM
 * @author LENIN
 */

public class ServicioAuditoria extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public ServicioAuditoria() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("ServicioAuditoria Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SietApplicationBean getSietApplicationBean() {
        return (SietApplicationBean) getBean("SietApplicationBean");
    }

    public boolean auditar(Auditoria audit){
        return new AuditoriaDAO().guardar(audit);
    }

    public List<Auditoria> buscarPor(Date fechaInicial, Date fechaFinal, String ciCliente, String ciEmpleado, String accion, String entidad) {
        Cliente cliente = new ClienteDAO().buscarPorCedula(ciCliente);
        Empleado empleado = new EmpleadoDAO().buscarPorCedulaEmpleado(ciEmpleado);

        Calendar c = Calendar.getInstance();
        c.setTime(fechaFinal);
        c.add(Calendar.DATE, 1);
        fechaFinal = c.getTime();
        
        if(accion.equals("")){
            accion = null;
        }
        if(entidad.equals("")){
            entidad = null;
        }
        
        return new AuditoriaDAO().buscarPor(fechaInicial, fechaFinal, accion, entidad, cliente, empleado);
    }

    public boolean limpiarTodo(){
        return new AuditoriaDAO().limpiarTodo();
    }
}
