/** 
 * 
 * Copyright (c) behosoft Co.,Ltd. 
 * All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of behosoft.
 * (Social Security Department). You shall not disclose such
 * Confidential Information and shall use it only in accordance with 
 * the terms of the license agreement you entered into with behosoft. 
 *
 * Distributable under GNU LGPL license by gnu.org
 */
package com.cwms.qm.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 * <p>
 * Title: 百弘电商物流标准版_[]_[模块名]
 * </p>
 * <p>
 * Description: [描述该类概要功能介绍]
 * </p>
 * 
 * @author jiangyonghua
 * @version 1.0 2016-1-6
 * @author (lastest modification by )
 * @since 1.0
 */
public class NullToEmptyNodeAdapter extends XmlAdapter<String, String>
{
    
    @Override
    public String marshal(String value)
        throws Exception
    {
        if (null == value)
        {
            return "";
        }
        return value;
    }
    
    @Override
    public String unmarshal(String v)
        throws Exception
    {
        return v;
    }
}
