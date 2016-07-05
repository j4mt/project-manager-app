package org.jor.productinventory.repository;

import org.jor.productinventory.business.Entity;

import java.util.Collection;

/**
 * Created by j4mt on 04/07/16.
 *
 * @param <T>  the type parameter
 * @param <Pk> the type parameter
 */
public interface Repository<T extends Entity<Pk>, Pk> {

    /**
     * Find t.
     *
     * @param key the key
     * @return the t
     */
    T find(Pk key);

    /**
     * Find all collection.
     *
     * @return the collection
     */
    Collection<T> findAll();

    /**
     * Create.
     *
     * @param entity the entity
     */
    void create(T entity);

    /**
     * Update.
     *
     * @param entity the entity
     */
    void update(T entity);

    /**
     * Delete boolean.
     *
     * @param entity the entity
     * @return the boolean
     */
    boolean delete(T entity);

    /**
     * Delete boolean.
     *
     * @param key the key
     * @return the boolean
     */
    boolean delete(Pk key);

    /**
     * Exists boolean.
     *
     * @param entity the entity
     * @return the boolean
     */
    boolean exists(T entity);

    /**
     * Size int.
     *
     * @return the int
     */
    int size();
}
