package com.cwms.qm.model.feedback;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class DeliveryOrderConfirm
{
    private DeliveryOrder deliveryOrder;

    public DeliveryOrder getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }
}
