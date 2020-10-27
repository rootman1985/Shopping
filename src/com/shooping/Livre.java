package com.shooping;
/**
 * @author rootman
 *
 */
public class Livre extends Product {

    private String name;
    private double price = 15;
    private int quantity = 2;

    public Livre() {
        super();
    }

    public Livre(int id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    String getCategory() {
        return "Livre";
    }

    @Override
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
