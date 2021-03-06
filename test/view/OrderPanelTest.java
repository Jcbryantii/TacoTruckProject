package view;

import model.Cashier;
import model.TacoTruck;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class OrderPanelTest {

    OrderPanel orderPanel;

    @Before
    public void setUp() {
        orderPanel = new OrderPanel("Mr. Customer");
    }


    @Test
    public void test_OrderHasCustomerName() {
        OrderPanel orderPanel1 = new OrderPanel("Coal");
        OrderPanel orderPanel2 = new OrderPanel("Julia");
        assertEquals("Coal", orderPanel1.getCustomerName());
        assertEquals("Julia", orderPanel2.getCustomerName());

    }

    @Test
    public void testOrderHasAddTacoButton() {

        assertEquals("Taco", ((JButton) orderPanel.getComponents()[1]).getName());
    }


}