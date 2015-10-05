package com.muteam.thetask.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

import com.muteam.thetask.dao.*;
import com.muteam.thetask.model.Musician;

@Repository
public class MusicianRepositoryImpl implements MusicianRepository {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Musician> list() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Musician> musicianList = (List<Musician>) session.createCriteria(Musician.class).list();
        transaction.commit();
        session.close();
        return musicianList;
    }

    @Override
    public Musician getById(String id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Musician musician = (Musician) session.get(Musician.class, id);
        transaction.commit();
        session.close();
        return musician;
    }

    @Override
    public void save(Musician musician) {
        musician.setId(UUID.randomUUID().toString());
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(musician);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Musician musician) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(musician);
        transaction.commit();
    }

    @Override
    public void delete(String id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Musician musician = (Musician) session.load(Musician.class, id);
        session.delete(musician);
        transaction.commit();
        session.flush();
        session.close();
    }
}
