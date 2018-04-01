
package dao;

import modelo.MotivoDeInasistencia;
import java.util.Collection;
import nicon.notify.core.*;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import hibernate.HibernateUtil;

public class MotivoDeInasistenciaDAO implements IDAO<MotivoDeInasistencia>{

    private Session sesion;

    public MotivoDeInasistenciaDAO() {
    }
    
    public MotivoDeInasistenciaDAO(Session sesion) {
        this.sesion = sesion;
    }
    
    
    @Override
    public void guardar(MotivoDeInasistencia t) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(t);
            sesion.getTransaction().commit();
            
        } catch (HibernateException e) {
            Notification.windowMessage(null, 
                    "Disculpe!", 
                    "Ocurrió un error "+e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }

    @Override
    public MotivoDeInasistencia buscar(Object filtro) {
        MotivoDeInasistencia motivo = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(MotivoDeInasistencia.class);
            criterio.add(Restrictions.eq("id", filtro));
            motivo = (MotivoDeInasistencia) criterio.list().get(0);
        } catch (HibernateException e) {
            Notification.windowMessage(null, 
                    "Disculpe!", 
                    "Ocurrió un error "+e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        
        return motivo;
    }

    @Override
    public void actualizar(MotivoDeInasistencia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(MotivoDeInasistencia t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<MotivoDeInasistencia> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
