/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.List;
import javax.faces.model.ArrayDataModel;
import javax.faces.FacesException;
import siet.modelo.Cliente;
import siet.servicio.ServicioCliente;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version AdminstrarCliente.java
 * @version Created on 04/06/2010, 04:36:22 PM
 * @author Administrator
 */

public class AdminstrarClienteEmpleado extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AdminstrarClienteEmpleado() {
    }
    private String apellido = "";
   private ArrayDataModel listaCriterio = new ArrayDataModel();
     private ArrayDataModel modelClientes = new ArrayDataModel();

    public ArrayDataModel getModelClientes() {
        modelClientes = new ArrayDataModel(getServicioCliente().listarCriterio(apellido).toArray());
        return modelClientes;
    }

    public void setModelClientes(ArrayDataModel modelClientes) {
        this.modelClientes = modelClientes;
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
            log("AdminstrarCliente Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

   

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */

    public ServicioCliente getServicioCliente() {
    return (ServicioCliente) getBean("ServicioCliente");
    }

   

    public String btnvolver_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return "case1";
    }

    public String linkActionEditar_action() {

        Cliente c = (Cliente)modelClientes.getRowData();
        getServicioCliente().editar(c);

        return "case2";
    }

    public String linkActionEliminar_action() {
       Cliente c = (Cliente)modelClientes.getRowData();
       boolean b =getServicioCliente().eliminar(c);
        return "case3";
    }

    public String btn_Buscar_action() {
        List<Cliente> lista = getServicioCliente().listarCriterio(apellido);
        modelClientes = new ArrayDataModel(lista.toArray());

        //return null means stay on the same page
        return null;
    }

    /**
     * @return the listaCriterio
     */
    public ArrayDataModel getListaCriterio() {
         listaCriterio = new ArrayDataModel(getServicioCliente().listarCriterio(apellido).toArray());
        return listaCriterio;
    }

    /**
     * @param listaCriterio the listaCriterio to set
     */
    public void setListaCriterio(ArrayDataModel listaCriterio) {
        this.listaCriterio = listaCriterio;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the modelClientes
     */

}

