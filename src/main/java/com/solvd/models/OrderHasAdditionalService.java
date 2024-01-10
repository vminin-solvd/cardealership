package com.solvd.models;

public class OrderHasAdditionalService {

    private Order order;
    private AdditionalService additionalService;

    public OrderHasAdditionalService(Order order, AdditionalService additionalService) {
        this.order = order;
        this.additionalService = additionalService;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public AdditionalService getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    @Override
    public String toString() {
        return "OrderHasAdditionalService{" +
                "order=" + order +
                ", additionalService=" + additionalService +
                '}';
    }
}
