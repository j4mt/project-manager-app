package org.jor.productinventory.loader;

import org.jor.productinventory.business.Product;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by j4mt on 04/07/16.
 */
public class ProductDataLoader implements DataLoader<Product, String> {

    @Override
    public Map<String, Product> loadData() {

        Map<String, Product> products = new HashMap<>();

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("products.txt");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;

            while ((line = in.readLine()) != null) {

                String[] columns = line.split("\\|");
                products.put(columns[0], new Product(columns[0], columns[1], Double.parseDouble(columns[2])));
            }

        } catch (Exception e) {

            throw new DataLoaderException(e);
        }

        return products;
    }
}
