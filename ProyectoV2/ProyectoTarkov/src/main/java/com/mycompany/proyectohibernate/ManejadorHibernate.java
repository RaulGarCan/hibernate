package com.mycompany.proyectohibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Query;
import java.io.Serializable;

public class ManejadorHibernate {
    private Configuration configuration;
    private SessionFactory sessionFactory;
    private Session session;
    public ManejadorHibernate(String persistFile){
        configuration = new Configuration();
        configuration.configure(persistFile);
    }
    public void addClass(Class c){
        // Añade una clase al manejador
        configuration.addAnnotatedClass(c);
    }
    public void initSession(){
        // Inicializa la sesión (necesario cada vez que se añade una clase nueva)
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    public void beginTransaction(){
        // Inicia la transacción
        session.beginTransaction();
    }
    public void save(Object o) {
        // Guarda un objeto en la BD
        session.save(o);
    }
    public Object read(Class clase, Object pk){
        // Lee el objeto de la clase que tenga la pk introducida
        return session.get(clase,(Serializable) pk);
    }
    public void update(Object o){
        // Actualiza un objeto en la BD
        session.update(o);
    }
    public void remove(Object o){
        // Borra un objeto de la BD
        session.remove(o);
    }
    public void saveOrUpdate(Object o){
        // Guarda un objeto en la BD o, si existe, lo actualiza
        session.saveOrUpdate(o);
    }
    public Query querySQL(String consulta){
        // Devuelve el resultado de la consulta SQL
        return session.createQuery(consulta);
    }
    public void commit(){
        // Realiza un commit de la transacción
        session.getTransaction().commit();
    }
}
