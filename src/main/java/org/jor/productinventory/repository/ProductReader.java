package org.jor.productinventory.repository;

import org.jor.productinventory.business.Product;

import java.util.Collection;

/**
 * Created by j4mt on 04/07/16.
 */
public interface ProductReader {

    Product getProduct(String code);
    Collection<Product> getProducts();
}
