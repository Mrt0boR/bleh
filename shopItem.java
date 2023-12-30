public class shopItem {

    int ID;
    public String SKU;
    public String Category;
    public String Description;
    public int Price;

    public shopItem(int ID, String SKU, String Category, String Description, int Price) {

        this.ID = ID;
        this.SKU = SKU;
        this.Description = Description;
        this.Category = Category;
        this.Price = Price;
    }


    //Getters and Setters for proper interaction between the Constructor and DAO
    public int getID() {
        return ID;
    }

    public String getSKU() {
        return SKU;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getPrice() {
        return Price;
    }

    @Override
    public String toString() {
        return "[ID : " + ID +
                " | SKU : '" + SKU +
                "' | Category : '" + Category +
                "' | Description : '" + Description +
                "' | Price : '" + Price + "']\n";
    }
}










