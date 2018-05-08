package view;

import model.Order;

import javax.swing.*;

public class OrderPanel extends JPanel {

    private String customerName;
    private JButton addTacoButton;
    private Order order;

    public OrderPanel(String customerName) {
        this.setName("TacoTruckOrderPanel");
        this.customerName = customerName;
        order = new Order(customerName);
        this.add(new JLabel("Order for: " + customerName));
        addTacoButton = new JButton("Taco");
        addTacoButton.setName("Taco");
        this.add(addTacoButton);

    }

    public String getCustomerName() {

        return customerName;

    }

    public int getNumberofItems() {
        return this.order.getOrderSize();
    }


    public void addItemToOrder(model.Taco taco) {
        this.order.addItem(taco);
        System.out.println(getNumberofItems());
    }

    public JButton getTacoButton() {
        return this.addTacoButton;
    }
}