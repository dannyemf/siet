/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package siet.dao;

import org.hibernate.Session;

/**
 *
 * @author Administrator
 */
public interface IDao {
    public Session getSession();
    public void closeSession();
    public void beginTransaction();
    public void commit();
    public void rollback();
}
