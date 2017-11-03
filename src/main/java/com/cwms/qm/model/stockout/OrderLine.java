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
 *         &lt;element ref="{}outBizCode"/>
 *         &lt;element ref="{}orderLineNo"/>
 *         &lt;element ref="{}ownerCode"/>
 *         &lt;element ref="{}itemCode"/>
 *         &lt;element ref="{}itemId"/>
 *         &lt;element ref="{}itemName"/>
 *         &lt;element ref="{}inventoryType"/>
 *         &lt;element ref="{}planQty"/>
 *         &lt;element ref="{}batchCode"/>
 *         &lt;element ref="{}productDate"/>
 *         &lt;element ref="{}expireDate"/>
 *         &lt;element ref="{}produceCode"/>
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
    "outBizCode",
    "orderLineNo",
    "ownerCode",
    "itemCode",
    "itemId",
    "itemName",
    "inventoryType",
    "planQty",
    "batchCode",
    "productDate",
    "expireDate",
    "produceCode"
})
@XmlRootElement(name = "orderLine")
public class OrderLine {

    @XmlElement(required = true)
    protected String outBizCode;
    @XmlElement(required = true)
    protected String orderLineNo;
    @XmlElement(required = true)
    protected String ownerCode;
    @XmlElement(required = true)
    protected String itemCode;
    @XmlElement(required = true)
    protected String itemId;
    @XmlElement(required = true)
    protected String itemName;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String inventoryType;
    @XmlElement(required = true)
    protected BigInteger planQty;
    @XmlElement(required = true)
    protected String batchCode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String productDate;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String expireDate;
    @XmlElement(required = true)
    protected String produceCode;

    /**
     * 获取outBizCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutBizCode() {
        return outBizCode;
    }

    /**
     * 设置outBizCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutBizCode(String value) {
        this.outBizCode = value;
    }

    /**
     * 获取orderLineNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderLineNo() {
        return orderLineNo;
    }

    /**
     * 设置orderLineNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderLineNo(String value) {
        this.orderLineNo = value;
    }

    /**
     * 获取ownerCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerCode() {
        return ownerCode;
    }

    /**
     * 设置ownerCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerCode(String value) {
        this.ownerCode = value;
    }

    /**
     * 获取itemCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * 设置itemCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCode(String value) {
        this.itemCode = value;
    }

    /**
     * 获取itemId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置itemId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemId(String value) {
        this.itemId = value;
    }

    /**
     * 获取itemName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置itemName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemName(String value) {
        this.itemName = value;
    }

    /**
     * 获取inventoryType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInventoryType() {
        return inventoryType;
    }

    /**
     * 设置inventoryType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventoryType(String value) {
        this.inventoryType = value;
    }

    /**
     * 获取planQty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPlanQty() {
        return planQty;
    }

    /**
     * 设置planQty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPlanQty(BigInteger value) {
        this.planQty = value;
    }

    /**
     * 获取batchCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * 设置batchCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchCode(String value) {
        this.batchCode = value;
    }

    /**
     * 获取productDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDate() {
        return productDate;
    }

    /**
     * 设置productDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDate(String value) {
        this.productDate = value;
    }

    /**
     * 获取expireDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * 设置expireDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpireDate(String value) {
        this.expireDate = value;
    }

    /**
     * 获取produceCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduceCode() {
        return produceCode;
    }

    /**
     * 设置produceCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduceCode(String value) {
        this.produceCode = value;
    }

}
