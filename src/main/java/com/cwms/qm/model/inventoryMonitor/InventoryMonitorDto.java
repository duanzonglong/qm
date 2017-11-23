//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2017.10.17 ʱ�� 02:53:59 PM CST 
//


package com.cwms.qm.model.inventoryMonitor;

import javax.xml.bind.annotation.*;

/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}inventoryMonitoringList"/>
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
    "inventoryMonitoringList"
})
@XmlRootElement(name = "request")
public class InventoryMonitorDto
{

    @XmlElement(required = true)
    protected InventoryMonitoringList inventoryMonitoringList;

    /**
     * ��ȡinventoryMonitoringList���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link InventoryMonitoringList }
     *     
     */
    public InventoryMonitoringList getInventoryMonitoringList() {
        return inventoryMonitoringList;
    }

    /**
     * ����inventoryMonitoringList���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryMonitoringList }
     *     
     */
    public void setInventoryMonitoringList(InventoryMonitoringList value) {
        this.inventoryMonitoringList = value;
    }

}
