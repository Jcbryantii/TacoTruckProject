package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TacoTruckWelcomePanel extends JPanel {


    private JButton startButton;
    private JTextField customerNameField;

    public TacoTruckWelcomePanel() {

        this.setName("view.TacoTruckWelcomePanel");
        JLabel customerNameLabel = new JLabel("Enter Customer Name");
        this.add(customerNameLabel);
        customerNameField = new JTextField(20);
        customerNameField.setName("CustomerNameField");
        this.add(customerNameField);

        startButton = new JButton("Start Order");
        startButton.setName("StartOrderButton");
        this.add(startButton);

    }

    public JButton getStartButton() {
        return this.startButton;
    }

    public JTextField getCustomerNameField() {
        return this.customerNameField;
    }






}





