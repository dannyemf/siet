/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.icesoft.faces.component.outputresource.OutputResource;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import siet.servicio.Respaldo;
import siet.servicio.ServicioRespaldo;


public class AdministrarRespaldos extends AbstractPageBean {

    private Date fechaInicio = new Date();
    private Date fechaFin = new Date();
    private TimeZone timeZone = TimeZone.getDefault();
    private List<Respaldo> lista = new ArrayList<Respaldo>();
    private ArrayDataModel model = new ArrayDataModel();
   
    

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private OutputResource outputResource1 = new OutputResource();

    public OutputResource getOutputResource1() {
        return outputResource1;
    }

    public void setOutputResource1(OutputResource or) {
        this.outputResource1 = or;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AdministrarRespaldos() {
    }

       

    public ArrayDataModel getModel() {
        model = new ArrayDataModel(lista.toArray());
        return model;
    }

    public void setModel(ArrayDataModel modelEmpleados) {
        this.model = modelEmpleados;
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
            log("AdministrarEmpleado Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

  
    @Override
    public void preprocess() {
    }

    @Override
    public void prerender() {
    }

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

    protected ServicioRespaldo getServicioRespaldo() {
        return (ServicioRespaldo) getBean("ServicioRespaldo");
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String btnBuscar_action() {
        lista = getServicioRespaldo().listarRespaldos(fechaInicio, fechaFin);
        return null;
    }

    public String btnNuevo_action() {
        boolean b = getServicioRespaldo().respaldar();
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(b ? "Respaldo creado exitosamente!" : "Respaldo no creado, verifique la configuración."));
        return null;
    }

    public String linkActionRestaurar_action() {
        Respaldo item = (Respaldo)model.getRowData();
        boolean b = getServicioRespaldo().restaurar(item);
        return null;
    }

    public String linkActionEliminar_action() {
        Respaldo item = (Respaldo)model.getRowData();
        boolean b = getServicioRespaldo().eliminar(item);
        if(b){
            lista.remove(item);
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
     * @return the lista
     */
    public List<Respaldo> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<Respaldo> lista) {
        this.lista = lista;
    }

    public String btn_salir_action() {
        //return null means stay on the same page
        return "case1";
    }

    

    
    
}

