
package dao;

import modelo.Inasistencia;
import java.util.*;
import nicon.notify.core.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import hibernate.HibernateUtil;
import org.joda.time.DateTime;

public class InasistenciaDAO implements IServicioInasistencia {

    private Session sesion;

    public InasistenciaDAO(Session sesion) {
        this.sesion = sesion;
    }

    public InasistenciaDAO() {
       
    }
    
    @Override
    public void guardar(Inasistencia t) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(t);
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
    public Inasistencia buscar(Object filtro) {
        Inasistencia inasistencia = new Inasistencia();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Inasistencia.class);
            criterio.add(Restrictions.eq("id", filtro));
            inasistencia = (Inasistencia) criterio.list().get(0);
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return inasistencia;
    }

    @Override
    public void actualizar(Inasistencia t) {
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
    public void eliminar(Inasistencia t) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(t);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    + e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }

    @Override
    public Collection<Inasistencia> buscarTodos() {
        List<Inasistencia> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Inasistencia.class);
            criterio.addOrder(Order.asc("id"));
            lista = criterio.list();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    + e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        }
        
        return lista;
    }

    @Override
    public Collection<Inasistencia> inasistenciasDeHoy() {
        List<Inasistencia> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Query inasistencias = 
                    sesion.createQuery("FROM Inasistencia as i WHERE i.dia = current_date");
            lista = inasistencias.list();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    + e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        }
        return lista;
    }

    @Override
    public Collection<Inasistencia> inasistenciasDurante(DateTime inicio, DateTime fin) {
        List<Inasistencia> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Query inasistencias = 
                    sesion.createQuery("From Inasistencia as i Where i.dia between :inicio and :fin order by i.dia asc")
                            .setParameter("inicio", inicio)
                            .setParameter("fin", fin);
            lista = inasistencias.list();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    + e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return lista;
    }

    @Override
    public Collection<Inasistencia> inasistenciasMensualDelEmpleado(String cedula, int mes, int year) {
         List<Inasistencia> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Query asistenciasDelMesEnCurso = 
                    sesion.createQuery("From Inasistencia as i WHERE i.empleado.cedula = :cedula AND month(i.dia) = :mes"
                            + " AND year(i.dia) = :year")
                            .setParameter("cedula", cedula)
                            .setParameter("mes", mes)
                            .setParameter("year", year);                
            lista = asistenciasDelMesEnCurso.list();
            
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return lista;
    }

    @Override
    public Collection<Inasistencia> inasistenciasDeEmpleadoDurante(String cedula, 
            DateTime inicio, DateTime fin) {
        
        List<Inasistencia> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Query inasistencias = 
                    sesion.createQuery("FROM Inasistencia as i WHERE i.dia between :inicio and :fin "
                            + "and i.empleado.cedula = :cedula ORDER BY i.dia asc")
                            .setParameter("inicio", inicio)
                            .setParameter("fin", fin)
                            .setParameter("cedula", cedula);
            
            lista = inasistencias.list();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    + e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return lista;
    }
}