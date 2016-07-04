package org.jor.productinventory.business;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by j4mt on 03/07/16.
 */
public class ProductTest {

    /**
     * ProductTest 1 create new product.
     */
    @org.testng.annotations.Test
    public void test_1_CreateNewProduct() {

        Product p1 = new Product("12345678", "Glass Hammer", 50.99);
        Product p2 = new Product("12345679", "Steel Hammer", 5.99);

        assertEquals(p1.getPrice(), 50.99);
        assertEquals(p2.getPrice(), 5.99);
    }

    /**
     * ProductTest 2 product equals.
     */
    @org.testng.annotations.Test
    public void test_2_ProductEquals() {

        Product p1 = new Product("12345678", "Glass Hammer", 50.99);

        assertFalse(p1.equals(new Product("12345679", "Steel Hammer", 5.99)));
        assertTrue(p1.equals(new Product("12345678", "Glass Hammer", 50.99)));
    }
}
