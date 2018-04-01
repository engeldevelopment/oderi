package dao;

import java.util.Collection;

public interface IDAO<T> {
    
    public void guardar(T t);
    public T buscar(Object filtro);
    public void actualizar(T t);
    public void eliminar(T t);
    public Collection<T> buscarTodos();
}
