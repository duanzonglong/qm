package com.cwms.qm.model.outorder;

import java.util.ArrayList;
import java.util.List;

public class OrderLines
{
    private List<OrderLine> orderLine = new ArrayList<>();

    public List<OrderLine> getOrderLine()
    {
        return orderLine;
    }

    public void setOrderLine(List<OrderLine> orderLine)
    {
        this.orderLine = orderLine;
    }
}
