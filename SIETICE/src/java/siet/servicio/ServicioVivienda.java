/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.servicio;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.List;
import javax.faces.FacesException;
import siet.dao.*;

import siet.modelo.TipoVivienda;
import siet.util.StringUtil;
import sietice.SietApplicationBean;

/**
 *
 * @author Principal
 */
public class ServicioVivienda extends AbstractSessionBean{

      private TipoVivienda TipoViviendaEdicion = null;
   // private Documentacion DodumentacionLogeado = null;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">


    private void _init() throws Exception {
    }

    public ServicioVivienda() {
        
    }

    @Override
    public void init() {

        super.init();

        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }
    }


    @Override
    public void passivate() {
    }

    @Override
    public void activate() {
    }


    @Override
    public void destroy() {
    }
    
    

    public void nuevo(){
        TipoVivienda tipv = new TipoVivienda();
        TipoViviendaEdicion=tipv;

        sietice.EditarTipoVivienda b = ((sietice.EditarTipoVivienda)getBean("EditarTipoVivienda"));
        b.setProyectoId(null);
        b.setNombrePlano("");
    }

     public boolean  eliminar(TipoVivienda tipv){


            return new TipoViviendaDAO().eliminar(tipv);

    }

    public void editar(TipoVivienda tipv){
        this.TipoViviendaEdicion=tipv;
        sietice.EditarTipoVivienda b = ((sietice.EditarTipoVivienda)getBean("EditarTipoVivienda"));
        b.setProyectoId(tipv.getProyecto() != null ? tipv.getProyecto().getId() : null);
        b.setNombrePlano(tipv.getPlano());
    }

    public boolean guardar(){
        if(TipoViviendaEdicion.getId().longValue() == -1){
            return new TipoViviendaDAO().guardar(TipoViviendaEdicion);
        }else{

            return new TipoViviendaDAO().actualizar(TipoViviendaEdicion);
        }
    }

    public List<TipoVivienda> listarTodos(){
        return new TipoViviendaDAO().buscarTodos();
    }

     public TipoVivienda buscarPorId(Object id){
        return new TipoViviendaDAO().buscarPorId(id);
    }

    /**
     * @return the DocumentacionEdicion
     */
    

    /**
     * @param DocumentacionEdicion the DocumentacionEdicion to set
     */
  

    /**
     * @return the DodumentacionLogeado
     */
    

    /**
     * @param DodumentacionLogeado the DodumentacionLogeado to set
     */
  

    /**
     * @return the TipoViviendaEdicion
     */

    public TipoVivienda getTipoViviendaEdicion() {
        return TipoViviendaEdicion;
    }

    public boolean isRenderPlano(){
       return !StringUtil.isNullOrEmpty(getTipoViviendaEdicion().getPlano());
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
     * @param TipoViviendaEdicion the TipoViviendaEdicion to set
     */
   
}
