package presenter;

import model.Cashier;
import model.Order;
import model.Taco;
import model.TacoTruck;
import view.OrderPanel;
import view.TacoTruckWelcomePanel;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class Presenter {

    private TacoTruck view;
    private Cashier model;


/*    public void activateTacoButtonListener() {
        ((OrderPanel) this.getCurrentScreen()).getTacoButton().addActionListener(new TacoButtonActionListener());
    }*/

    public Container getCurrentScreen() {
        return view.getContentPane();
    }

    private void setCurrentScreen(JPanel screen) {
        this.view.setContentPane(screen);
        view.revalidate();
    }

    public JFrame getView() {
        return this.view;
    }

    public Presenter(TacoTruck view, Cashier model) {
        this.model = model;
        this.view = view;
        setCurrentScreen(new TacoTruckWelcomePanel());
        ((TacoTruckWelcomePanel) this.getCurrentScreen()).getStartButton().addActionListener(new StartButtonActonListener());
    }


    public static void main(String[] args) {
        new Presenter(new model.TacoTruck(), new Cashier());
    }

    public Cashier getModel() {
        return this.model;
    }

    public Order addOrder(Order order) {
        return this.getModel().addOrder(order);
    }

    private class StartButtonActonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerName = ((TacoTruckWelcomePanel)getCurrentScreen()).getCustomerNameField().getText();
            setCurrentScreen(new OrderPanel(customerName));
            getCurrentScreen().revalidate();
//            activateTacoButtonListener();
        }
    }


/*    private class TacoButtonActionListener implements ActionListener {

        public void addItemToOrder(model.Taco taco) {

            System.out.println(getNumberofItems());
            String updateString = "One " + taco.toString() + " added to order. Subtotal so far: $" + this.order.getSubtotal() + "\n";
            provisionalOrderSummaryTextArea.append(updateString);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getCurrentScreen().addItemToOrder(new Taco());

        }
    }

    public int getNumberofItems() {
        return model.Order.getOrderSize();
    }*/

}