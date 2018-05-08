package com.cwms.qm.model.outorder;

public class DeliveryOrder
{
    private String deliveryOrderCode;

    private String orderType;

    private String warehouseCode;

    private String orderFlag;

    private String sourcePlatformCode;

    private String sourcePlatformName;

    private String createTime;

    private String placeOrderTime;

    private String operateTime;

    private String shopNick;

    private String totalAmount;

    private String logisticsCode;

    private String logisticsName;

    private String logisticsAreaCode;

    private ReceiverInfo receiverInfo;

    private SenderInfo senderInfo;

    private ExtendProps extendProps;

    public String getLogisticsAreaCode() {
        return logisticsAreaCode;
    }

    public void setLogisticsAreaCode(String logisticsAreaCode) {
        this.logisticsAreaCode = logisticsAreaCode;
    }

    public ExtendProps getExtendProps()
    {
        return extendProps;
    }

    public void setExtendProps(ExtendProps extendProps)
    {
        this.extendProps = extendProps;
    }

    public SenderInfo getSenderInfo()
    {
        return senderInfo;
    }

    public void setSenderInfo(SenderInfo senderInfo)
    {
        this.senderInfo = senderInfo;
    }

    public String getDeliveryOrderCode()
    {
        return deliveryOrderCode;
    }

    public void setDeliveryOrderCode(String deliveryOrderCode)
    {
        this.deliveryOrderCode = deliveryOrderCode;
    }

    public String getOrderType()
    {
        return orderType;
    }

    public void setOrderType(String orderType)
    {
        this.orderType = orderType;
    }

    public String getWarehouseCode()
    {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode)
    {
        this.warehouseCode = warehouseCode;
    }

    public String getOrderFlag()
    {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag)
    {
        this.orderFlag = orderFlag;
    }

    public String getSourcePlatformCode()
    {
        return sourcePlatformCode;
    }

    public void setSourcePlatformCode(String sourcePlatformCode)
    {
        this.sourcePlatformCode = sourcePlatformCode;
    }

    public String getSourcePlatformName()
    {
        return sourcePlatformName;
    }

    public void setSourcePlatformName(String sourcePlatformName)
    {
        this.sourcePlatformName = sourcePlatformName;
    }

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getPlaceOrderTime()
    {
        return placeOrderTime;
    }

    public void setPlaceOrderTime(String placeOrderTime)
    {
        this.placeOrderTime = placeOrderTime;
    }

    public String getOperateTime()
    {
        return operateTime;
    }

    public void setOperateTime(String operateTime)
    {
        this.operateTime = operateTime;
    }

    public String getShopNick()
    {
        return shopNick;
    }

    public void setShopNick(String shopNick)
    {
        this.shopNick = shopNick;
    }

    public String getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public String getLogisticsCode()
    {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode)
    {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName()
    {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName)
    {
        this.logisticsName = logisticsName;
    }

    public ReceiverInfo getReceiverInfo()
    {
        return receiverInfo;
    }

    public void setReceiverInfo(ReceiverInfo receiverInfo)
    {
        this.receiverInfo = receiverInfo;
    }
}
