package com.muteam.analysis.project.dao;

import java.util.List;

import com.muteam.analysis.project.model.Product;

public interface ProductRepository {

    public abstract List<Product> list();

    public abstract Product getById(String id);

    public abstract void save(Product product);

    public abstract void update(Product product);

    public abstract void delete(String id);
}
