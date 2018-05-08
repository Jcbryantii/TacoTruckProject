package presenter;

import model.Taco;
import model.TacoTruck;
import view.OrderPanel;
import view.TacoTruckWelcomePanel;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class Presenter implements ActionListener {


    private final TacoTruck view;

    public void activateTacoButtonListener() {
        ((OrderPanel) this.getCurrentScreen())
                .getTacoButton()
                .addActionListener(this);
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
                .addActionListener(this);
        ((TacoTruckWelcomePanel) this.getCurrentScreen()).getStartButton().setActionCommand("Start Order");
    }


    public Container getCurrentScreen() {

        return view.getContentPane();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvente) {
        String actionCommand = actionEvente.getActionCommand();
        switch(actionCommand) {
            case "Start Order":
                String customerName = ((TacoTruckWelcomePanel)getCurrentScreen()).getCustomerNameField().getText();
                setCurrentScreen(new OrderPanel(customerName));
                getCurrentScreen().revalidate();
                activateTacoButtonListener();
                System.out.println("start order button has been clicked");
                break;
            case "Add Taco":
                ((OrderPanel) this.getCurrentScreen()).addItemToOrder(new Taco());
                System.out.println("add taco button has been clicked");
                break;
            default:
                System.err.println("Command not recognized");
        }
    }

    public static void main(String[] args) {

        new Presenter(new model.TacoTruck());

    }



}