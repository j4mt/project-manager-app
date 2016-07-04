package org.jor.productinventory.service;

import org.jor.productinventory.business.Product;

import java.util.Collection;

/**
 * Created by j4mt on 03/07/16.
 */
public interface ProductService {

    /**
     * Add product boolean.
     *
     * @param product the product
     * @return the boolean
     */

    void addProduct(Product product) throws ProductServiceException;

    /**
     * Delete product boolean.
     *
     * @param code the code
     * @return the boolean
     */
    boolean deleteProduct(String code);


    /**
     * List products.
     */
    Collection<Product> getProducts();

    /**
     * Gets size.
     *
     * @return the size
     */
    int getProductsSize();
}
