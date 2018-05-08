package view;

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

    @Test
    public void testTacoOrderButtonDoesAddTacoToOrder() {
        presenter.Presenter pres = new presenter.Presenter(new TacoTruck());
        ((TacoTruckWelcomePanel) pres.getCurrentScreen()).getStartButton().doClick();
        JButton addTacoButton = (JButton) ((OrderPanel) pres.getCurrentScreen()).getTacoButton();
        ((OrderPanel) pres.getCurrentScreen()).getTacoButton().doClick();
        assertEquals(1, ((OrderPanel) pres.getCurrentScreen()).getNumberofItems());
    }


}