package org.jor.productinventory.service;

import org.apache.log4j.Logger;
import org.jor.productinventory.business.Product;
import org.jor.productinventory.repository.ProductDAO;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j4mt on 04/07/16.
 */
public class ProductServiceTextFileIOImpl implements ProductDAO {

    static Logger log = org.apache.log4j.Logger.getLogger(Logger.class.getName());

    private Map<String, Product> products = new HashMap<>();
    private Path productsPath = null;
    private File productsFile = null;

    public ProductServiceTextFileIOImpl(Path productsPath, File productsFile) {
        this.products = (Map<String, Product>) this.getProducts();
        this.productsPath = productsPath;
        this.productsFile = productsFile;
    }

    @Override
    public Product getProduct(String code) {
        return null;
    }

    @Override
    public Collection<Product> getProducts() {
        return null;
    }

    @Override
    public boolean addProduct(Product p) {
        return false;
    }

    @Override
    public boolean updateProduct(Product p) {
        return false;
    }

    @Override
    public boolean deleteProduct(Product p) {
        return false;
    }
}
