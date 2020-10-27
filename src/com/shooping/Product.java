package com.shooping;
/**
 * @author rootman
 *
 */
public abstract class Product {

    // On va considérer l'id du produit comme clé primaire auto-incrementale, donc unique
    private int id;
    abstract double getPrice();
    public abstract int getQuantity();
    abstract String getCategory();
    abstract void setQuantity(int quantity);

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
