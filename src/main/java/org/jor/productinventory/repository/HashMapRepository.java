package org.jor.productinventory.repository;

import org.jor.productinventory.business.Entity;
import org.jor.productinventory.loader.DataLoader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j4mt on 04/07/16.
 *
 * @param <T>  the type parameter
 * @param <Pk> the type parameter
 */
public class HashMapRepository<T extends Entity<Pk>, Pk> implements Repository<T, Pk> {

    private Map<Pk, T> storage;


    //_________________________________________________________________________

    /**
     * Instantiates a new Hash map repository.
     */
    public HashMapRepository() {

        storage = new HashMap<>();
    }

    /**
     * Instantiates a new Hash map repository.
     *
     * @param dataLoader the data loader
     */
    public HashMapRepository(DataLoader<T, Pk> dataLoader) {

        storage = dataLoader.loadData();
    }


    //_________________________________________________________________________

    @Override
    public T find(Pk key) {

        return storage.get(key);
    }

    @Override
    public Collection<T> findAll() {

        return storage.values();
    }

    @Override
    public void create(T entity) {

        storage.put(entity.getIdentifier(), entity);
    }

    @Override
    public void update(T entity) {

        storage.put(entity.getIdentifier(), entity);
    }

    @Override
    public boolean delete(T entity) {

        return delete(entity.getIdentifier());
    }

    @Override
    public boolean delete(Pk key) {

        return storage.remove(key) != null;
    }

    @Override
    public boolean exists(T entity) {

        return storage.containsKey(entity.getIdentifier());
    }

    @Override
    public int size() {

        return storage.size();
    }
}
