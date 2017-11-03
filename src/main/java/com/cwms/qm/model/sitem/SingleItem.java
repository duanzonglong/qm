package com.cwms.qm.model.sitem;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by duanzonglong on 2017/8/3.
 */
@XmlRootElement(name = "request")
public class SingleItem
{
    private String actionType;

    private String warehouseCode;

    private String ownerCode;

    private String supplierCode;

    private String supplierName;

    private Item item;

    public String getActionType()
    {
        return actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    public String getWarehouseCode()
    {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode)
    {
        this.warehouseCode = warehouseCode;
    }

    public String getOwnerCode()
    {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode)
    {
        this.ownerCode = ownerCode;
    }

    public String getSupplierCode()
    {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode)
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName()
    {
        return supplierName;
    }

    public void setSupplierName(String supplierName)
    {
        this.supplierName = supplierName;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }
}
