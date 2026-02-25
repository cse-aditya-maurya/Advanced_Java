import java.util.List;

public class OrderManager {

    private OrderDao dao;

    public OrderManager(OrderDao dao) {
        this.dao = dao;
    }

    public List<Order> fetchOrders() {
        return dao.getAllOrders();
    }

    public boolean addOrder(Order order) {
        dao.logAction("Order Placed");
        return dao.addOrder(order);
    }

    public boolean cancelOrder(int id) {
        dao.logAction("Order Cancelled");
        return dao.cancelOrder(id);
    }

    // Internal logic method
    protected String checkFestival() {
        return "Normal";
    }

    public double processOrder(Order order) {
        String type = checkFestival();
        if (type.equals("Festival Offer")) {
            return order.getPrice() * 0.8;
        }
        return order.getPrice() * 0.9;
    }

    public static double staticDiscount(double price) {
        return price * 0.9;
    }

    public String getDbInfo() {
        return dao.getDatabaseInfo();
    }
}
