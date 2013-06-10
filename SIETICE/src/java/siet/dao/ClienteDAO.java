package siet.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import siet.modelo.Cliente;

public class ClienteDAO extends Dao {

	// property constants
	public static final String LOGIN = "login";
	public static final String CLAVE = "clave";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String APELLIDODOS = "apellidodos";
    public static final String CEDULA = "ci";

    public ClienteDAO() {
        super();
    }


	public Cliente buscarPorLogin(Object login) {
        //info("Borrando instancia de Usuario con login " + login);
        String sql = "from Cliente as model where model.login = ?";
        Cliente us = null;
        try {
            getSession().clear();
            getSession().flush();

            beginTransaction();
            Query q = getSession().createQuery(sql);
            q.setString(0, login.toString());
            List<Cliente> l = q.list();
            commit();
            if(! l.isEmpty()){
                us = l.get(0);
            }
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            rollback();
        }finally{
            closeSession();
        }
        return us;
	}

    public List buscarPorNombres(Object nombre) {
        beginTransaction();
        Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(NOMBRE, nombre.toString() + "%"));
        List l = criteria.list();
        commit();
        closeSession();
		return l;
	}

    public List buscarPorApellidos(Object apellido) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(APELLIDO, apellido.toString() + "%"));
        List l = criteria.list();
        commit();
        closeSession();
		return l;
	}

    public List buscarPorCedulaLike(Object cedula) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(CEDULA, cedula.toString() + "%"));
        List lista = criteria.list();
        commit();
        closeSession();
		return lista;
	}

    public List buscarPorLoginLike(Object clave) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(LOGIN, clave.toString() + "%"));
        List lista = criteria.list();
        commit();
        closeSession();
		return lista;
	}

    public Cliente buscarPorCedula(Object cedula) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.eq(CEDULA, cedula == null  ? "" : cedula.toString()));
        try {
          Cliente us = (Cliente)criteria.uniqueResult();
          commit();
          //info ("Búsqueda exitosa");
          return us;
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            return null;
        }finally{
            closeSession();
        }
	}

    public Cliente buscarPorClave(Object clave) {
       beginTransaction();
		Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(CLAVE, clave.toString()));
        try {
          Cliente us = (Cliente)criteria.uniqueResult();
          commit();
          //info ("Búsqueda exitosa");
          return us;
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            return null;
        }finally{
            closeSession();
        }
	}

	public List<Cliente> buscarTodos() {
        //info("Buscando todas las instancias de Usuario");
        List lista = null;
		try {
            getSession().clear();
            beginTransaction();
            Criteria criteria = getSession().createCriteria(Cliente.class);
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

    public List<Cliente> buscarPorFechaRegistro(Date desde, Date hasta) {
		//info("Buscando instancias de Usuarios dentro del rango de fecha: " + desde + " - " + hasta);
        List lista = null;
		try {
            beginTransaction();
			String queryString = "from Cliente as model where model.fechaRegistro > ? and model.fechaRegistro < ?";
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

	public Cliente merge(Cliente detachedInstance) {
		//info("Merge instancia de Usuari");
		try {
            beginTransaction();
			Cliente result = (Cliente) getSession().merge(detachedInstance);
			//info("Merge exitoso");
			return result;
		} catch (RuntimeException re) {
			//error("Merge fallido", re);
			return detachedInstance;
		}finally{
            closeSession();
        }
	}

	public boolean actualizar(Cliente instance) {
		//info("Actualizando instancia de Empleado");
        //Empleado us = merge(instance);
        boolean b = false;
		try {
            beginTransaction();
            getSession().update(instance);
            commit();
			//info("Actualización exitosa");
            b = true;
		} catch (Exception re) {
			//error("Actualización fallida", re);
			rollback();
            b = false;
		}finally{
            closeSession();
            return b;
        }
	}
}
//////////////////////
