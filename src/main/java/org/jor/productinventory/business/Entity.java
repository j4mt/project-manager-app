package org.jor.productinventory.business;

/**
 * Created by j4mt on 04/07/16.
 *
 * @param <T> the type parameter
 */
public abstract class Entity<T> {

    private T identifier;

    /**
     * Instantiates a new Entity.
     *
     * @param identifier the identifier
     */
    public Entity(T identifier) {

        this.identifier = identifier;
    }

    /**
     * Gets identifier.
     *
     * @return the identifier
     */
    public T getIdentifier() {

        return identifier;
    }

    /**
     * Sets identifier.
     *
     * @param identifier the identifier
     */
    public void setIdentifier(T identifier) {

        this.identifier = identifier;
    }


    @Override
    public boolean equals(Object o) {

        return this == o || o != null && getClass() == o.getClass() && identifier.equals(((Entity<?>) o).identifier);

    }

    @Override
    public int hashCode() {

        return identifier.hashCode();
    }
}
