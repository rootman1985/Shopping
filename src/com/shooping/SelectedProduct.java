package com.shooping;
/**
 * @author rootman
 *
 */
public class SelectedProduct {
    private Product product;
    private int quantity;

    public SelectedProduct() {
    }

    public SelectedProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
