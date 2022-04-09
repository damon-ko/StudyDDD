package com.study.ddd.domain.order;

import java.util.List;

public class Order {
    private OrderNumber id;
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private ShippingInfo shippingInfo;
    private OrderState state;
    private Orderer orderer;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        if (this.id == null) return false;
        return this.id.equals(order.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public Order(Orderer orderer, List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) throw new IllegalArgumentException("No Orderer");
        this.orderer = orderer;
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) throw new IllegalArgumentException("No ShippingInfo");
        this.shippingInfo = shippingInfo;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty())
            throw new IllegalArgumentException("No OrderLines");
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream().mapToInt(x -> x.getAmounts().getValue()).sum());
    }

    public void changeShipped() {}
    public void changeShippingInfo(ShippingInfo newShipping) {
        checkShippingInfoChangeable();
        setShippingInfo(newShipping);
    }

    private void checkShippingInfoChangeable() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new IllegalStateException("Already shipped");
    }

    public void cancel() {
        checkShippingInfoChangeable();
        this.state = OrderState.CANCELED;
    }
    public void completePayment() {}
}
