package org.jor.productinventory.service;

import org.jor.productinventory.business.Product;

import java.util.Collection;

/**
 * Created by j4mt on 03/07/16.
 */
public interface ProductService {

    /**
     * Find product product.
     *
     * @param code the code
     * @return the product
     */
    Product findProduct(String code);

    /**
     * Create product.
     *
     * @param product the product
     */
    void createProduct(Product product);

    /**
     * Update product.
     *
     * @param product the product
     */
    void updateProduct(Product product);

    /**
     * Delete product boolean.
     *
     * @param code the code
     * @return the boolean
     */
    boolean deleteProduct(String code);

    /**
     * Gets products.
     *
     * @return the products
     */
    Collection<Product> getProducts();

    /**
     * Gets products size.
     *
     * @return the products size
     */
    int getProductsSize();
}
