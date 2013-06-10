/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sietice;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import siet.dao.TipoViviendaDAO;
import siet.modelo.Proyecto;
import siet.modelo.ProyectoCliente;
import siet.servicio.ServicioEmpleado;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioVivienda;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version EditarProyecto.java
 * @version Created on 22/06/2010, 07:01:59 PM
 * @author Desarrollador
 */

public class EditarProyectoEmpleado extends AbstractPageBean {

    private Object idTipo;
    private ProyectoCliente proyectoCLiente;
    private Long idProyecto;
    private List<SelectItem> itemsProyectos = new ArrayList<SelectItem>();
    
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
     * <p>Construct a new Page bean instance.</p>
     */
    public EditarProyectoEmpleado() {
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
            log("EditarProyecto Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    private ArrayList<SelectItem> estado;
    private ArrayList<SelectItem> tipovivienda;
    private ArrayList<SelectItem> residenteObra;

    public ArrayList<SelectItem> getEstado() {
        return estado;
    }
    public void setEstado(ArrayList<SelectItem> estado) {
        this.estado = estado;
    }

    public ArrayList<SelectItem> getTipovivienda() {        
        return tipovivienda;
    }
    public void setTipovivienda(ArrayList<SelectItem> tipovivienda) {
        this.tipovivienda = tipovivienda;
    }



    /**
     * @param residenteObra the residenteObra to set
     */
    public void setResidenteObra(ArrayList<SelectItem> residenteObra) {
        this.residenteObra = residenteObra;
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

    public void editar(ProyectoCliente pr){
        this.proyectoCLiente = pr;

        idProyecto = null;
        if(pr.getProyecto() != null){
            idProyecto = pr.getProyecto().getId();
        }
        idTipo = pr.getTipoVivienda().getId();

        itemsProyectos = new ArrayList<SelectItem>();
        itemsProyectos.add(new SelectItem(-1,"--Ninguno--"));
        List<Proyecto> lst = getServicioProyecto().listarProyectos();
        for (Iterator<Proyecto> it = lst.iterator(); it.hasNext();) {
            Proyecto p = it.next();
            itemsProyectos.add(new SelectItem(p.getId(),p.getNombre()));
        }
        
        tipovivienda = new  ArrayList<SelectItem>();
        List<siet.modelo.TipoVivienda> lstt = new TipoViviendaDAO().buscarTodos();
        for (int i = 0; i < lstt.size(); i++) {
            siet.modelo.TipoVivienda tp = lstt.get(i);
            tipovivienda.add(new SelectItem(tp.getId(), tp.getTipo()));
        }
        estado = new ArrayList<SelectItem>();
        estado.add(new SelectItem("En Proceso", "En proceso"));
        estado.add(new SelectItem("Aprovado", "Aprovado"));
        estado.add(new SelectItem("Rechazado", "Rechazado"));
        
    }

   
    public  ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

     public  ServicioVivienda getServicioVivienda() {
        return (ServicioVivienda) getBean("ServicioVivienda");
    }

     public  ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }
   

    public String btnaceptar_action() {
        siet.modelo.TipoVivienda tp = getServicioVivienda().buscarPorId(idTipo);
        getServicioProyecto().getProyectoClienteEdicion().setTipoVivienda(tp);
        getServicioProyecto().guardarProyectoCliente();
        // TODO: Replace with your code
        return "case1";
    }

    /**
     * @return the idTipo
     */
    public Object getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(Object idTipo) {
        this.idTipo = idTipo;
    }

    public String btnvolver_action() {
        //return null means stay on the same page
        return "case2";
    }

    /**
     * @return the idProyecto
     */
    public Long getIdProyecto() {
        return idProyecto;
    }

    /**
     * @param idProyecto the idProyecto to set
     */
    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    /**
     * @return the itemsProyectos
     */
    public List<SelectItem> getItemsProyectos() {
        return itemsProyectos;
    }

    /**
     * @param itemsProyectos the itemsProyectos to set
     */
    public void setItemsProyectos(List<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    public void cmbProyecto_processValueChange(ValueChangeEvent vce) {
        try {
            Proyecto p = getServicioProyecto().buscarPorId(vce.getNewValue());
            proyectoCLiente.setProyecto(p);
            proyectoCLiente.setResidente(p.getJefe());
        } catch (Exception e) {
            proyectoCLiente.setProyecto(null);
            proyectoCLiente.setResidente(null);
        }
    }

    public void selectInputDate1_processValueChange(ValueChangeEvent vce) {
    }
    
}

