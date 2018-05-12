package presenter;

import model.Cashier;
import model.Order;
import model.Taco;
import model.TacoTruck;
import view.OrderPanel;
import view.welcome;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class Presenter {

    private TacoTruck view;
    private Cashier model;
    private view.welcome welcome = new welcome();
    private OrderPanel orderPanel = new OrderPanel("Sarah");


/*    public void activateTacoButtonListener() {
        ((OrderPanel) this.getCurrentScreen()).getTacoButton().addActionListener(new TacoButtonActionListener());
    }*/

    public Container getCurrentScreen() {
        return view.getContentPane();
    }

    public void setCurrentScreen(JPanel screen) {
        this.view.setContentPane(screen);
        view.revalidate();
    }

    public JFrame getView() {
        return this.view;
    }

    public OrderPanel getOrderPanel() {
        return orderPanel;
    }

    public Presenter(TacoTruck view, Cashier model) {
        this.model = model;
        this.view = view;
        setCurrentScreen(welcome);
        ((welcome) this.getCurrentScreen()).getStartButton().addActionListener(new StartButtonActonListener());
        orderPanel.getTacoButton().addActionListener(new TacoButtonActionListener());
    }


    public static void main(String[] args) {
        new Presenter(new model.TacoTruck(), new Cashier());
    }

    public Cashier getModel() {
        return this.model;
    }

    public void addOrder(Order order) {
        this.getModel().addOrder(order);
    }

    public Order getCurrentOrder() {
        return model.getOrder( model.getNumberOfOrders() - 1 );
    }

    private class StartButtonActonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerName = ((view.welcome)getCurrentScreen()).getCustomerNameField().getText();
            setCurrentScreen(new OrderPanel(customerName));
            getCurrentScreen().revalidate();
        }
    }


   private class TacoButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getCurrentOrder().addItem(new Taco());
        }
    }


}