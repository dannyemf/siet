
package sietice;

import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import siet.dao.EmpleadoDAO;
import siet.dao.TipoViviendaDAO;
import siet.modelo.Empleado;
import siet.modelo.Proyecto;
import siet.modelo.ProyectoCliente;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioEmpleado;
import siet.servicio.ServicioVivienda;


public class EditarProyectoCliente extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultSelectItemsArray dropdown1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getDropdown1DefaultItems() {
        return dropdown1DefaultItems;
    }

    public void setDropdown1DefaultItems(DefaultSelectItemsArray dsia) {
        this.dropdown1DefaultItems = dsia;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EditarProyectoCliente() {
    }

    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        
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
       
    }
    private siet.modelo.ProyectoCliente currenProyecto;
    private Object residenteO="";
    private Object tipo="";
    private Object idEmpleado;
    private Long idProyecto;
    private ArrayList<SelectItem> estado;
    private ArrayList<SelectItem> tipovivienda;
    private ArrayList<SelectItem> residenteObra;
    private ArrayList<SelectItem> itemsProyectos;
    private ProyectoCliente proyectoCliente;
    
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
        this.proyectoCliente = pr;
        this.
        idProyecto = null;
        if(pr.getProyecto() != null){
            idProyecto = pr.getProyecto().getId();
        }
        tipo = pr.getTipoVivienda().getId();

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

    public  ServicioVivienda getServicioVivienda() {
        return (ServicioVivienda) getBean("ServicioVivienda");
    }
    
    public  ServicioProyecto getServicioProyecto() {
        return (ServicioProyecto) getBean("ServicioProyecto");
    }

     public  ServicioEmpleado getServicioEmpleado() {
        return (ServicioEmpleado) getBean("ServicioEmpleado");
    }
 

    public String btnaceptar_action() {
        siet.modelo.TipoVivienda tp = getServicioVivienda().buscarPorId(tipo);
        Empleado e = getServicioEmpleado().buscarPorId(idEmpleado);
        getServicioProyecto().getProyectoClienteEdicion().setTipoVivienda(tp);
        getServicioProyecto().getProyectoClienteEdicion().setResidente(e);
        getServicioProyecto().guardarProyectoCliente();
        // TODO: Replace with your code
        return "case";
    }

    public String btncancelar_action() {
        //return null means stay on the same page
        return "ccancelar";
    }

   


    /**
     * @param residenteObra the residenteObra to set
     */
  
    /**
     * @param residenteO the residenteO to set
   

    /**
     * @return the tipo
     */
    public Object getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the idEmpleado
     */
    public Object getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(Object idEmpleado) {
        this.idEmpleado = idEmpleado;
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
    public ArrayList<SelectItem> getItemsProyectos() {
        return itemsProyectos;
    }

    /**
     * @param itemsProyectos the itemsProyectos to set
     */
    public void setItemsProyectos(ArrayList<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

   public void cmbProyecto_processValueChange(ValueChangeEvent vce) {
        try {
            Proyecto p = getServicioProyecto().buscarPorId(vce.getNewValue());
            proyectoCliente.setProyecto(p);
            proyectoCliente.setResidente(p.getJefe());
        } catch (Exception e) {
            proyectoCliente.setProyecto(null);
            proyectoCliente.setResidente(null);
        }
    }

    /**
     * @return the residenteObra
     */
    public ArrayList<SelectItem> getResidenteObra() {
        if (residenteObra==null){
        residenteObra = new ArrayList<SelectItem>();
        residenteObra.add(new SelectItem(0,"--Ninguno--"));
        List<siet.modelo.Empleado> lst = new EmpleadoDAO().buscarTodos();
         for (int i = 0; i < lst.size(); i++) {
                siet.modelo.Empleado e = lst.get(i);
                if(i == 0){
                    residenteO = e.getApellido();
                }
                residenteObra.add(new SelectItem(e.getId(),e.getNombres() + " " + e.getApellido()));

       }

    }
        return residenteObra;
    }

    /**
     * @param residenteObra the residenteObra to set
     */
    public void setResidenteObra(ArrayList<SelectItem> residenteObra) {
        this.residenteObra = residenteObra;
    }

    /**
     * @return the residenteO
     */
    public Object getResidenteO() {
        return residenteO;
    }

    /**
     * @param residenteO the residenteO to set
     */
    public void setResidenteO(Object residenteO) {
        this.residenteO = residenteO;
    }

 
   
    
}

