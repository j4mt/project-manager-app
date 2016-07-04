package org.jor.productinventory.service;

import org.apache.log4j.Logger;
import org.jor.productinventory.business.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by j4mt on 03/07/16.
 */
public class ProductServiceImpl implements ProductService {

    static Logger log = Logger.getLogger(Logger.class.getName());

    // Composite collection
    //private ArrayList<Product> list;
    private Map<String, Product> products = new HashMap<>();


    /**
     * Add product void.
     *
     * @param product the product
     */
    public void addProduct(Product product) throws ProductServiceException{


        if (products.containsKey(product.getCode()))
            throw new ProductServiceException("\n\nProduct already added!");

        products.put(product.getCode(), product);
    }

    /**
     * Delete product boolean.
     *
     * @param code the code
     * @return the boolean
     */
    public boolean deleteProduct(String code){
        return products.remove(code) != null;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getProductsSize() {
        return this.products.size();
    }

    public Collection<Product> getProducts(){
        return products.values();
    }

}
