import java.util.List;

public class OrderDao {

    public List<Order> getAllOrders() {
        throw new UnsupportedOperationException("DB call");
    }

    public boolean addOrder(Order order) {
        return true;
    }

    public boolean cancelOrder(int orderId) {
        return true;
    }

    public final String getDatabaseInfo() {
        return "DB:MySQL@localhost";
    }

    public void logAction(String message) {
        System.out.println(message);
    }
}
