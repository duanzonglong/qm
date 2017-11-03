//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2017.02.16 时间 01:58:28 PM CST 
//


package com.cwms.qm.model.stockout;

import javax.xml.bind.annotation.*;

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
 *         &lt;element ref="{}deliveryOrder"/>
 *         &lt;element ref="{}orderLines"/>
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
    "deliveryOrder",
    "orderLines"
})
@XmlRootElement(name = "request")
public class QmStockoutRequestDto
{

    @XmlElement(required = true)
    protected DeliveryOrder deliveryOrder;
    @XmlElement(required = true)
    protected OrderLines orderLines;

    /**
     * 获取deliveryOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DeliveryOrder }
     *     
     */
    public DeliveryOrder getDeliveryOrder() {
        return deliveryOrder;
    }

    /**
     * 设置deliveryOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryOrder }
     *     
     */
    public void setDeliveryOrder(DeliveryOrder value) {
        this.deliveryOrder = value;
    }

    /**
     * 获取orderLines属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OrderLines }
     *     
     */
    public OrderLines getOrderLines() {
        return orderLines;
    }

    /**
     * 设置orderLines属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OrderLines }
     *     
     */
    public void setOrderLines(OrderLines value) {
        this.orderLines = value;
    }

}
