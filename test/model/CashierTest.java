package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashierTest {

    private Cashier cashier;

    @Before
    public void setUp() {
        this.cashier = new Cashier();
    }

    @Test
    public void testAddOrder() {
        Order order = new Order("Cana");
        Order order2 = new Order("Coal");
        this.cashier.addOrder(order);
        this.cashier.addOrder(order2);
        assertEquals(2, this.cashier.getNumberOfOrders());
        assertEquals(order, this.cashier.getOrder(0));
        assertEquals(order2, this.cashier.getOrder(1));
    }

    @Test
    public void testReturnsCorrectSizeOfOrders() {
        assertEquals(0, cashier.getNumberOfOrders());
    }

}