package org.jor.productinventory.repository;

import org.apache.log4j.Logger;
import org.jor.productinventory.business.Product;
import org.jor.productinventory.service.ProductServiceException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j4mt on 04/07/16.
 */
public class ProductServiceTextFileIOImpl implements ProductDAO {

    static Logger log = org.apache.log4j.Logger.getLogger(Logger.class.getName());

    private Map<String, Product> products;
    private Path productsPath = null;
    private File productsFile = null;
    private String FIELD_SEP = "\t";

    public ProductServiceTextFileIOImpl() {

        productsPath = Paths.get("products.txt");
        productsFile = productsPath.toFile();
        this.getProducts();
    }


    public Product getProduct(String code) {
        return products.get(code);
    }

    @Override
    public Collection<Product> getProducts() {

         //Already read products
        if (products.isEmpty())
            return products.values();

        products = new HashMap<>();

        // don't throw file not found exception
        if (Files.exists(productsPath))
        {
            try (BufferedReader in =
                         new BufferedReader(
                                 new FileReader(productsFile)))
            {
                // read all products stored in the file and into the collection
                String line = in.readLine();
                while(line != null)
                {
                    String[] columns = line.split(FIELD_SEP);
                    String code = columns[0];
                    String description = columns[1];
                    String price = columns[2];

                    Product p = new Product(
                            code, description, Double.parseDouble(price));

                    products.put(code,p);

                    line = in.readLine();
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
                return null;
            }
        }
        //return (Collection<Product>) products;
        return products.values();
    }

    @Override
    public int getProductsSize() {
        return products.size();
    }

    @Override
    public void addProduct(Product p) {
        if (products.containsKey(p.getCode()))
            throw new ProductServiceException("Product already added!");

        products.put(p.getCode(), p);

    }

    @Override
    public boolean deleteProduct(String code) {
        return products.remove(code) != null;
    }


    public boolean updateProduct(Product p) {
        Product existing = products.get(p.getCode());
        if(existing != null){
            products.put(p.getCode(), p);
            log.info("\nUpdated product : "
                    + "\n" + existing.toString()
                    + "\n : with :"
                    + "\n" + p.toString());
        }
        return existing != null;
    }
}
