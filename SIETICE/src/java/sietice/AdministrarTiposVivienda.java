
package sietice;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.model.ArrayDataModel;
import siet.servicio.ServicioDocumentacion;
import siet.servicio.ServicioCliente;
import siet.servicio.ServicioProyecto;
import siet.servicio.ServicioEmpleado;
import siet.servicio.ServicioVivienda;


public class AdministrarTiposVivienda extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    
    private ArrayDataModel listaTiposVivienda = new ArrayDataModel();

    public ArrayDataModel getListaTiposVivienda() {
        listaTiposVivienda = new ArrayDataModel(getServicioVivienda().listarTodos().toArray());
        return listaTiposVivienda;
    }

    public void setListaTiposVivienda(ArrayDataModel listaTiposVivienda) {
        this.listaTiposVivienda = listaTiposVivienda;
    }
    private com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel dataTable2Model = new com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel();

    public com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    

    // </editor-fold>

    public AdministrarTiposVivienda() {
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
            log("AdministrarTiposVivienda Initialization Failure", e);
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

    public ServicioVivienda getServicioVivienda() {
        return (ServicioVivienda) getBean("ServicioVivienda");
    }

  

    public String btntipovivienda_action() {
    
        getServicioVivienda().nuevo();
        return "case-editar";
    }

    public String btnvolver_action() {
      
        return "case2";
    }

    public String cmdLnkEditar_action() {
 
        siet.modelo.TipoVivienda tp = (siet.modelo.TipoVivienda)listaTiposVivienda.getRowData();
        getServicioVivienda().editar(tp);
        return "case-editar";
    }
    
}

