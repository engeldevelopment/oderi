
package dao;

import modelo.Justificacion;
import java.util.Collection;
import nicon.notify.core.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import hibernate.HibernateUtil;

public class JustificacionDAO implements IDAO<Justificacion>{
    
    private Session sesion;

    public JustificacionDAO(Session sesion) {
        this.sesion = sesion;
    }

    public JustificacionDAO() {
    }
    
    @Override
    public void guardar(Justificacion t) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(t);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", 
                    "Ocurrió un error: "+e.getMessage(), NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        
    }

    @Override
    public Justificacion buscar(Object filtro) {
        Justificacion justificacion = new Justificacion();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Justificacion.class);
            criterio.add(Restrictions.eq("id", filtro));
            justificacion = (Justificacion) criterio.list().get(0);
        } catch (Exception e) {
            Notification.windowMessage(null, "Disculpe!", 
                    "Ocurrió un error: "+e.getMessage(),NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return justificacion;
    }

    @Override
    public void actualizar(Justificacion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Justificacion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Justificacion> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
