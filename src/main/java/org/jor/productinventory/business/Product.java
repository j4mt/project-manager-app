package org.jor.productinventory.business;

/**
 * Created by j4mt on 03/07/2016.
 */
public class Product extends Entity<String> {

    private String code;
    private String description;
    private double price;

    /**
     * Instantiates a new Product.
     *
     * @param code        the code
     * @param description the description
     * @param price       the price
     */
    public Product(String code, String description, double price) {

        super(code);
        this.code = code;
        this.description = description;
        this.price = price;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {

        return "\n" + "Code :\t\t\t\t\t" + this.getIdentifier() + "\n"
                + "Description :\t\t\t" + this.description + "\n"
                + "Price : \t\t\t\t" + this.price + "\n";
    }
}
