package app.dao;

import app.exception.UnexpectedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

abstract class BaseDao<T extends Serializable> {
    @Autowired
    protected SessionFactory sessionFactory;
    protected Class<T> type;


    public T getById(Integer id) {
        return (T) getCurrentSession().get(type, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) getCurrentSession().createQuery("from " + type.getName()).list();
    }

    public void create(T entity) {
        getCurrentSession().save(entity);
    }

    abstract void update(Integer id, T newEntity) throws UnexpectedException;

    public void deleteById(Integer id) throws UnexpectedException {
        T entity = getCurrentSession().get(type, id);
        if (entity == null)
            throw new UnexpectedException("User to delete does not exist");
        getCurrentSession().delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
