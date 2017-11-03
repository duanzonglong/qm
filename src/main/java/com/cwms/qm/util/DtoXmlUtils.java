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

import com.cwms.qm.model.QmCommonResponseDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title: 百弘电商物流标准版_[]_[模块名]
 * </p>
 * <p>
 * Description: [描述该类概要功能介绍]
 * </p>
 * 
 * @author jiangyonghua
 * @version 1.0 2013-10-17
 * @author (lastest modification by )
 * @since 1.0
 */
public class DtoXmlUtils
{
    public final static Log log = LogFactory.getLog(DtoXmlUtils.class);
    
    public static Map<String, Marshaller> marshallerMap = new HashMap<String, Marshaller>();
    
    public static Map<String, Unmarshaller> UnmarshallerMap = new HashMap<String, Unmarshaller>();
    
    public static synchronized String DtoToXml(Object dtoObject)
        throws Exception
    {
        String xml = "";
        StringWriter stringWriter = new StringWriter();
        try
        {
            String className = dtoObject.getClass().getName();
            Marshaller marshaller_res = null;
            if (marshallerMap.containsKey(className))
            {
                marshaller_res = marshallerMap.get(className);
            }
            else
            {
                marshaller_res = JAXBContext.newInstance(dtoObject.getClass()).createMarshaller();
                marshallerMap.put(className, marshaller_res);
            }
            marshaller_res.marshal(dtoObject, stringWriter);
            xml = stringWriter.toString();
            stringWriter.flush();
        }
        catch (Exception ex)
        {
            System.out.println("toxml" + ex.toString());
            throw ex;
        }
        finally
        {
            try
            {
                if (stringWriter != null)
                    stringWriter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return xml;
    }
    
    public static synchronized Object xmlToDto(String xml, Class classType)
        throws Exception
    {
        Object obj = null;
        try
        {
            Unmarshaller unmarshaller_req = null;
            String className = classType.getName();
            if (UnmarshallerMap.containsKey(className))
            {
                unmarshaller_req = UnmarshallerMap.get(className);
            }
            else
            {
                unmarshaller_req = JAXBContext.newInstance(classType).createUnmarshaller();
                UnmarshallerMap.put(className, unmarshaller_req);
            }
            obj = unmarshaller_req.unmarshal(new StringReader(xml));
        }
        catch (Exception ex)
        {
            System.out.println("todto" + ex.toString());
            throw ex;
        }
        return obj;
    }

    public static void main(String[] args)
        throws Exception
    {
        String xml = "<response>" +
            "    <flag>success</flag>" +
            "    <code>10</code>" +
            "    <message>[2432]执行成功</message>" +
            "</response>";


        if (StringUtils.isNotEmpty(xml))
        {
            int startIndex = xml.indexOf("<?xml");
            if (startIndex > -1)
            {
                xml = xml.substring(startIndex);
            }
        }

        QmCommonResponseDto qmResponse = (QmCommonResponseDto)DtoXmlUtils.xmlToDto(xml, QmCommonResponseDto.class);

        System.out.println(qmResponse);

    }
    
}
