
package dao;

import modelo.*;
import java.util.Collection;
import nicon.notify.core.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import hibernate.HibernateUtil;

public class JornadaDAO implements IDAO<Jornada> {

    private Session sesion;

    public JornadaDAO() {
    
    }
    
    
    public JornadaDAO(Session sesion) {
        this.sesion = sesion;
    }
    
    @Override
    public void guardar(Jornada t) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(t);
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
    public Jornada buscar(Object fecha) {
        Jornada jornada = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(JornadaDeTrabajo.class);
            criterio.add(Restrictions.eq("fecha", fecha));
            if (!criterio.list().isEmpty()) {
                jornada = (JornadaDeTrabajo) criterio.list().get(0);
            } 
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return jornada;
    }
    
    public Jornada jornadaDeHoy() {
         Jornada jornada = new JornadaDeTrabajo();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Query diaDeHoy = 
                    sesion.createQuery("FROM JornadaDeTrabajo as j WHERE j.fecha = current_date");
           if (diaDeHoy.list().isEmpty()) 
               return jornada;
           
           jornada = (JornadaDeTrabajo) diaDeHoy.list().get(0);
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    + e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        }
        return jornada;
    }

    @Override
    public void actualizar(Jornada t) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(t);
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
    public void eliminar(Jornada t) {
        
    }

    @Override
    public Collection<Jornada> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
