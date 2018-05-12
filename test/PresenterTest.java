import model.Cashier;
import model.Order;
import model.TacoTruck;
import org.junit.Before;
import org.junit.Test;
import presenter.Presenter;
import view.OrderPanel;
import view.welcome;


import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;


public class PresenterTest {

    TacoTruck view;
    Presenter presenter;
    Cashier model;


    @Before
    public void setUp() {
        view = new TacoTruck();

        model = new Cashier();

        presenter = new Presenter(view, model);

    }

    @Test
    public void testPresenterInitializesWithStartScree() {

        Container currentScreen = presenter.getCurrentScreen();

        assertEquals(view, presenter.getView());

        assertEquals("view.welcome", currentScreen.getName());

        assertEquals(currentScreen, presenter.getView().getContentPane());

        assertEquals(model, presenter.getModel());

    }

   @Test
    public void testTacoOrderButtonDoesAddTacoToOrder() {

        presenter.setCurrentScreen(presenter.getOrderPanel());
        presenter.addOrder(new Order("Sarah"));
        presenter.getOrderPanel().getTacoButton().doClick();

        assertEquals("Taco", presenter.getModel().getOrder(0).getItem(0).getItemName());

    }

    @Test
    public void testSetCurrentOrder(){
        Order order = new Order("Sarah");
        presenter.addOrder(order);

        assertEquals(order, presenter.getModel().getOrder(0));
    }

    @Test
    public void testGetCurrentOrder(){ ;
        Order james = new Order("James");
        presenter.addOrder(james);
        assertEquals(james, presenter.getCurrentOrder());

        Order sarah = new Order("sarah");
        presenter.addOrder(sarah);
        assertEquals(sarah, presenter.getCurrentOrder());
    }


    @Test
    public void testStartButtonOnClickGoesToOrderScreen () {

        JButton startButton = ((welcome) presenter.getCurrentScreen()).getStartButton();

        startButton.doClick();

        assertEquals("TacoTruckOrderPanel", presenter.getCurrentScreen().getName());
    }



}