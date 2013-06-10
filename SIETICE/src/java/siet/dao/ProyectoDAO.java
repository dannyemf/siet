package siet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import siet.modelo.Cliente;
import siet.modelo.Proyecto;
import siet.modelo.ProyectoCliente;

public class ProyectoDAO extends Dao<Proyecto> {

    public static final String NOMBRE = "nombre";
    public static final String PROPIETARIO = "propietario";
    public static final String UBICACION = "ubicacion";
    public static final String PRESUPESTO = "presupuesto";
    public static final String ESTADO = "estado";
    public static final String AVANCE = "avance";

    public ProyectoDAO() {
        super();
    }

    public ProyectoCliente buscarPorCliente(Cliente cliente) {
        List lst = super.buscarPorEq(ProyectoCliente.class, PROPIETARIO, cliente);
        if(lst.size() > 0){
            return (ProyectoCliente)lst.get(0);
        }
        return null;
	}

    public List buscarPorNombres(String nombres) {
        return super.buscarPorRigthLike(ProyectoCliente.class, NOMBRE, nombres);
	}
    public List<Proyecto> buscarTodos() {
        //info("Buscando todas las instancias de Usuario");
        List lista = null;
		try {
            getSession().clear();
            beginTransaction();
            Criteria criteria = getSession().createCriteria(Proyecto.class);
            criteria.setLockMode(LockMode.UPGRADE);
            lista = criteria.list();
            commit();
            //info("Búsqueda exitosa");
		} catch (RuntimeException re) {
			//error("Error de búsqueda: ", re);
			lista = new ArrayList();
		}finally{
            closeSession();
            return lista;
        }
	}

    public Proyecto buscarPorId(Object proyecto) {
        //info("Borrando instancia de Usuario con login " + login);
        Proyecto us = null;
        try {
            getSession().clear();
            getSession().flush();
            beginTransaction();
            Long id = Long.parseLong(proyecto.toString());
             us=      (Proyecto)getSession().get(Proyecto.class, id);
            commit();
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            rollback();
        }finally{
            closeSession();
        }
        return us;
	}

    public ProyectoCliente buscarResidntes(Object residenteO) {
        //info("Borrando instancia de Usuario con login " + login);
        String sql = "from Proyecto as model where model.residenteObra = ?";
        ProyectoCliente us = null;
        try {
            getSession().clear();
            getSession().flush();

            beginTransaction();
            Query q = getSession().createQuery(sql);
            q.setString(0, residenteO.toString());
            //TipoVivienda l = (TipoVivienda)getSession().load(TipoVivienda.class, tipo.toString());
             us= (ProyectoCliente)q.uniqueResult();
            commit();
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            rollback();
        }finally{
            closeSession();
        }
        return us;
	}


	public List<ProyectoCliente  > buscarProyectosClientes() {
        return super.buscarTodos(ProyectoCliente.class);
	}

    public List<ProyectoCliente  > buscarProyectosClientesPor(Proyecto p) {
        return super.buscarPorEq(ProyectoCliente.class, "proyecto", p);
	}

    public List<ProyectoCliente> buscarProyectoClientePorEstado(String estado) {
        return super.buscarPorEq(ProyectoCliente.class, ESTADO, estado);
	}


	
}