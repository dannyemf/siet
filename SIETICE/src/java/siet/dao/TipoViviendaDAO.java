package siet.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import siet.modelo.TipoVivienda;

public class TipoViviendaDAO extends Dao {


	public static final String ESTRUCTURA="estructura";
	public static final String  CUBIERTA="Cubierta";
    public static final String  PISO="piso";
    public static final String  CIELORAZO= "cielorazo";
    public static final String  INSTALELEC="instalelec";
    public static final String CLOSET="closet";
	public static final String  PUERTAS="puertas";
    public static final String  VENTANAS="ventanas";
    public static final String  ENLUCIDO= "enlucido";
    public static final String  PINTURA="pintura";
    //public static final String LOGIN = "login"


    public TipoViviendaDAO() {
        super();
    }

	


	public TipoVivienda buscarPorTipo(Object tipo) {
        //info("Borrando instancia de Usuario con login " + login);
        String sql = "from TipoVivienda as model where model.tipo = ?";
        TipoVivienda us = null;
        try {
            getSession().clear();
            getSession().flush();

            beginTransaction();
            Query q = getSession().createQuery(sql);
            q.setString(0, tipo.toString());
            //TipoVivienda l = (TipoVivienda)getSession().load(TipoVivienda.class, tipo.toString());
             us=      (TipoVivienda)q.uniqueResult();
            commit();
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            rollback();
        }finally{
            closeSession();
        }
        return us;
	}

    public TipoVivienda buscarPorId(Object tipo) {
        //info("Borrando instancia de Usuario con login " + login);
        TipoVivienda us = null;
        try {
            getSession().clear();
            getSession().flush();
            beginTransaction();
            Long id = Long.parseLong(tipo.toString());
             us=      (TipoVivienda)getSession().get(TipoVivienda.class, id);
            commit();
        } catch (Exception e) {
            //error ("Error de búsqueda: " + e);
            rollback();
        }finally{
            closeSession();
        }
        return us;
	}


	public List<TipoVivienda> buscarTodos() {
        //info("Buscando todas las instancias de Usuario");
        List lista = null;
		try {
            getSession().clear();
            beginTransaction();
            Criteria criteria = getSession().createCriteria(TipoVivienda.class);
            criteria.setLockMode(LockMode.UPGRADE);
            lista = criteria.list();
            commit();
		} catch (RuntimeException re) {
			lista = new ArrayList();
		}finally{
            closeSession();
            return lista;
        }
	}






	public TipoVivienda merge(TipoVivienda detachedInstance) {
		//info("Merge instancia de Usuari");
		try {
            beginTransaction();
			TipoVivienda result = (TipoVivienda) getSession().merge(detachedInstance);
			//info("Merge exitoso");
			return result;
		} catch (RuntimeException re) {
			//error("Merge fallido", re);
			return detachedInstance;
		}finally{
            closeSession();
        }
	}


	public boolean actualizar(TipoVivienda instance) {
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

