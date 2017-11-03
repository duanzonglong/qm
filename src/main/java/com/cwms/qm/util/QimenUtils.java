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
import com.cwms.qm.model.QmInboundResponseDto;
import com.cwms.qm.model.QmItemResponseDto;
import com.cwms.qm.model.QmOutboundResponseDto;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * Title: 百弘电商物流标准版_[]_[模块名]
 * </p>
 * <p>
 * Description: [描述该类概要功能介绍]
 * </p> 
 * @author jiangyonghua
 * @version 1.0 2015-11-28
 * @author (lastest modification by  )
 * @since 1.0
 */
public class QimenUtils {

	/**
	 * 获取通用反馈
	 * 
	 * <p>
	 * Description:[方法功能中文描述]
	 * </p> 
	 * @param sql 参数说明
	 * @param args 参数说明
	 * @return 返回值说明
	 */
	public static String getCommonResponse(String resultCode,String resultFlag,String resultMsg)
	{
		String response ="";
		try
		{
			QmCommonResponseDto qmCommonResponseDto = new QmCommonResponseDto();
			qmCommonResponseDto.setCode(resultCode);
			qmCommonResponseDto.setFlag(resultFlag);
			qmCommonResponseDto.setMessage(resultMsg);
			response = DtoXmlUtils.DtoToXml(qmCommonResponseDto);
		}
		catch(Exception ex)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<response>");
			sb.append("<flag>" + resultFlag + "</flag>");
			sb.append("<code>" + resultCode + "</code>");
			sb.append("<message>" + resultMsg + "</message>");
			sb.append("</response>");
			response = sb.toString();
		}
		return response;
	}
	
	/**
	 * 获取商品反馈
	 * 
	 * <p>
	 * Description:[方法功能中文描述]
	 * </p> 
	 * @param sql 参数说明
	 * @param args 参数说明
	 * @return 返回值说明
	 */
	public static String getItemResponse(String resultCode,String resultFlag,String resultMsg,String itemId)
	{
		String response ="";
		try
		{
			QmItemResponseDto qmItemResponseDto = new QmItemResponseDto();
			qmItemResponseDto.setCode(resultCode);
			qmItemResponseDto.setFlag(resultFlag);
			qmItemResponseDto.setMessage(resultMsg);
			qmItemResponseDto.setItemId(itemId);
			response = DtoXmlUtils.DtoToXml(qmItemResponseDto);
		}
		catch(Exception ex)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<response>");
			sb.append("<flag>" + resultFlag + "</flag>");
			sb.append("<code>" + resultCode + "</code>");
			sb.append("<message>" + resultMsg + "</message>");
			sb.append("<itemId>" + itemId + "</itemId>");
			sb.append("</response>");
			response = sb.toString();
		}
		return response;
	}
	

	
	/**
	 * 获取入库单反馈
	 * 
	 * <p>
	 * Description:[方法功能中文描述]
	 * </p> 
	 * @param sql 参数说明
	 * @param args 参数说明
	 * @return 返回值说明
	 */
	public static String getInboundResponse(String resultCode,String resultFlag,String resultMsg,String orderId)
	{
		String response ="";
		try
		{
			QmInboundResponseDto qmInboundResponseDto = new QmInboundResponseDto();
			qmInboundResponseDto.setCode(resultCode);
			qmInboundResponseDto.setFlag(resultFlag);
			qmInboundResponseDto.setMessage(resultMsg);
			qmInboundResponseDto.setEntryOrderId(orderId);
			response = DtoXmlUtils.DtoToXml(qmInboundResponseDto);
		}
		catch(Exception ex)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<response>");
			sb.append("<flag>" + resultFlag + "</flag>");
			sb.append("<code>" + resultCode + "</code>");
			sb.append("<message>" + resultMsg + "</message>");
			sb.append("<entryOrderId>" + orderId + "</entryOrderId>");
			sb.append("</response>");
			response = sb.toString();
		}
		return response;
	}
	
	/**
	 * 获取出库单反馈
	 * 
	 * <p>
	 * Description:[方法功能中文描述]
	 * </p> 
	 * @param sql 参数说明
	 * @param args 参数说明
	 * @return 返回值说明
	 */
	public static String getOutboundResponse(String resultCode,String resultFlag,String resultMsg,String orderId,String logisticsCode,String warehouseCode)
	{
		String response ="";
		try
		{
			QmOutboundResponseDto qmOutboundResponseDto = new QmOutboundResponseDto();
			qmOutboundResponseDto.setCode(resultCode);
			qmOutboundResponseDto.setFlag(resultFlag);
			qmOutboundResponseDto.setMessage(resultMsg);
			qmOutboundResponseDto.setDeliveryOrderId(orderId);
			qmOutboundResponseDto.setLogisticsCode(logisticsCode);
			qmOutboundResponseDto.setWarehouseCode(warehouseCode);
			
			QmOutboundResponseDto.DeliveryOrders order=new QmOutboundResponseDto.DeliveryOrders();
			QmOutboundResponseDto.DeliveryOrders.DeliveryOrder delivery=new QmOutboundResponseDto.DeliveryOrders.DeliveryOrder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			delivery.setCreateTime(sdf.format(new Date()));
			order.setDeliveryOrder(delivery);
			qmOutboundResponseDto.setDeliveryOrders(order);
			response = DtoXmlUtils.DtoToXml(qmOutboundResponseDto);
		}
		catch(Exception ex)
		{
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<response>");
			sb.append("<flag>" + resultFlag + "</flag>");
			sb.append("<code>" + resultCode + "</code>");
			sb.append("<message>" + resultMsg + "</message>");
			sb.append("<deliveryOrderId>" + orderId + "</deliveryOrderId>");
			sb.append("<warehouseCode>" + warehouseCode + "</warehouseCode>");
			sb.append("<logisticsCode>" + logisticsCode + "</logisticsCode>");
			sb.append("</response>");
			response = sb.toString();
		}
		return response;
	}
	/**
	 * 获取Url参数转成Map
	 * 
	 * <p>
	 * Description:[方法功能中文描述]
	 * </p> 
	 * @param sql 参数说明
	 * @param args 参数说明
	 * @return 返回值说明
	 */
	public static Map<String, String> getParamsFromUrl(String url) {

		Map<String, String> requestParams = null;

		try {
			requestParams = new HashMap<String, String>();
			String fullUrl = URLDecoder.decode(url, "UTF-8");

			String[] urls = fullUrl.split("\\?");

			if (urls.length == 2) {

				String[] paramArray = urls[1].split("&");

				for (String param : paramArray) {

					String[] params = param.split("=");

					if (params.length == 2) {

						requestParams.put(params[0], params[1]);

					}

				}

			}

		} catch (UnsupportedEncodingException e) {
			requestParams = null;
		}

		return requestParams;

	}
}
