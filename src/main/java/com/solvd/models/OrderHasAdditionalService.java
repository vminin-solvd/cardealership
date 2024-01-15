package com.solvd.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "orderHasAdditionalService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"order", "additionalService"})
public class OrderHasAdditionalService {

    @XmlElement(name = "order", type = Order.class)
    private Order order;
    @XmlElement(name = "additionalService", type = AdditionalService.class)
    private AdditionalService additionalService;

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
