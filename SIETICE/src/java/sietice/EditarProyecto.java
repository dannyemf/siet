
package sietice;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.model.SelectItem;
import siet.modelo.Empleado;
import siet.modelo.Proyecto;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioEmpleado;
import siet.servicio.ServicioVivienda;


public class EditarProyecto extends AbstractPageBean {

    private Long idEmpleado = 0L;
    private Proyecto proyecto;
    private List itemsEmpleados = new ArrayList();

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
    public EditarProyecto() {
        itemsEmpleados.add(new SelectItem("","Vacio"));
    }

    public void editar(Proyecto p){
        this.proyecto = p;

        if(p.getJefe() != null){
            this.idEmpleado = p.getJefe().getId();
        }else{
            this.idEmpleado = 0L;
        }

        this.itemsEmpleados = new ArrayList<SelectItem>();
        List<Empleado> lst = getServicioEmpleado().listarTodos();
        for (Iterator<Empleado> it = lst.iterator(); it.hasNext();) {
            Empleado e = it.next();
            this.itemsEmpleados.add(new SelectItem(e.getId(), e.getNombres() + " " + e.getApellido()));
        }
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
    
    
    

    @Override
    public void preprocess() {
    }

    @Override
    public void prerender() {
    }

   
    @Override
    public void destroy() {
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
        Empleado e = getServicioEmpleado().buscarPorId(idEmpleado);
        getServicioProyecto().getProyectoEdicion().setJefe(e);
        getServicioProyecto().guardarProyecto();
        return "aceptar";
    }

    public String btncancelar_action() {
        return "cancelar";
    }
    
    /**
     * @return the idEmpleado
     */
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SietApplicationBean getSietApplicationBean() {
        return (SietApplicationBean) getBean("SietApplicationBean");
    }

    /**
     * @return the proyecto
     */
    public Proyecto getProyecto() {
        return proyecto;
    }

    /**
     * @return the itemsEmpleados
     */
    public List getItemsEmpleados() {
        return itemsEmpleados;
    }

    /**
     * @param itemsEmpleados the itemsEmpleados to set
     */
    public void setItemsEmpleados(List itemsEmpleados) {
        this.itemsEmpleados = itemsEmpleados;
    }

}

