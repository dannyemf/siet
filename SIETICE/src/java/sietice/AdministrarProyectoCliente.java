/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.SelectItem;
import siet.modelo.Proyecto;
import siet.modelo.ProyectoCliente;
import siet.servicio.ServicioProyecto;
//import siet.servicio.ServicioEmpleado;
//import siet.servicio.ServicioCliente;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Proyecto.java
 * @version Created on 15/06/2010, 03:39:43 PM
 * @author Desarrollador
 */

public class AdministrarProyectoCliente extends AbstractPageBean {

    private List itemsProyectos = new ArrayList();
    private Object idProyecto;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }


    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AdministrarProyectoCliente() {
    }
     private ArrayDataModel modelProyecto = new ArrayDataModel();
     //private List<SelectItem> tiposProyecto = new

    public ArrayDataModel getModelProyecto(){
        return modelProyecto;
    }

    public void setModelProyecto(ArrayDataModel modelProyecto) {
        this.modelProyecto = modelProyecto;
    }
    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("Proyecto Initialization Failure", e);
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

    
   

   protected ServicioProyecto getServicioProyecto() {
    return (ServicioProyecto) getBean("ServicioProyecto");
    }

  

    public String btnvolver_action() {
        // TODO: Process the button click action. Return value is a navigation
        // case name where null will return to the same page.
        return "case1";
    }

    public String linkActionEditar_action() {
        ProyectoCliente p = (ProyectoCliente)modelProyecto.getRowData();
        getServicioProyecto().editarProyectoCliente(p);
        

        // TODO: Replace with your code
        return "case2";
    }

    public String linkActionEliminar_action() {
        ProyectoCliente p = (ProyectoCliente)modelProyecto.getRowData();
       boolean b = getServicioProyecto().eliminarProyectoCliente(p);
        // TODO: Replace with your code
        return null;
    }

    public void cmbProyectos_processValueChange(ValueChangeEvent vce) {
        Proyecto p = getServicioProyecto().buscarPorId(vce.getNewValue());
        if(p == null){
            modelProyecto = new ArrayDataModel();
        }else{
            List lst = getServicioProyecto().listarProyectosClientesPor(p);
            modelProyecto = new ArrayDataModel(lst.toArray());
        }
    }

    /**
     * @return the itemsProyectos
     */
    public List getItemsProyectos() {
        itemsProyectos = new ArrayList<SelectItem>();
        List<Proyecto> lst = getServicioProyecto().listarProyectos();
        itemsProyectos.add(new SelectItem(null, "--Seleccione--"));
        for (Iterator<Proyecto> it = lst.iterator(); it.hasNext();) {
            Proyecto p = it.next();
            itemsProyectos.add(new SelectItem(p.getId(), p.getNombre()));
        }

        return itemsProyectos;
    }

    /**
     * @param itemsProyectos the itemsProyectos to set
     */
    public void setItemsProyectos(List itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    /**
     * @return the idProyecto
     */
    public Object getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(Object idProyecto) {
        this.idProyecto = idProyecto;
    }

    
}

