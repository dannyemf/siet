package siet.dao;


import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.criterion.Restrictions;
import siet.modelo.Cliente;
import siet.modelo.Documentacion;

public class DocumentacionDAO extends Dao {

	/*
       private Long id = -1L;
    private byte[] dataCedula;
    private byte[] dataFoto;
    private byte[] dataCertificado;
    private byte[] dataLibreta;
    private byte[] dataEscritura;
    private Cliente cliente;
*/
	public static final String DATACEDULA="dataCedula";
	public static final String  DATAFOTO="dataFoto";
    public static final String  DATACERTIFICADO="dataCerticado";
    public static final String  DATALIBRETA= "dataLibreta";
    public static final String  DATAESCRITURA="dataEscritura";
    //public static final String LOGIN = "login"

    public DocumentacionDAO() {
        super();
    }

	public boolean guardar(Documentacion transientInstance) {
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
		}finally{
            closeSession();
            return b;
        }
	}

	public boolean eliminar(Documentacion persistentInstance) {
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

    public Documentacion buscarPorCliente(Cliente cliente) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Documentacion.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.eq("cliente", cliente));
        Documentacion d = (Documentacion)criteria.uniqueResult();
        commit();
        closeSession();
		return d;
	}

	/*public Documentacion buscarPorLogin(Object login) {
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

    public List buscarPorNombres(Object nombres) {
        beginTransaction();
        Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(NOMBRES, nombres.toString() + "%"));
        List l = criteria.list();
        commit();
        closeSession();
		return l;
	}

    public List buscarPorApellidos(Object apellidos) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(APELLIDOS, apellidos.toString() + "%"));
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

    public List buscarPorLoginLike(Object login) {
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Cliente.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(LOGIN, login.toString() + "%"));
        List lista = criteria.list();
        commit();
        closeSession();
		return lista;
	}

    public Documentacion buscarPorCedula(Object cedula []) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();
		Criteria criteria = getSession().createCriteria(Documentacion.class);
        criteria.setLockMode(LockMode.UPGRADE);
        criteria.add(Restrictions.like(dataCedula,cedula.toString()));
        try {
           us = (Documentacion)criteria.uniqueResult();
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
}*/
    /*public Cl buscarPorCedula1(Object cedula) {
        //info ("Buscando instancia de Usuario con cédula: " + cedula);
        beginTransaction();

        try {
            Query q = getSession().createQuery("from Cliente where cedula = ?");
            q.setString(0, cedula.toString());
            Cliente us = (Cliente)q.uniqueResult();
            commit();
          return us;
        } catch (Exception e) {
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

    public List<Documentacion> buscarPorFechaRegistro(Date desde, Date hasta) {
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
*/
	public Documentacion merge(Documentacion detachedInstance) {
		//info("Merge instancia de Usuari");
		try {
            beginTransaction();
			Documentacion result = (Documentacion) getSession().merge(detachedInstance);
			//info("Merge exitoso");
			return result;
		} catch (RuntimeException re) {
			//error("Merge fallido", re);
			return detachedInstance;
		}finally{
            closeSession();
        }
	}

	public boolean actualizar(Documentacion instance) {
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

    public Documentacion refresh(Documentacion instance) {

		try {
            getSession().refresh(instance);
		} catch (Exception re) {

		}finally{

        }

        return instance;
	}
}