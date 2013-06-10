/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.web.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import siet.dao.EmpleadoDAO;
import siet.dao.ProyectoDAO;
import siet.modelo.Empleado;
import siet.modelo.ProyectoCliente;
import siet.util.EncrypUtil;

/**
 *
 * @author LENIN
 */
@WebService()
public class SietWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "logear")
    public boolean  logear(@WebParam(name = "usuario")
    String usuario, @WebParam(name = "clave")
    String clave) {
       Empleado emp = new EmpleadoDAO().buscarPorLogin(usuario);
        if(emp != null){
            String eclave = EncrypUtil.encriptar(clave);
            if(emp.getClave().equals(eclave)){
                return true;
            }
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtenerProyectos")
    public String obtenerProyectos() {
        //TODO obtenerTexto your implementation code here:
        List<ProyectoCliente> list = new ProyectoDAO().buscarProyectoClientePorEstado("EN PROCESO");
        
        String s = new XMLProyectoUtil().obtenerTexto(list);
        
        return s;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "aprobar")
    public boolean aprobar(@WebParam(name = "id")
    Long id, @WebParam(name = "observacion")
    String observacion) {
        ProyectoDAO dao = new ProyectoDAO();
        ProyectoCliente p = (ProyectoCliente)dao.buscarPorId(ProyectoCliente.class, id);
        if(p!= null){
            p.setEstado("APROBADO");
            p.setObservacion(observacion);
            boolean b = dao.actualizar(p);
            return b;
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "rechazar")
    public boolean  rechazar(@WebParam(name = "id")
    Long id, @WebParam(name = "observacion")
    String observacion) {
        ProyectoDAO dao = new ProyectoDAO();
        ProyectoCliente p = (ProyectoCliente)dao.buscarPorId(ProyectoCliente.class, id);
        if(p!= null){
            p.setEstado("RECHAZADO");
            p.setObservacion(observacion);
            boolean b = dao.actualizar(p);
            return b;
        }
        return false;
    }

}
