import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class OrderManagerTest {

    // 1. Fetching all orders
    @Test
    void testFetchAllOrders() {
        OrderDao dao = mock(OrderDao.class);
        List<Order> mockOrders = List.of(new Order(1, "KFC", "Burger", 100));

        when(dao.getAllOrders()).thenReturn(mockOrders);

        OrderManager manager = new OrderManager(dao);
        List<Order> result = manager.fetchOrders();

        assertEquals(1, result.size());
        verify(dao).getAllOrders();
    }

    // 2. Adding order
    @Test
    void testAddOrder() {
        OrderDao dao = mock(OrderDao.class);
        Order order = new Order(2, "Pizza Hut", "Pizza", 200);

        when(dao.addOrder(order)).thenReturn(true);

        OrderManager manager = new OrderManager(dao);
        boolean result = manager.addOrder(order);

        assertTrue(result);
        verify(dao).addOrder(order);
        verify(dao).logAction("Order Placed");
    }

    // 3. Cancel order
    @Test
    void testCancelOrder() {
        OrderDao dao = mock(OrderDao.class);

        when(dao.cancelOrder(1)).thenReturn(true);

        OrderManager manager = new OrderManager(dao);
        boolean result = manager.cancelOrder(1);

        assertTrue(result);
        verify(dao).cancelOrder(1);
        verify(dao).logAction("Order Cancelled");
    }

    // 4. Static discount calculation
    @Test
    void testStaticDiscount() {
        double result = OrderManager.staticDiscount(100);
        assertEquals(90, result);
    }

    // 5. Final database info method
    @Test
    void testFinalDatabaseInfo() {
        OrderDao dao = mock(OrderDao.class);

        when(dao.getDatabaseInfo()).thenReturn("Mock DB");

        OrderManager manager = new OrderManager(dao);
        String info = manager.getDbInfo();

        assertEquals("Mock DB", info);
    }

    // 6. Void logging method
    @Test
    void testVoidLogging() {
        OrderDao dao = mock(OrderDao.class);
        Order order = new Order(3, "Subway", "Sandwich", 150);

        OrderManager manager = new OrderManager(dao);
        manager.addOrder(order);

        verify(dao).logAction("Order Placed");
    }

    // 7. Processing orders using spy
    @Test
    void testProcessOrderFestivalDiscount() {
        OrderDao dao = mock(OrderDao.class);
        OrderManager manager = spy(new OrderManager(dao));

        Order order = new Order(4, "Dominos", "Pizza", 100);

        doReturn("Festival Offer").when(manager).checkFestival();

        double result = manager.processOrder(order);

        assertEquals(80, result);
    }
}


