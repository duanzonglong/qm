package com.cwms.qm.controller;

import com.cwms.qm.model.QmOutboundResponseDto;
import com.cwms.qm.model.feedback.DeliveryOrderConfirm;
import com.cwms.qm.util.DtoXmlUtils;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.QimenUtils;
import com.cwms.qm.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

/**
 * Created by duanzonglong on 2017/8/3.
 */
@RestController
public class QmController
{
    private  static  final Logger logger = LoggerFactory.getLogger(QmController.class);

    @RequestMapping(value = "/api/qm")
    public String index(HttpServletRequest request,@RequestBody String requestData)
        throws UnsupportedEncodingException
    {
        String data = URLDecoder.decode(requestData,"UTF-8");
        String requestUrl = request.getRequestURI() + "?" + request.getQueryString();

        Map<String,String> params = QimenUtils.getParamsFromUrl(requestUrl);

        String method = params.get("method");
        String sign = params.get("sign");
        // 第一种使用wms的联调密钥
        // 第二种使用自己的 即给wms发信息时使用的密钥 许告知wms   奇门appKey配置里erp名称配 “自建”
        //下面的是wms联调密钥
        String secretKey = "sandboxcb692c13f0454a328dbfd9742"; // 生产 将另行告知

        String xml = null;

        if (data.indexOf("<") > 0)
        {
            xml = data.substring(data.indexOf("<"));;
        }

        logger.info("接收到的请求为:" + requestUrl);
        logger.info("接收到的报文为:" + xml);

        String response = null;

        try
        {
            String mySign = QimenSignUtils.sign(params, xml, secretKey);

            if (!sign.equals(mySign))
            {
                response = QimenUtils.getCommonResponse("400","failer","签名无效");
            }
            else
            {
                doApi(xml,method);
                response = QimenUtils.getCommonResponse("200","success","处理成功");
            }
        }
        catch (Exception e)
        {
            logger.error("奇门接口处理失败",e);
            response = QimenUtils.getCommonResponse("400","failer","处理失败");
        }

        return  response;
    }

    private void doApi(String requestData, String method) throws Exception {
        if (method.equals("deliveryorder.confirm"))
        {
            //取出报文中的单号
            DeliveryOrderConfirm responseDto = (DeliveryOrderConfirm) DtoXmlUtils.xmlToDto(requestData, DeliveryOrderConfirm.class);
            //调用自己的业务
            // 回调单号  responseDto.getDeliveryOrder().getDeliveryOrderCode()
            //需要回调的明细或包裹信息 请自行从报文中取出
            //处理失败抛错
        }
    }


    private String getReqestData(HttpServletRequest request) {
        String requestData = "";
        BufferedReader br = null;
        try {
            br = request.getReader();
            StringBuilder sbData = new StringBuilder();
			/*String line = null;
			while ((line = br.readLine()) != null) {
				sbData.append(line).append("\n");
			}*/

            char[]buff = new char[1024];
            int len;
            while((len = br.read(buff)) != -1) {
                sbData.append(buff,0, len);
            }

            requestData = sbData.toString();
        } catch (Exception ex) {
            logger.error("获取ERP请求数据异常", ex);
        } finally {
            try {
                br.close();
            } catch (IOException e) {

            }

        }
        return requestData;
    }
}
