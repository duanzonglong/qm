//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2017.10.17 ʱ�� 02:53:59 PM CST 
//


package com.cwms.qm.model.inventoryMonitor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element ref="{}inventoryMonitoring" maxOccurs="unbounded"/>
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
    "inventoryMonitoring"
})
@XmlRootElement(name = "inventoryMonitoringList")
public class InventoryMonitoringList {

    @XmlElement(required = true)
    protected List<InventoryMonitoring> inventoryMonitoring;

    /**
     * Gets the value of the inventoryMonitoring property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inventoryMonitoring property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInventoryMonitoring().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InventoryMonitoring }
     * 
     * 
     */
    public List<InventoryMonitoring> getInventoryMonitoring() {
        if (inventoryMonitoring == null) {
            inventoryMonitoring = new ArrayList<InventoryMonitoring>();
        }
        return this.inventoryMonitoring;
    }

}
