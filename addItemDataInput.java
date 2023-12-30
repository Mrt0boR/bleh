import java.util.Scanner;
public class addItemDataInput {

public void addItem(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter Product ID:");
        int id = scan.nextInt();
        scan.nextLine(); // consume the newline

        System.out.println("Enter SKU:");
        String sku = scan.nextLine();

        System.out.println("Enter Category:");
        String category = scan.nextLine();

        System.out.println("Enter Description:");
        String description = scan.nextLine();

        System.out.println("Enter Price:");
        int price = scan.nextInt();

    // Create a new shopItem with the user-input attributes
    shopItem newItem = new shopItem(id, sku, category, description, price);



    // Call the method in SQLDAO to add the new product to the database
    SQLDAO dao = new SQLDAO();
        try {

            boolean added = dao.addProduct(newItem);

        if (added) {

            System.out.println("Product added successfully!");
        } else {

            System.out.println("Failed to add the product.");
        }
    } catch(Exception e)

    {
        System.out.println("Error adding product: " + e.getMessage());
    }

}


}
