package model;

import java.util.LinkedList;

public class Cashier {

    private LinkedList<Order> orders = new LinkedList<>();

    public Order addOrder(Order order) {

        this.orders.add(order);
        return order;

    }

    public int getNumberOfOrders() {

        return this.orders.size();

    }

    public Order getOrder(int index) {

        return this.orders.get(index);

    }

}
