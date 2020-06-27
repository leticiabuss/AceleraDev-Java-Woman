package br.com.codenation;

public class BillingProcessor {

    public Double calculate(Order order) {
    	switch (order.getPaymentMethod()) {
        case CASH:
            return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
        case TRANSFER:
            return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
        case CREDIT_CARD:
            return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
        case DEBIT_CARD:
            return order.getPaymentMethod().getPaymentStrategy().calculate(order.getPrice());
    }
        throw new RuntimeException("Payment method not implemented");
    }
}