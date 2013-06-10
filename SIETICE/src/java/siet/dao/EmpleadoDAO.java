package siet.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;

import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import siet.modelo.Empleado;
import siet.util.EncrypUtil;

public class EmpleadoDAO extends Dao {

	// property constants
	public static final String USUARIO = "usuario";
	public static final String CLAVE = "clave";
    public static final String NOMBRES = "nombre";
    public static final String APELLIDOS = "apellido";
    public static final String CEDULA = "cedula";


    public EmpleadoDAO() {
        super();
    }

    public static void main(String... args){
        String id ="form:xxxm:lll";

        System.out.println(id.substring(0,id.indexOf(":")));
    }

	public Empleado buscarPorLogin(Object login) {
        //info("Borrando instancia de Usuario con login " + login);
        String sql = "from Empleado as model where model.usuario = ?";
        Empleado us = null;
        try {
            getSession().clear();
            getSession().flush();

            beginTransaction();
            Query q = getSession().createQuery(sql);
            q.setString(0, login.toString());
            List<Empleado> l = q.list();
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

    public List buscarPorNombres(Object nombres) {
        beginTransaction();
        Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(NOMBRES, nombres.toString() + "%"));
        List l = criteria.list();
        commit();
        closeSession();
		return l;
	}


    public List buscarPorApellidos(Object apellidos) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(APELLIDOS, apellidos.toString() + "%"));
        List l = criteria.list();
        commit();
        closeSession();
		return l;
	}

    public List buscarPorCedulaLike(Object cedula) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(CEDULA, cedula.toString() + "%"));
        List lista = criteria.list();
        commit();
        closeSession();
		return lista;
	}

    public List buscarPorLoginLike(Object login) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(USUARIO, login.toString() + "%"));
        List lista = criteria.list();
        commit();
        closeSession();
		return lista;
	}

    public Empleado buscarPorCedula(Object usuario) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();
        getSession().clear();
		Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(USUARIO, usuario == null ? "" : usuario.toString()));
        try {
          Empleado us = (Empleado)criteria.uniqueResult();
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

    public Empleado buscarPorCedulaEmpleado(Object usuario) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(CEDULA, usuario == null ? "" : usuario.toString()));
        try {
          Empleado us = (Empleado)criteria.uniqueResult();
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

    public Empleado buscarPorCedulaER(Object cedula, Empleado current) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.eq(CEDULA, cedula.toString()));
        criteria.add(Restrictions.ne("id", current.getId()));
        
        try {
          Empleado us = (Empleado)criteria.uniqueResult();
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

     public Empleado buscarPorContraseña(Object clave) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Empleado.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(CLAVE, clave.toString()));
        try {
          Empleado us = (Empleado)criteria.uniqueResult();
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


    public Empleado buscarPorCedula1(Object cedula) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();

        try {
            Query q = getSession().createQuery("from Empleado where cedula = ?");
            q.setString(0, cedula.toString());
            Empleado us = (Empleado)q.uniqueResult();
            commit();
          return us;
        } catch (Exception e) {
            return null;
        }finally{
            closeSession();
        }
	}

	public List<Empleado> buscarTodos() {
        //info("Buscando todas las instancias de Usuario");
        List lista = null;
		try {
            getSession().clear();
            beginTransaction();
            Criteria criteria = getSession().createCriteria(Empleado.class);
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
    public Empleado buscarPorId(Object id) {
        //info("Borrando instancia de Usuario con login " + login);
       Empleado us = null;
        try {
            getSession().clear();
            getSession().flush();
            beginTransaction();
            Long idE = Long.parseLong(id.toString());
             us=      (Empleado)getSession().get(Empleado.class, idE);
            commit();
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            rollback();
        }finally{
            closeSession();
        }
        return us;
	}

    public List<Empleado> buscarPorFechaRegistro(Date desde, Date hasta) {
		//info("Buscando instancias de Usuarios dentro del rango de fecha: " + desde + " - " + hasta);
        List lista = null;
		try {
            beginTransaction();
			String queryString = "from Empleado as model where model.fechaRegistro > ? and model.fechaRegistro < ?";
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

	public Empleado merge(Empleado detachedInstance) {
		//info("Merge instancia de Usuari");
		try {
            beginTransaction();
			Empleado result = (Empleado) getSession().merge(detachedInstance);
			//info("Merge exitoso");
			return result;
		} catch (RuntimeException re) {
			//error("Merge fallido", re);
			return detachedInstance;
		}finally{
            closeSession();
        }
	}

	public boolean actualizar(Empleado instance) {
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
//
