package presenter;

import model.Taco;
import model.TacoTruck;
import view.OrderPanel;
import view.TacoTruckWelcomePanel;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class Presenter {

    private final TacoTruck view;

    public void activateTacoButtonListener() {
        ((OrderPanel) this.getCurrentScreen())
                .getTacoButton()
                .addActionListener(new TacoButtonActionListener());
        ((OrderPanel) this.getCurrentScreen()).getTacoButton().setActionCommand("Add Taco");
    }

    private void setCurrentScreen(JPanel screen) {
        this.view.setContentPane(screen);
        view.revalidate();
    }

    public JFrame getView() {
        return this.view;
    }


    public Presenter(TacoTruck tacoTruck) {
        this.view = tacoTruck;
        setCurrentScreen(new TacoTruckWelcomePanel());
        ((TacoTruckWelcomePanel) this.getCurrentScreen())
                .getStartButton()
                .addActionListener(new StartButtonActonListener());
        ((TacoTruckWelcomePanel) this.getCurrentScreen()).getStartButton().setActionCommand("Start Order");
    }


    public Container getCurrentScreen() {
        return view.getContentPane();
    }


    public static void main(String[] args) {
        new Presenter(new model.TacoTruck());
    }

    private class StartButtonActonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String customerName = ((TacoTruckWelcomePanel)getCurrentScreen()).getCustomerNameField().getText();
            setCurrentScreen(new OrderPanel(customerName));
            getCurrentScreen().revalidate();
            activateTacoButtonListener();
        }
    }


    private class TacoButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ((OrderPanel) getCurrentScreen()).addItemToOrder(new Taco());

        }
    }
}