package com.cwms.qm.model.outorder;

public class OrderLine
{
    private String orderLineNo;

    private String ownerCode;

    private String itemCode;

    private String itemId;

    private String inventoryType;

    private String itemName;

    private String planQty;

    private Double actualPrice;

    public Double getActualPrice()
    {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice)
    {
        this.actualPrice = actualPrice;
    }

    public String getOrderLineNo()
    {
        return orderLineNo;
    }

    public void setOrderLineNo(String orderLineNo)
    {
        this.orderLineNo = orderLineNo;
    }

    public String getOwnerCode()
    {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode)
    {
        this.ownerCode = ownerCode;
    }

    public String getItemCode()
    {
        return itemCode;
    }

    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }

    public String getItemId()
    {
        return itemId;
    }

    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    public String getInventoryType()
    {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType)
    {
        this.inventoryType = inventoryType;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public String getPlanQty()
    {
        return planQty;
    }

    public void setPlanQty(String planQty)
    {
        this.planQty = planQty;
    }
}
