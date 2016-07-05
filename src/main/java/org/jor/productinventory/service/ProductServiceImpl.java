package org.jor.productinventory.service;

import org.apache.log4j.Logger;
import org.jor.productinventory.business.Product;
import org.jor.productinventory.repository.HashMapRepository;
import org.jor.productinventory.repository.Repository;

import java.util.Collection;


/**
 * Created by j4mt on 03/07/16.
 */
public class ProductServiceImpl implements ProductService {

    /**
     * The Log.
     */
    static Logger log = Logger.getLogger(Logger.class.getName());

    private Repository<Product, String> repository;


    /**
     * Instantiates a new Product service.
     *
     * @param repository the repository
     */
    public ProductServiceImpl(Repository<Product, String> repository) {

        this.repository = repository;
    }

    /**
     * Instantiates a new Product service.
     */
    public ProductServiceImpl() {

        repository = new HashMapRepository<>();
    }


    @Override
    public Product findProduct(String code) {

        return repository.find(code);
    }

    public void createProduct(Product product) throws ProductServiceException {

        if (repository.exists(product))
            throw new ProductServiceException("\n\nProduct already added!");

        repository.create(product);
    }

    @Override
    public void updateProduct(Product product) {

        if (!repository.exists(product))
            throw new ProductServiceException("\n\nProduct not already added!");

        repository.update(product);
    }

    public boolean deleteProduct(String code){

        return repository.delete(code);
    }

    public int getProductsSize() {

        return repository.size();
    }

    public Collection<Product> getProducts(){

        return repository.findAll();
    }

}
