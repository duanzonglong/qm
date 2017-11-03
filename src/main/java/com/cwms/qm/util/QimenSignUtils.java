package com.cwms.qm.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
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
 * 
 * @author jiangyonghua
 * @version 1.0 2015-11-26
 * @author (lastest modification by )
 * @since 1.0
 */
public class QimenSignUtils
{
    
    /**
     * 生成签名
     * 
     * <p>
     * Description:[方法功能中文描述]
     * </p>
     * 
     * @param sql 参数说明
     * @param args 参数说明
     * @return 返回值说明
     */
    public static String sign(Map<String, String> params, String body, String secretKey)
    {
        
        // 1. 第一步，确保参数已经排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        
        // 2. 第二步，把所有参数名和参数值拼接在一起(包含body体)
        String joinedParams = joinRequestParams(params, body, secretKey, keys);
        
        // 3. 第三步，使用加密算法进行加密（目前仅支持md5算法）
        String signMethod = params.get("sign_method");
        if (!"md5".equalsIgnoreCase(signMethod))
        {
            // TODO
            return null;
        }
        
        byte[] abstractMesaage = digest(joinedParams);
        
        // 4. 把二进制转换成大写的十六进制
        String sign = byte2Hex(abstractMesaage);
        
        return sign;
        
    }
    
    /**
     * 生成请求的sign
     * 
     * <p>
     * Description:[方法功能中文描述]
     * </p>
     * 
     * @param sql 参数说明
     * @param args 参数说明
     * @return 返回值说明
     */
    public static String requestSign(String secretKey)
    {
        byte[] abstractMesaage = digest(secretKey);
        // 4. 把二进制转换成大写的十六进制
        String sign = byte2Hex(abstractMesaage);
        return sign;
        
    }
    
    /**
     * 获取Url参数转成Map
     * 
     * <p>
     * Description:[方法功能中文描述]
     * </p>
     * 
     * @param sql 参数说明
     * @param args 参数说明
     * @return 返回值说明
     */
    private static Map<String, String> getParamsFromUrl(String url)
    {
        
        Map<String, String> requestParams = new HashMap<String, String>();
        
        try
        {
            
            String fullUrl = URLDecoder.decode(url, "UTF-8");
            
            String[] urls = fullUrl.split("\\?");
            
            if (urls.length == 2)
            {
                
                String[] paramArray = urls[1].split("&");
                
                for (String param : paramArray)
                {
                    
                    String[] params = param.split("=");
                    
                    if (params.length == 2)
                    {
                        
                        requestParams.put(params[0], params[1]);
                        
                    }
                    
                }
                
            }
            
        }
        catch (UnsupportedEncodingException e)
        {
            
            // TODO
            
        }
        
        return requestParams;
        
    }
    
    /**
     * 把二进制转换成大写的十六进制
     * 
     * <p>
     * Description:[方法功能中文描述]
     * </p>
     * 
     * @param sql 参数说明
     * @param args 参数说明
     * @return 返回值说明
     */
    private static String byte2Hex(byte[] bytes)
    {
        
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        
        int j = bytes.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (byte byte0 : bytes)
        {
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }
    
    /**
     * 使用加密算法进行加密（目前仅支持md5算法）
     * 
     * <p>
     * Description:[方法功能中文描述]
     * </p>
     * 
     * @param sql 参数说明
     * @param args 参数说明
     * @return 返回值说明
     */
    private static byte[] digest(String message)
    {
        try
        {
            MessageDigest md5Instance = MessageDigest.getInstance("MD5");
            md5Instance.update(message.getBytes("UTF-8"));
            return md5Instance.digest();
        }
        catch (UnsupportedEncodingException e)
        {
            return null;
            
        }
        catch (NoSuchAlgorithmException e)
        {
            return null;
        }
    }
    
    /**
     * 把所有参数名和参数值拼接在一起(包含body体)
     * 
     * <p>
     * Description:[方法功能中文描述]
     * </p>
     * 
     * @param sql 参数说明
     * @param args 参数说明
     * @return 返回值说明
     */
    private static String joinRequestParams(Map<String, String> params, String body, String secretKey,
        String[] sortedKes)
    {
        StringBuilder sb = new StringBuilder(secretKey); // 前面加上secretKey
        for (String key : sortedKes)
        {
            if ("sign".equals(key))
            {
                continue; // 签名时不计算sign本身
                
            }
            else
            {
                String value = params.get(key);
                if (isNotEmpty(key) && isNotEmpty(value))
                {
                    sb.append(key).append(value);
                }
            }
        }
        sb.append(body); // 拼接body体
        sb.append(secretKey); // 最后加上secretKey
        return sb.toString();
    }
    
    private static boolean isNotEmpty(String s)
    {
        
        return null != s && !"".equals(s);
        
    }
    
    /**
     * 把所有参数名和参数值拼接在一起(包含body体)
     * 
     * <p>
     * Description:[方法功能中文描述]
     * </p>
     * 
     * @param sql 参数说明
     * @param args 参数说明
     * @return 返回值说明
     */
    public static String joinRequestParams(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder(); // 前面加上secretKey
        int foreachTotal = 0;
        for (String key : params.keySet())
        {
            String value = strToUrlEncoder(params.get(key));
            if (isNotEmpty(key) && isNotEmpty(value))
            {
                if (foreachTotal == 0)
                {
                    sb.append(key).append("=").append(value);
                }
                else
                {
                    sb.append("&").append(key).append("=").append(value);
                }
                foreachTotal++;
            }
        }
        return sb.toString();
    }
    
    private static String strToUrlEncoder(String value)
    {
        String result = value;
        try
        {
            result = URLEncoder.encode(value, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
        }
        return result;
    }
}
