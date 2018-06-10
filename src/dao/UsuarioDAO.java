package dao;

import seguridad.Usuario;
import nullObjects.NullUsuario;
import java.util.*;
import nicon.notify.core.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import hibernate.HibernateUtil;

public class UsuarioDAO implements IServicioDeUsuario {
    
    private Session sesion;

    public UsuarioDAO(Session sesion) {
        this.sesion = sesion;
    }
    
    public UsuarioDAO() {
        
    }
    
    @Override
    public void guardar(Usuario usuario) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(usuario);
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
    public Usuario buscar(Object nombre) {
        Usuario usuario = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Usuario.class);
            criterio.add(Restrictions.eq("nombre", nombre));
            if (criterio.list().isEmpty())
                return new NullUsuario();
            usuario = (Usuario) criterio.list().get(0);
        } catch (HibernateException e) {
            Notification.windowMessage(null, 
                    "Disculpe!", 
                    "Ocurrió un error "+e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return usuario;
    }

    @Override
    public void actualizar(Usuario usuario) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(usuario);
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
    public void eliminar(Usuario usuario) {
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(usuario);
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
    public Collection<Usuario> buscarTodos() {
        List<Usuario> lista = new ArrayList<>();
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            Criteria criterio = sesion.createCriteria(Usuario.class);
            criterio.addOrder(Order.asc("id"));
            lista = criterio.list();
        } catch (HibernateException e) {
            Notification.windowMessage(null, 
                    "Disculpe!", 
                    "Ocurrió un error "+e.getMessage(), 
                    NiconEvent.NOTIFY_ERROR);
        } finally {
            sesion.close();
        }
        return lista;
    }
}
