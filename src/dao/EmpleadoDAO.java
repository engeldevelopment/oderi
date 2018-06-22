package dao;

import modelo.Empleado;
import java.util.*;
import nicon.notify.core.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import hibernate.HibernateUtil;
import nullObjects.NullEmpleado;

public class EmpleadoDAO {

    private Session sesion;
    
    public void guardar(Empleado empleado){
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(empleado);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
             Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }
    
    public Empleado buscar(String cedula){
        Empleado empleado = new Empleado();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Empleado.class);
            criterio.add(Restrictions.eq("cedula", cedula));
            if (criterio.list().isEmpty())
                return new NullEmpleado();
            empleado = (Empleado) criterio.list().get(0);
        } catch (HibernateException e) {
             Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        
        return empleado;
    }
    
    public void actualizar(Empleado empleado){
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(empleado);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }
    
    public void eliminar(Empleado empleado){
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(empleado);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
            Notification.windowMessage(null, "Disculpe!", "Ha ocurrido un Error:"
                    +e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
    }
    
    public Collection<Empleado> buscarTodos(){
        List<Empleado> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Empleado.class);
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
    
    public Collection<Empleado> buscarEmpleadoPor(String cedula, String departamento){
        List<Empleado> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Query empleadoPorDepartamento = 
                    sesion.createQuery("From Empleado e Where e.cedula like :cedula "
                            + "and e.departamento.nombre = :departamento")
                    .setParameter("cedula", cedula+"%")
                    .setParameter("departamento", departamento);
            lista = empleadoPorDepartamento.list();
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
