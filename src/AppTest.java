import com.shooping.CD;
import com.shooping.Client;
import com.shooping.Livre;
import com.shooping.Product;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.util.Arrays.asList;

/**
 * @author rootman
 */
public class AppTest {

    public static void main(String[] args) {
        Client client = new Client("login", "fullName", "mail", "phoneNumber");

        Product livre1 = new Livre(1, "Livre 1");
        Product livre2 = new Livre(2, "Livre 2");
        Product cd1 = new CD(3, "Album", "chanson1, chanson2, chanson3");

        List<Product> products = asList(livre1, livre2, cd1);

        Scanner input = new Scanner(System.in);
        boolean dontExit = true;

        do {
            System.out.println("|==============================================================================|");
            System.out.println("|==================================MENU========================================|");
            System.out.println("|==============================================================================|");
            System.out.println("|                                                                              |");
            System.out.println("|                          1 Afficher les produits disponibles                 |");
            System.out.println("|                          2 Ajouter un produit dans le panier                 |");
            System.out.println("|                          3 Supprimer un produit du panier                    |");
            System.out.println("|                          4 Afficher les produits du panier                   |");
            System.out.println("|                          5 Afficher le montant de mon panier                 |");
            System.out.println("|                          6 Quitter                                           |");
            System.out.println("|==============================================================================|");
            System.out.println("|==============================================================================|");
            try {
                System.out.println("");
                System.out.println("");
                System.out.println("Please enter your chose  : ");
                int inputUser = Integer.parseInt(input.next());


                switch (inputUser) {
                    case 1:
                        System.out.println("|=================================================================================================|");
                        System.out.println("|==================>                          1 Afficher les produits disponibles                 |");
                        System.out.println("|=================================================================================================|");
                        showProducts(products);
                        break;
                    case 2:
                        System.out.println("|=================================================================================================|");
                        System.out.println("|==================>                          2 Ajouter un produit dans le panier                               |");
                        System.out.println("|=================================================================================================|");
                        addProductToBasket(products, client, input);
                        break;
                    case 3:
                        System.out.println("|=================================================================================================|");
                        System.out.println("|==================>                          3 Supprimer un produit du panier                    |");
                        System.out.println("|=================================================================================================|");
                        removeProductFromBasket(products, client, input);
                        break;
                    case 4:
                        System.out.println("|=================================================================================================|");
                        System.out.println("|==================>                          4 Afficher les produits du panier                   |");
                        System.out.println("|=================================================================================================|");
                        showProductsOnBasket(client);
                        break;
                    case 5:
                        System.out.println("|=================================================================================================|");
                        System.out.println("|==================>                          5 Afficher le montant du panier                     |");
                        System.out.println("|=================================================================================================|");
                        getMontantPanier(client);
                        break;
                    case 6:
                        System.out.println("|=================================================================================================|");
                        System.out.println("|==================>                          6 Quitter                                           |");
                        System.out.println("|=================================================================================================|");
                        dontExit = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("The entered value is unrecognized!!!");
            }

        }
        while (dontExit);
    }

    public static void showProducts(List<Product> products) {
        products
                .forEach(product -> System.out.println(product.toString()));
    }

    public static void addProductToBasket(List<Product> products, Client client, Scanner input) {
        System.out.println("=====================================================================");
        System.out.println("===========Choisissez  l'id du produit a ajouter : ================");
        System.out.println("=====================================================================");
        showProducts(products);
        int productId = input.nextInt();
        Optional<Product> result = products.stream().filter(product -> product.getId() == productId).findFirst();
        if (result.isPresent()) {
            Product product = result.get();
            System.out.println("Choisissez  la quantity du produit et qui soit égal ou inférieur à : " + product.getQuantity());
            int quantity = input.nextInt();
            if (quantity <= product.getQuantity()) {
                client.addProduct(product, quantity);
            } else {
                System.out.println("La quantité saisie est incorrect!!!, transaction annulée");
            }

        }
    }

    public static void removeProductFromBasket(List<Product> products, Client client, Scanner input) {
        if (client.getPanier().isEmpty()) {
            System.out.println("===========Aucun article dans le panier!!!");
            return;
        }
        System.out.println("=====================================================================");
        System.out.println("===========Choisissez  l'id du produit a supprimer : ================");
        System.out.println("=====================================================================");
        showProductsOnBasket(client);
        int productId = input.nextInt();
        Optional<Product> result = products.stream().filter(product -> product.getId() == productId).findFirst();
        if (result.isPresent()) {
            client.removeProduct(result.get());
        } else {
            System.out.println("Operation impossible, produit indisponible!!!");
        }
    }

    public static void showProductsOnBasket(Client client) {
        if (client.getPanier().isEmpty()) {
            System.out.println("===========Aucun article dans le panier!!!");
            return;
        }
        client.showPanier();
    }

    public static void getMontantPanier(Client client) {
        System.err.println("Le montant du pannier est : " + client.getMontantPanier());
    }


}
