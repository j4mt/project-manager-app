package org.jor.productinventory.loader;

import org.jor.productinventory.business.Entity;

import java.util.Map;

/**
 * Created by j4mt on 04/07/16.
 */
public interface DataLoader<T extends Entity, Pk> {

    Map<Pk, T> loadData();
}
