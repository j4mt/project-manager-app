package org.jor.productinventory.repository;

import org.jor.productinventory.business.Product;

/**
 * Created by j4mt on 04/07/16.
 */
public interface ProductWriter {

    boolean addProduct(Product p);
    boolean updateProduct(Product p);
    boolean deleteProduct(Product p);
}
