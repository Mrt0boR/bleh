import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
public class MenuList {

    public void menuOptions() throws SQLException {
        Scanner scan = new Scanner(System.in);
        String selection;

        do {
            // menu option readout
            System.out.println("FOOD STORE");
            System.out.println("-----------");
            System.out.println("[1] List all Products");
            System.out.println("[2] Search by Product ID");
            System.out.println("[3] Add a new Product");
            System.out.println("[4] Update a Product by ID");
            System.out.println("[5] Delete a Product by ID");
            System.out.println("[6] Exit");

            // take user input
            selection = scan.nextLine();

            //initialise DAO for interface with each switch statement
            SQLDAO dao = new SQLDAO();
            // 5 branch switch
            switch (selection) {
                case "1":
                    List<shopItem> selectallitems = dao.selectallstatement();
                    System.out.println(selectallitems);
                    System.out.println();
                    break;

                case "2":

                    System.out.println("\nEnter Product ID");
                    int productID = scan.nextInt();
                    dao.productSearch(productID);


                    break;

                case "3":
                    addItemDataInput addItemData = new addItemDataInput();
                    addItemData.addItem();
                    break;

                case "4":
                    // UPDATE DAO
                    break;

                case "5":
                    // DELETE DAO
                    break;

            }

        } while (!selection.equals("6"));

        // Close the scanner when done
        scan.close();
    }
}