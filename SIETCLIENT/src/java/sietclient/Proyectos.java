/*
 * Proyectos.java
 *
 * Created on 16/10/2010, 09:21:17 PM
 * Copyright LENIN
 */
package sietclient;

import sietclient.bean.ItemProyecto;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.net.URL;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.model.ArrayDataModel;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Proyectos extends AbstractPageBean {

    
    private ArrayDataModel proyectos = new ArrayDataModel();
    private String urlSietIce;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Proyectos() {

        

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
            log("Proyectos Initialization Failure", e);
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
        //listar();
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String btnCerrar_action() {
        //return null means stay on the same page
        return "case-cerrar";
    }

    public void listar(){
        try { // Call Web Service Operation
            siet.web.service.SietWSService service = new siet.web.service.SietWSService();
            siet.web.service.SietWS port = service.getSietWSPort();

            URL url = service.getWSDLDocumentLocation();
            String path = url.toExternalForm().replace("SietWS?wsdl", "");
            urlSietIce = path;
            // TODO process result here
            java.lang.String result = port.obtenerProyectos();
            List<ItemProyecto> proys = XMLProyectoUtil.obtenerProyectos(result);
            proyectos = new ArrayDataModel(proys.toArray());
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            proyectos = new ArrayDataModel();
        }
    }

   

    /**
     * @return the proyectos
     */
    public ArrayDataModel getProyectos() {
        listar();
        return proyectos;
    }

    /**
     * @param proyectos the proyectos to set
     */
    public void setProyectos(ArrayDataModel proyectos) {
        this.proyectos = proyectos;
    }

    public String lnkVer_action() {
        ItemProyecto item = (ItemProyecto)proyectos.getRowData();
        item.setContextPath(urlSietIce);
        getServicioProyecto().editar(item);
        return "case-ver";
    }
}
