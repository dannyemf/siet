package siet.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import siet.modelo.Auditoria;
import siet.modelo.Cliente;
import siet.modelo.Empleado;

public class AuditoriaDAO extends Dao {

    public AuditoriaDAO() {
        super();
    }

	public boolean guardar(Auditoria transientInstance) {
		//log.info("Guardando Empleado.... ");
        boolean b = false;
		try {
            getSession().flush();
            beginTransaction();
			getSession().save(transientInstance);
            commit();
			//info("Cliente guardado correctamente.");
            b = true;
		} catch (RuntimeException re) {
			//error("Error al guardar usuario: ", re);
            rollback();
            b = false;
		}finally{
            closeSession();
            return b;
        }
	}

	public boolean eliminar(Auditoria persistentInstance) {
		//info("Borrando Empleado....");
        persistentInstance = merge(persistentInstance);
        boolean accion = false;
		try {
            beginTransaction();
			getSession().delete(persistentInstance);
            commit();
			//info("Empleado borrado correctamente");
            accion = true;
		} catch (RuntimeException re) {
            rollback();
			//error("Error al borrar Empleado: ", re);
            accion = false;
		}finally{
            closeSession();
            return accion;
        }
	}

    public boolean limpiarTodo() {
        boolean accion = false;
		try {
            beginTransaction();
            SQLQuery q = getSession().createSQLQuery("delete from Auditoria");
            q.executeUpdate();
            commit();
            accion = true;
		} catch (RuntimeException re) {
            rollback();
            accion = false;
		}finally{
            closeSession();
            return accion;
        }
	}



	public List<Auditoria> buscarTodos() {
        //info("Buscando todas las instancias de Usuario");
        List lista = null;
		try {
            getSession().clear();
            beginTransaction();
            Criteria criteria = getSession().createCriteria(Auditoria.class);
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

    public List<Cliente> buscarPorFechas(Date desde, Date hasta) {
		//info("Buscando instancias de Usuarios dentro del rango de fecha: " + desde + " - " + hasta);
        List lista = null;
		try {
            beginTransaction();
			String queryString = "from Auditoria as model where model.fecha > ? and model.fecha < ?";
			Query queryObject = getSession().createQuery(queryString);
            queryObject.setDate(0, desde);
            queryObject.setDate(1, hasta);
            lista = queryObject.list();
            commit();
            //info ("Búsqueda exitosa");
		} catch (RuntimeException re) {
			//error("Error de búsqueda: ", re);
			lista = new ArrayList();
		}finally{
            closeSession();
            return lista;
        }
	}

	public Auditoria merge(Auditoria detachedInstance) {
		//info("Merge instancia de Usuari");
		try {
            beginTransaction();
			Auditoria result = (Auditoria) getSession().merge(detachedInstance);
			//info("Merge exitoso");
			return result;
		} catch (RuntimeException re) {
			//error("Merge fallido", re);
			return detachedInstance;
		}finally{
            closeSession();
        }
	}

	public boolean actualizar(Auditoria instance) {
        boolean b = false;
		try {
            beginTransaction();
            getSession().update(instance);
            commit();
            b = true;
		} catch (Exception re) {
			rollback();
            b = false;
		}finally{
            closeSession();
            return b;
        }
	}

    /**
     * Busca por varios criterios
     * @param desde Fecha inicial
     * @param hasta Fecha final
     * @param accion El nombre de la accion. Si es para todas las acciones enviar null
     * @param entidad El nombre de la entidad. Si es para todas las entidades enviar null
     * @param cliente Filtro para el cliente. Si se desea buscar para todos los clientes enviar null
     * @param empleado Filtro para empleado. Si es para todos los empleados enviar null
     * @return Lista de auditorias que coincidan con los criterios indicados
     */
    public List<Auditoria> buscarPor(Date desde, Date hasta, String accion, String entidad, Cliente cliente, Empleado empleado) {
		//info("Buscando instancias de Usuarios dentro del rango de fecha: " + desde + " - " + hasta);
        List lista = null;
		try {
            beginTransaction();
			String queryString = "from Auditoria where fecha >= ? and fecha <= ?";

            if(accion != null){
                queryString += " and accion = :acc";
            }

            if(entidad != null){
                queryString += " and entidad = :ent";
            }

            if(cliente != null){
                queryString += " and cliente = :cli";
            }

            if(empleado != null){
                queryString += " and empleado = :emp";
            }

            System.out.println(queryString);

			Query queryObject = getSession().createQuery(queryString);
            queryObject.setDate(0, desde);
            queryObject.setDate(1, hasta);

            if(accion != null){
                queryObject.setString("acc", accion);
            }
            if(entidad != null){
                queryObject.setString("ent", entidad);
            }
            if(cliente != null){
                queryObject.setEntity("cli", cliente);
            }

            if(empleado != null){
                queryObject.setEntity("emp", empleado);
            }

            lista = queryObject.list();
            commit();
            //info ("Búsqueda exitosa");
		} catch (RuntimeException re) {
			//error("Error de búsqueda: ", re);
			lista = new ArrayList();
		}finally{
            closeSession();
            return lista;
        }
	}

    public static void main(String args[]){

       System.out.println(new AuditoriaDAO().buscarPor(new Date(), new Date(), null, null, null, null));
    }

}
