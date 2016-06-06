package com.wr.unit.creator;

import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by wangrui on 2015/5/14.
 */
public class HibernateLoad {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration =  new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.addPackage("com.wr.unit");
            return configuration.addAnnotatedClass(Persion.class).buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] argv){
        System.out.println();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aaa");
        EntityManager em = emf.createEntityManager();
        Persion persion = new Persion();
        persion.setName("wangrui");
        persion.setAddress("daqi");
        persion.setAge(22);
        persion.setSr(new Date());
        try{
            em.getTransaction().begin();
            em.persist(persion);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }


        em.close();
        emf.close();
                /**
        Session session = HibernateLoad.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Persion persion = new Persion();
        persion.setName("wangrui");
        persion.setAddress("daqi");
        persion.setAge(22);
        persion.setSr(new Date());

        session.save(persion);


        session.getTransaction().commit();
**/
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
