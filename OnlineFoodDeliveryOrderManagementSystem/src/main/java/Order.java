
public class Order {
    private int orderId;
    private String restaurantName;
    private String itemName;
    private double price;

    public Order(int orderId, String restaurantName, String itemName, double price) {
        this.orderId = orderId;
        this.restaurantName = restaurantName;
        this.itemName = itemName;
        this.price = price;
    }

    public int getOrderId() { return orderId; }
    public String getRestaurantName() { return restaurantName; }
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
