package org.jor.productinventory;

import org.apache.log4j.Logger;
import org.jor.productinventory.business.Product;
import org.jor.productinventory.loader.ProductDataLoader;
import org.jor.productinventory.repository.HashMapRepository;
import org.jor.productinventory.service.ProductService;
import org.jor.productinventory.service.ProductServiceImpl;

import java.util.Scanner;

/**
 * Created by j4mt on 03/07/16.
 */
public class MainApp {

    /**
     * The constant logger.
     */
    final static Logger logger = Logger.getLogger(MainApp.class.getName());

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ProductService productService = new ProductServiceImpl(new HashMapRepository<>(new ProductDataLoader()));


        System.out.println("\n\n\t\t\t| *** Welcome to j4mt's product manager application *** |");

        // product input vars
        String productCode;
        String description;
        double price;

        // menu item
        String menuItem;

        printMenuOptions();
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter menu item :");
        menuItem = in.nextLine();

        logger.info("\nEntered menu selection : " + menuItem);

        while (!menuItem.equalsIgnoreCase("exit")) {

            menuItem = menuItem.toLowerCase();

            switch (menuItem) {

                case "add product":
                    System.out.print("\n" + "Please enter product code : ");
                    productCode = in.nextLine();
                    System.out.print("\n" + "Please enter description : ");
                    description = in.nextLine();
                    System.out.print("\n" + "Please enter price : ");
                    price = in.nextDouble();

                    Product p = new Product(productCode, description, price);
                    try {

                        productService.createProduct(p);
                    } catch (Exception e) {

                        System.out.println("\nProduct already exists : " + productCode);
                    }

                    logger.info("\nAdded product : " + p.toString() + "to list");
                    break;


                case "delete product":

                    System.out.print("\n" + "Please enter product code : ");
                    productCode = in.next();
                    try {

                        productService.deleteProduct(productCode);

                    } catch (Exception e) {

                        System.out.println("\nNo such product exits : " + productCode);
                    }

                    logger.info("\nDeleted product : " + productCode + "from list");
                    break;


                case "list products":

                    logger.info("\nListing products : ");

                    for (Product product : productService.getProducts()) {

                        System.out.println(product.toString());
                    }

                    break;
            }

            printMenuOptions();
            in = new Scanner(System.in);
            System.out.print("\n" + "Please enter menu item : ");
            menuItem = in.nextLine();
        }


    }

    /**
     * Print menu options.
     */
    public static void printMenuOptions() {

        System.out.println(
                "\n\n"
                        + "| ---- Menu ----| " + "\n"
                        + "\n"
                        + "  Type options " + "\n"
                        + "\n"
                        + "Add Product"
                        + "\n"
                        + "Delete Product"
                        + "\n"
                        + "List Products"
                        + "\n"
                        + "Exit");
        logger.info("Displaying menu");
    }
}
