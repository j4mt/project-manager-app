package org.jor.productinventory.service;

import org.jor.productinventory.business.Product;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by j4mt on 04/07/16.
 */
public class ProductServiceTest {

    /**
     * ProductServiceTest 1 add new product to list.
     */
    @org.testng.annotations.Test
    public void test_1_AddNewProductToList() {

        ProductService productService = new ProductServiceImpl();

        productService.createProduct(new Product("12345678", "Glass Hammer", 50.99));
        productService.createProduct(new Product("12345679", "Steel Hammer", 5.99));

        assertEquals(productService.getProductsSize(), 2);
    }

    @org.testng.annotations.Test
    public void test_2_deleteProduct() {

        ProductService productService = new ProductServiceImpl();

        productService.createProduct(new Product("12345678", "Glass Hammer", 50.99));
        productService.createProduct(new Product("12345679", "Steel Hammer", 5.99));

        assertEquals(productService.getProductsSize(), 2);

        productService.deleteProduct("12345678");

        assertEquals(productService.getProductsSize(), 1);
    }

    @org.testng.annotations.Test
    public void test_3_addExistingProduct() {

        ProductService productService = new ProductServiceImpl();

        productService.createProduct(new Product("12345678", "Glass Hammer", 50.99));

        try {

            productService.createProduct(new Product("12345678", "Glass Hammer", 50.99));
            fail();

        } catch (Exception e) {

            // expected path...
        }
    }
}
