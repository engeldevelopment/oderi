
package dao;

import modelo.Departamento;
import java.util.*;
import nicon.notify.core.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import hibernate.HibernateUtil;

public class DepartamentoDAO implements IDAO<Departamento>{
    
    private Session sesion;

    public DepartamentoDAO() {
    }
    
    public DepartamentoDAO(Session sesion) {
        this.sesion = sesion;
    }
    
    @Override
    public void guardar(Departamento dpto){
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(dpto);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }
    
    @Override
    public Departamento buscar(Object dpto){
        Departamento departamento = new Departamento();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Departamento.class);
            criterio.add(Restrictions.eq("id", dpto));
            departamento = (Departamento) criterio.list().get(0);
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return departamento;
    }
    
    public Departamento buscarPorNombre(Object dpto){
        Departamento departamento = new Departamento();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Departamento.class);
            criterio.add(Restrictions.eq("nombre", dpto));
            departamento = (Departamento) criterio.list().get(0);
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return departamento;
    }
        
    @Override
    public void actualizar(Departamento dpto){
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(dpto);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }
    
    @Override
    public void eliminar(Departamento dpto){
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(dpto);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }
    
    @Override
    public List<Departamento> buscarTodos() {
        List<Departamento> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Departamento.class);
            criterio.addOrder(Order.asc("id"));
            lista = criterio.list();
        } catch (HibernateException e) {
              Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        
        return lista;
    }

}
