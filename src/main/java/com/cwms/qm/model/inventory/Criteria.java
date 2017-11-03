package com.cwms.qm.model.inventory;

/**
 * Created by duanzonglong on 2017/8/18.
 */
public class Criteria
{
    private String warehouseCode;

    private String ownerCode;

    private String itemCode;

    private String inventoryType;

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

    public String getItemCode()
    {
        return itemCode;
    }

    public void setItemCode(String itemCode)
    {
        this.itemCode = itemCode;
    }

    public String getInventoryType()
    {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType)
    {
        this.inventoryType = inventoryType;
    }
}
