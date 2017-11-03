//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2017.02.16 时间 01:58:28 PM CST 
//


package com.cwms.qm.model.stockout;

import java.math.BigInteger;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}totalOrderLines"/>
 *         &lt;element ref="{}deliveryOrderCode"/>
 *         &lt;element ref="{}orderType"/>
 *         &lt;element ref="{}warehouseCode"/>
 *         &lt;element ref="{}createTime"/>
 *         &lt;element ref="{}scheduleDate"/>
 *         &lt;element ref="{}logisticsCode"/>
 *         &lt;element ref="{}logisticsName"/>
 *         &lt;element ref="{}transportMode"/>
 *         &lt;element ref="{}pickerInfo"/>
 *         &lt;element ref="{}senderInfo"/>
 *         &lt;element ref="{}receiverInfo"/>
 *         &lt;element ref="{}remark"/>
 *         &lt;element ref="{}extendProps"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "totalOrderLines",
    "deliveryOrderCode",
    "orderType",
    "warehouseCode",
    "createTime",
    "scheduleDate",
    "logisticsCode",
    "logisticsName",
    "transportMode",
    "pickerInfo",
    "senderInfo",
    "receiverInfo",
    "remark",
    "extendProps",
    "partialShipment"
})
@XmlRootElement(name = "deliveryOrder")
public class DeliveryOrder {

    @XmlElement(required = true)
    protected Integer totalOrderLines;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String deliveryOrderCode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String orderType;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String warehouseCode;
    @XmlElement(required = true)
    protected String createTime;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String scheduleDate;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String logisticsCode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String logisticsName;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String transportMode;
    @XmlElement(required = true)
    protected PickerInfo pickerInfo;
    @XmlElement(required = true)
    protected SenderInfo senderInfo;
    @XmlElement(required = true)
    protected ReceiverInfo receiverInfo;
    @XmlElement(required = true)
    protected String remark;
    @XmlElement(required = true)
    protected ExtendProps extendProps;

    @XmlElement(required = true)
    protected  String partialShipment;

    public String getPartialShipment() {
        return partialShipment;
    }

    public void setPartialShipment(String partialShipment) {
        this.partialShipment = partialShipment;
    }

    /**
     * 获取totalOrderLines属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getTotalOrderLines() {
        return totalOrderLines;
    }

    /**
     * 设置totalOrderLines属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalOrderLines(Integer value) {
        this.totalOrderLines = value;
    }

    /**
     * 获取deliveryOrderCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryOrderCode() {
        return deliveryOrderCode;
    }

    /**
     * 设置deliveryOrderCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryOrderCode(String value) {
        this.deliveryOrderCode = value;
    }

    /**
     * 获取orderType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置orderType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    /**
     * 获取warehouseCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarehouseCode() {
        return warehouseCode;
    }

    /**
     * 设置warehouseCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarehouseCode(String value) {
        this.warehouseCode = value;
    }

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * 获取scheduleDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * 设置scheduleDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleDate(String value) {
        this.scheduleDate = value;
    }

    /**
     * 获取logisticsCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogisticsCode() {
        return logisticsCode;
    }

    /**
     * 设置logisticsCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogisticsCode(String value) {
        this.logisticsCode = value;
    }

    /**
     * 获取logisticsName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogisticsName() {
        return logisticsName;
    }

    /**
     * 设置logisticsName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogisticsName(String value) {
        this.logisticsName = value;
    }

    /**
     * 获取transportMode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportMode() {
        return transportMode;
    }

    /**
     * 设置transportMode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportMode(String value) {
        this.transportMode = value;
    }

    /**
     * 获取pickerInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PickerInfo }
     *     
     */
    public PickerInfo getPickerInfo() {
        return pickerInfo;
    }

    /**
     * 设置pickerInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PickerInfo }
     *     
     */
    public void setPickerInfo(PickerInfo value) {
        this.pickerInfo = value;
    }

    /**
     * 获取senderInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SenderInfo }
     *     
     */
    public SenderInfo getSenderInfo() {
        return senderInfo;
    }

    /**
     * 设置senderInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SenderInfo }
     *     
     */
    public void setSenderInfo(SenderInfo value) {
        this.senderInfo = value;
    }

    /**
     * 获取receiverInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReceiverInfo }
     *     
     */
    public ReceiverInfo getReceiverInfo() {
        return receiverInfo;
    }

    /**
     * 设置receiverInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReceiverInfo }
     *     
     */
    public void setReceiverInfo(ReceiverInfo value) {
        this.receiverInfo = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * 获取extendProps属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExtendProps }
     *     
     */
    public ExtendProps getExtendProps() {
        return extendProps;
    }

    /**
     * 设置extendProps属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendProps }
     *     
     */
    public void setExtendProps(ExtendProps value) {
        this.extendProps = value;
    }

}
