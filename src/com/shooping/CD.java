package com.shooping;
/**
 * @author rootman
 *
 */
public class CD extends Product {

    private String album;
    private String chansons;
    private double price = 10;
    private int quantity = 3;

    public CD() {
        super();
    }

    public CD(int id, String album, String chansons) {
        super(id);
        this.album = album;
        this.chansons = chansons;
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
        return "CD";
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getChansons() {
        return chansons;
    }

    public void setChansons(String chansons) {
        this.chansons = chansons;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CD{" +
                "id='" + getId() + '\'' +
                "album='" + album + '\'' +
                ", chansons='" + chansons + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
