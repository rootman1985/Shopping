package com.shooping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rootman
 */
public class Client {

    private String login;
    private String fullName;
    private String mail;
    private String phoneNumber;
    private List<SelectedProduct> panier = new ArrayList<>();
    private double montantPanier = 0;

    public Client() {
    }

    public Client(String login, String fullName, String mail, String phoneNumber) {
        this.login = login;
        this.fullName = fullName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
    }

    public void addProduct(Product product, int quantity) {
        // vérification si le produit existe dans le panier alors
        // Incrementer la quantity si non ajouter

        if (product.getQuantity() < quantity) {
            System.out.println("Impossible de taiter cette transaction, Stock insuffisant");
            return;
        }

        boolean trouve = false;
        for (SelectedProduct selectedProduct : panier) {
            if (selectedProduct.getProduct().getCategory().equalsIgnoreCase(product.getCategory())
                    && product.getId() == selectedProduct.getProduct().getId()) {
                selectedProduct.setQuantity(selectedProduct.getQuantity() + quantity);
                trouve = true;
                break;
            }
        }
        if (!trouve)
            panier.add(new SelectedProduct(product, quantity));

        montantPanier += montantPanier + (product.getPrice() * quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    public void removeProduct(Product product) {
        // vérification si le produit existe dans le panier alors
        // Incrementation de la quantity du stock avec la quantité qui se trouve dans le panier
        // Supression de la ligne du panier
        // si non impossible de supprimer du panier le produit inexistant
        boolean trouve = false;
        for (SelectedProduct selectedProduct : panier) {
            if (selectedProduct.getProduct().getCategory().equalsIgnoreCase(product.getCategory())
                    && product.getId() == selectedProduct.getProduct().getId()) {
                product.setQuantity(product.getQuantity() + selectedProduct.getQuantity());
                panier.remove(selectedProduct);
                montantPanier = montantPanier - (product.getPrice() * selectedProduct.getQuantity());
                System.out.println("La supression du produit selectionner est effectif");
                trouve = true;
                break;
            }
        }
        if (!trouve)
            System.out.println("Le produit selectionner est introuvable !!!");
    }

    public void showPanier() {
        System.out.println("La liste des produits dans le panier sont : ");
        panier.forEach(selectedProduct ->
                System.out.println(selectedProduct.getProduct().toString() + " Quantity : " + selectedProduct.getQuantity())
        );
    }

    public double getMontantPanier() {
        return montantPanier;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<SelectedProduct> getPanier() {
        return panier;
    }

    public void setPanier(List<SelectedProduct> panier) {
        this.panier = panier;
    }

    @Override
    public String toString() {
        return "Client{" +
                "login='" + login + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
