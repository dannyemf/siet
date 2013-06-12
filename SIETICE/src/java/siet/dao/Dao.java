/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrator
 */
public class Dao<E> implements IDao {

    public Session getSession() {
        return HibernateSessionFactory.getSession();
    }

    public void closeSession() {
        HibernateSessionFactory.closeSession();
    }

    public void beginTransaction() {
        HibernateSessionFactory.getSession().beginTransaction();
    }

    public void commit() {
        HibernateSessionFactory.getSession().getTransaction().commit();
    }

    public void rollback() {
        HibernateSessionFactory.getSession().getTransaction().rollback();
    }

    public boolean guardar(Object transientInstance) {
		//log.info("Guardando Empleado.... ");
        boolean b = false;
		try {
            beginTransaction();
			getSession().save(transientInstance);
            commit();
			//info("Cliente guardado correctamente.");
            b = true;
		} catch (RuntimeException re) {
			//error("Error al guardar usuario: ", re);
            rollback();
            b = false;
            throw re;
		}finally{
            closeSession();
            return b;
        }
	}

    public boolean actualizar(Object instance) {
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

	public boolean eliminar(Object persistentInstance) {
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

     public Object buscarPorId(Class clase, Object id) {
        //info("Borrando instancia de Usuario con login " + login);
        try {
            getSession().clear();
            getSession().flush();
            beginTransaction();
            
            Object e =getSession().get(clase, Long.parseLong(id.toString()));
            commit();
            return e ;
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            rollback();
        }finally{
            closeSession();
        }
        return null;
	}

     public Object merge(Object detachedInstance) {
		//info("Merge instancia de Usuari");
		try {
            beginTransaction();
			Object result = (E) getSession().merge(detachedInstance);
			//info("Merge exitoso");
			return result;
		} catch (RuntimeException re) {
			//error("Merge fallido", re);
			return detachedInstance;
		}finally{
            closeSession();
        }
	}

    

     public List buscarTodos(Class c) {
        //info("Buscando todas las instancias de Usuario");
        List lista = null;
		try {
            getSession().clear();
            beginTransaction();
            Criteria criteria = getSession().createCriteria(c);
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

     public <T extends Object> T buscarPrimero(Class<? extends T> c) {
        //info("Buscando todas las instancias de Usuario");
        Object lista = null;
		try {
            getSession().clear();
            beginTransaction();
            Criteria criteria = getSession().createCriteria(c);
            criteria.setLockMode(LockMode.UPGRADE);
            criteria.setMaxResults(1);

            List tipos = criteria.list();

            lista = tipos.size() > 0 ? tipos.get(0) : null;
            commit();
		} catch (RuntimeException re) {

		}finally{
            closeSession();
            return (T)lista;
        }
	}

    public List buscarPorEq(Class c, String propiedad, Object valor) {
        beginTransaction();
        getSession().clear();
		Criteria criteria = getSession().createCriteria(c);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.eq(propiedad, valor));
        List d = criteria.list();
        commit();
        closeSession();
		return d;
	}

     public List buscarPorRigthLike(Class c, String propiedad, String valor) {
        beginTransaction();
        getSession().clear();
        Criteria criteria = getSession().createCriteria(c);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(propiedad, valor + "%"));
        List l = criteria.list();
        commit();
        closeSession();
		return l;
	}



}
