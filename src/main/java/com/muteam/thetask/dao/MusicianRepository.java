package com.muteam.thetask.dao;

import java.util.List;

import  com.muteam.thetask.model.Musician;

public interface MusicianRepository {

    public abstract List<Musician> list();

    public abstract Musician getById(String id);

    public abstract void save(Musician musician);

    public abstract void update(Musician musician);

    public abstract void delete(String id);
}
