package view;

import model.Order;

import javax.swing.*;

public class OrderPanel extends JPanel {

    private String customerName;
    private JButton addTacoButton;

    private JTextArea provisionalOrderSummaryTextArea;

    public OrderPanel(String customerName) {
        this.setName("TacoTruckOrderPanel");
        this.customerName = customerName;
        this.add(new JLabel("Order for: " + customerName));
        addTacoButton = new JButton("Taco");
        addTacoButton.setName("Taco");
        this.add(addTacoButton);
        provisionalOrderSummaryTextArea = new JTextArea();
        this.add(provisionalOrderSummaryTextArea);
    }

    String getCustomerName() {
        return customerName;
    }

    /*public int getNumberofItems() {
        return this.order.getOrderSize();
    }

    public void addItemToOrder(model.Taco taco) {
        this.order.addItem(taco);
        System.out.println(getNumberofItems());
        String updateString = "One " + taco.toString() + " added to order. Subtotal so far: $" + this.order.getSubtotal() + "\n";
        provisionalOrderSummaryTextArea.append(updateString);
    }*/

    public JButton getTacoButton() {
        return this.addTacoButton;
    }
}