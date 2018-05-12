package view;

import model.Order;

import javax.swing.*;

public class OrderPanel extends JPanel {

    private String customerName;
    private JButton addTacoButton;

    private JPanel orderSummaryArea;

    public OrderPanel(String customerName) {
        this.setName("TacoTruckOrderPanel");
        this.customerName = customerName;
        this.add(new JLabel("Order for: " + customerName));
        addTacoButton = new JButton("Taco");
        addTacoButton.setName("Taco");
        this.add(addTacoButton);

        orderSummaryArea = new JPanel();
        this.add(orderSummaryArea);
    }

    String getCustomerName() {
        return customerName;
    }
    public JPanel getOrderSummaryArea() {
        return this.orderSummaryArea;
    }


    public JButton getTacoButton() {

        return this.addTacoButton;
    }
}