package com.solvd.models;

public class OrderHasAdditionalService {
    private int id;
    private Order order;
    private AdditionalService additionalService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", order=" + order +
                ", additionalService=" + additionalService +
                '}';
    }
}
