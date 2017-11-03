package com.cwms.qm.model.inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duanzonglong on 2017/8/18.
 */

public class CriteriaList
{
    private List<Criteria> criteria;

    public List<Criteria> getCriteria()
    {
        if (null == criteria)
        {
            criteria = new ArrayList<>();
        }
        return criteria;
    }

    public void setCriteria(List<Criteria> criteria)
    {
        this.criteria = criteria;
    }
}
