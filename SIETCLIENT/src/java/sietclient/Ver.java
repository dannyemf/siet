/*
 * Ver.java
 *
 * Created on 19/10/2010, 07:50:12 AM
 * Copyright LENIN
 */
package sietclient;

import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Ver extends AbstractPageBean {

    private String observacion;

    private String popupMensaje ="";
    private boolean popupShow = false;
    private boolean goAtras = false;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems = dsia;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Ver() {
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
            log("Ver Initialization Failure", e);
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

    public ServicioProyecto getServicioProyecto(){
        return (ServicioProyecto)getBean("ServicioProyecto");
    }

    public String btnAtras_action() {
        //return null means stay on the same page
        popupMensaje = "";
        popupShow = false;
        goAtras = false;
        return "case-atras";
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String btnAprobar_action() {
        //return null means stay on the same page

        try { // Call Web Service Operation
            siet.web.service.SietWSService service = new siet.web.service.SietWSService();
            siet.web.service.SietWS port = service.getSietWSPort();
            // TODO initialize WS operation arguments here
            java.lang.Long id = getServicioProyecto().getProyectoEdicion().getId();
            boolean b = port.aprobar(id, observacion);
            if(b){
                goAtras = true;
                popupMensaje = "El proyecto ha sido aprobado";
            }else{
                goAtras = false;
                popupMensaje = "El proyecto no ha sido aprobado";
            }
            popupShow = true;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return null;
    }

    public String btnRechazar_action() {
        //return null means stay on the same page

        try { // Call Web Service Operation
            siet.web.service.SietWSService service = new siet.web.service.SietWSService();
            siet.web.service.SietWS port = service.getSietWSPort();
            // TODO initialize WS operation arguments here
            java.lang.Long id = getServicioProyecto().getProyectoEdicion().getId();
            boolean b = port.rechazar(id, observacion);
            if(b){
                goAtras = true;
                popupMensaje = "El proyecto ha sido rechazado";
            }else{
                goAtras = false;
                popupMensaje = "El proyecto no ha sido rechazado";
            }
            popupShow = true;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        return null;
    }

    /**
     * @return the popupMensaje
     */
    public String getPopupMensaje() {
        return popupMensaje;
    }

    /**
     * @param popupMensaje the popupMensaje to set
     */
    public void setPopupMensaje(String popupMensaje) {
        this.popupMensaje = popupMensaje;
    }

    /**
     * @return the popupShow
     */
    public boolean isPopupShow() {
        return popupShow;
    }

    /**
     * @param popupShow the popupShow to set
     */
    public void setPopupShow(boolean popupShow) {
        this.popupShow = popupShow;
    }

    /**
     * @return the goAtras
     */
    public boolean isGoAtras() {
        return goAtras;
    }

    /**
     * @param goAtras the goAtras to set
     */
    public void setGoAtras(boolean goAtras) {
        this.goAtras = goAtras;
    }

    public String btnPopuAceptar_action() {
        popupShow = false;
        popupMensaje = "";
        if(goAtras){
            return "case-atras";
        }
        return null;
    }

    public void panelTabSet1_processTabChange(TabChangeEvent tce) {
    }

}

