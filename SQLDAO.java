import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class SQLDAO {

    public Connection sqlInit() throws SQLException {
        String connectionURL = "jdbc:sqlite:/Users/james/Documents/IntelliJ/SQLConnection/src/Main.db";
        return DriverManager.getConnection(connectionURL);
    }

    public List<shopItem> selectallstatement() {

        /*
        initialise an array list so that the items can be
        logged into the system memory and outputted when the
        list is converted to a string and called upon in the Main method
        */


        List<shopItem> shopItemsArrayList = new ArrayList<>();

        //SQL statement for the selecallstatement method
        String select = "SELECT * FROM shopItems";

        //declaring objects to the Java.sql methods
        Connection dbconnection;
        PreparedStatement selectallstatement;
        ResultSet resultSet;



        try {
            //db connection object is = to the conenction establishment in the sqlInit method
            dbconnection = sqlInit();

            //preparedsattement object is linked to the prepaered select all sql statement.
            selectallstatement = dbconnection.prepareStatement(select);
            resultSet = selectallstatement.executeQuery();

            /*
            the while loop iterates through the result set creating strings associated with each item
            using the framework from the shopItemsconstructor class
             */

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String SKU = resultSet.getString("SKU");
                String Category = resultSet.getString("Category");
                String Description = resultSet.getString("Description");
                int Price = resultSet.getInt("Price");

                shopItem selectallshopitems = new shopItem(ID,SKU, Category, Description, Price);

                shopItemsArrayList.add(selectallshopitems);
            }
            resultSet.close();
            selectallstatement.close();
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException("connection error", e);
        }
        return shopItemsArrayList;
    }


    public void productSearch(int productID) throws SQLException {

        String idSearchStatement = "SELECT * FROM shopItems WHERE ID = " + productID;

        //declaring objects to the Java.sql methods
        Connection dbconnection = null;

        PreparedStatement idSearch = null;

        ResultSet resultSet = null;


        try {

            //sql to handle search
            dbconnection = sqlInit();

            idSearch = dbconnection.prepareStatement(idSearchStatement);

            resultSet = idSearch.executeQuery();

            while (resultSet.next()){

                int ID = resultSet.getInt("ID");

                String SKU = resultSet.getString("SKU");

                String Category = resultSet.getString("Category");

                String Description = resultSet.getString("Description");

                int Price = resultSet.getInt("Price");

                shopItem employeeidsearch = new shopItem(ID, SKU, Category, Description, Price);

                System.out.println(employeeidsearch);


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


    public boolean addProduct(shopItem item) throws SQLException{

        Connection dbconnection = null;

        Statement statement = null;



        String insertStatement = "INSERT INTO shopItems (ID, SKU, Category, Description, Price) VALUES " +
                "(" + item.getID() + ", '" + item.getSKU() + "','" + item.getCategory() + "','" + item.getDescription() + "'," + item.getPrice() + ");";

        boolean ok = true;

        try {

            dbconnection = sqlInit();

            statement = dbconnection.createStatement();

            //execute insert statement
            statement.executeUpdate(insertStatement);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (statement != null)
                statement.close();
        }
        if (dbconnection != null){
            dbconnection.close();
        }

        return ok;
    }


}




