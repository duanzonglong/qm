package com.cwms.qm.model.inventory;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by duanzonglong on 2017/8/18.
 */
@XmlRootElement(name = "request")
public class QmInventoryQueryRequest
{
    private CriteriaList criteriaList;

    public CriteriaList getCriteriaList()
    {
        return criteriaList;
    }

    public void setCriteriaList(CriteriaList criteriaList)
    {
        this.criteriaList = criteriaList;
    }
}
