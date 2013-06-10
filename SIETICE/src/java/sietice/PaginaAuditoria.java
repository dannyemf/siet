/*
 * PaginaAuditoria.java
 *
 * Created on 11/12/2010, 11:01:29 PM
 * Copyright LENIN
 */
package sietice;

import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.webapp.parser.ELSetPropertiesRule;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.SelectItem;
import siet.modelo.Auditoria;
import siet.servicio.ServicioAuditoria;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PaginaAuditoria extends AbstractPageBean {

    private Date fechaInicial = new Date();
    private Date fechaFinal = new Date();
    private String accion = null;
    private String entidad = "Cliente";
    private String ciCliente = "";

    private ArrayDataModel listaAuditoria = new ArrayDataModel();
    private ArrayList<SelectItem> listaAcciones;
    private ArrayList<SelectItem> listaEntidades;
    private  Boolean disableClient= false;
    private  Boolean disableEmpleado= true;
    private TimeZone timeZone = TimeZone.getDefault();



    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        dateTimeConverter1.setDateStyle("short");
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
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
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PaginaAuditoria() {
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
            log("PaginaAuditoria Initialization Failure", e);
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
    protected SietApplicationBean getSietApplicationBean() {
        return (SietApplicationBean) getBean("SietApplicationBean");
    }

    public ServicioAuditoria getServicioAuditoria(){
        return (ServicioAuditoria)getBean("ServicioAuditoria");
    }

    
    /**
     * @return the fechaInicial
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the entidad
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param entidad the entidad to set
     */
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    /**
     * @return the ciCliente
     */
    public String getCiCliente() {
        return ciCliente;
    }

    /**
     * @param ciCliente the ciCliente to set
     */
    public void setCiCliente(String ciCliente) {
        this.ciCliente = ciCliente;
    }

   

    /**
     * @return the __placeholder
     */
    public int get_placeholder() {
        return __placeholder;
    }

    /**
     * @param _placeholder the __placeholder to set
     */
    public void set_placeholder(int _placeholder) {
        this.__placeholder = _placeholder;
    }

    /**
     * @return the listaAuditoria
     */
    public ArrayDataModel getListaAuditoria() {
        return listaAuditoria;
    }

    /**
     * @param listaAuditoria the listaAuditoria to set
     */
    public void setListaAuditoria(ArrayDataModel listaAuditoria) {
        this.listaAuditoria = listaAuditoria;
    }

    /**
     * @return the listaAcciones
     */
    public ArrayList<SelectItem> getListaAcciones() {
        if(listaAcciones == null){
            listaAcciones = new ArrayList<SelectItem>();
            listaAcciones.add(new SelectItem(null, "Todos"));
            listaAcciones.add(new SelectItem(Auditoria.ACCION_LOGIN, "Inicio Sesion"));
            listaAcciones.add(new SelectItem(Auditoria.ACCION_LOGOFF, "Cierre Sesion"));
            listaAcciones.add(new SelectItem(Auditoria.ACCION_CREACION, "Creacion"));
            listaAcciones.add(new SelectItem(Auditoria.ACCION_MODIFICACION, "Modificacion"));
            listaAcciones.add(new SelectItem(Auditoria.ACCION_ELIMINACION, "Eliminacion"));
        }
        return listaAcciones;
    }

    /**
     * @param listaAcciones the listaAcciones to set
     */
    public void setListaAcciones(ArrayList<SelectItem> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }

    /**
     * @return the listaEntidades
     */
    public ArrayList<SelectItem> getListaEntidades() {
        if(listaEntidades == null){
            listaEntidades = new ArrayList<SelectItem>();
            //listaEntidades.add(new SelectItem(null, "Todos"));
            listaEntidades.add(new SelectItem(Auditoria.ENTIDAD_CLIENTE, "Cliente"));
            listaEntidades.add(new SelectItem(Auditoria.ENTIDAD_EMPLEADO, "Empleado"));
            //listaEntidades.add(new SelectItem(Auditoria.ENTIDAD_DOCUMENTACION, "Documentacion"));
            //listaEntidades.add(new SelectItem(Auditoria.ENTIDAD_PROYECTO, "Proyecto"));
            //listaEntidades.add(new SelectItem(Auditoria.ENTIDAD_TIPO_VIVIENDA, "TipoVivienda"));
        }
        return listaEntidades;
    }

    /**
     * @param listaEntidades the listaEntidades to set
     */
    public void setListaEntidades(ArrayList<SelectItem> listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    public String btnAtras_action() {
        //return null means stay on the same page
        return "case1";
    }
    public String btnGenerar_action() {
        //return null means stay on the same page

        List<Auditoria> lista = null;
         if(entidad.equals("Empleado")){
            lista = getServicioAuditoria().buscarPor(fechaInicial, fechaFinal, null, ciCliente, accion, entidad);
         }else{
            lista = getServicioAuditoria().buscarPor(fechaInicial, fechaFinal, ciCliente, null, accion, entidad);
         }
        listaAuditoria = new ArrayDataModel(lista.toArray());

        return null;
    }

    public String btnLimpiar_action() {
        if(getServicioAuditoria().limpiarTodo()){
            ciCliente="";
            
            entidad="Cliente";
            disableClient=false;
            disableEmpleado=true;
            listaAuditoria = new ArrayDataModel();
        }
        return null;
    }

    /**
     * @return the timeZone
     */
    public TimeZone getTimeZone() {
        return timeZone;
    }

    /**
     * @param timeZone the timeZone to set
     */
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * @return the disable
     */
  

    /**
     * @return the disableClient
     */
    public Boolean getDisableClient() {
        return disableClient;
    }

    /**
     * @param disableClient the disableClient to set
     */
    public void setDisableClient(Boolean disableClient) {
           
        this.disableClient = disableClient;
    }

    /**
     * @return the disableEmpleado
     */
    public Boolean getDisableEmpleado() {
        return disableEmpleado;
    }

    /**
     * @param disableEmpleado the disableEmpleado to set
     */
    public void setDisableEmpleado(Boolean disableEmpleado) {
      
        this.disableEmpleado = disableEmpleado;
    }

    public String txtCliente_action() {
        
        
        return null;
    }



}


