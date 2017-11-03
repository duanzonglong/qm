package com.cwms.qm.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

/**
 * 网络工具类。
 * 
 * @author carver.gu
 * @since 1.0, Sep 12, 2009
 */
public abstract class WebUtils
{
    private static Logger logger = Logger.getLogger(WebUtils.class);
    
    private static final String DEFAULT_CHARSET = "UTF-8";
    
    private static final Set<String> aliDomains = new HashSet<String>();
    
    private static final String METHOD_POST = "POST";
    
    private static final String METHOD_GET = "GET";
    
    private static boolean ignoreSSLCheck; // 忽略SSL检查
    
    private static boolean ignoreHostCheck; // 忽略HOST检查

    
    public static class TrustAllTrustManager implements X509TrustManager
    {
        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }
        
        public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException
        {
        }
        
        public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException
        {
        }
    }
    
    private WebUtils()
    {
    }
    
    public static void setIgnoreSSLCheck(boolean ignoreSSLCheck)
    {
        WebUtils.ignoreSSLCheck = ignoreSSLCheck;
    }
    
    public static void setIgnoreHostCheck(boolean ignoreHostCheck)
    {
        WebUtils.ignoreHostCheck = ignoreHostCheck;
    }
    
    /**
     * 执行HTTP POST请求。
     * 
     * @param url 请求地址
     * @param params 请求参数
     * @return 响应字符串
     */
    public static String doPost(String url, Map<String, String> params, int connectTimeout, int readTimeout)
        throws IOException
    {
        return doPost(url, params, DEFAULT_CHARSET, connectTimeout, readTimeout);
    }
    
    public static String doQmPost(String url, String data)
        throws IOException
    {
        int connectTimeout = 600 * 1000;
        int readTimeout = 900 * 1000;
        return doQmPost(url, data, DEFAULT_CHARSET, connectTimeout, readTimeout);
    }
    
    public static String doQmPost(String url, String data, String charset, int connectTimeout, int readTimeout)
        throws IOException
    {
        return doQmPost(url, data, charset, connectTimeout, readTimeout, null);
    }
    
    /**
     * 执行HTTP POST请求。
     * 
     * @param url 请求地址
     * @param params 请求参数
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @return 响应字符串
     */
    public static String doPost(String url, Map<String, String> params, String charset, int connectTimeout,
        int readTimeout)
        throws IOException
    {
        return doPost(url, params, charset, connectTimeout, readTimeout, null);
    }
    
    public static String doQmPost(String url, String data, String charset, int connectTimeout, int readTimeout,
        Map<String, String> headerMap)
        throws IOException
    {
        String ctype = "application/x-www-form-urlencoded;charset=" + charset;
        byte[] content = data.getBytes(charset);
        ;
        return _doPost(url, ctype, content, connectTimeout, readTimeout, headerMap);
    }
    
    public static String doPost(String url, Map<String, String> params, String charset, int connectTimeout,
        int readTimeout, Map<String, String> headerMap)
        throws IOException
    {
        String ctype = "application/x-www-form-urlencoded;charset=" + charset;
        String query = buildQuery(params, charset);
        byte[] content = {};
        if (query != null)
        {
            content = query.getBytes(charset);
        }
        return _doPost(url, ctype, content, connectTimeout, readTimeout, headerMap);
    }
    
    /**
     * 执行HTTP POST请求。
     * 
     * @param url 请求地址
     * @param ctype 请求类型
     * @param content 请求字节数组
     * @return 响应字符串
     */
    public static String doPost(String url, String ctype, byte[] content, int connectTimeout, int readTimeout)
        throws IOException
    {
        return _doPost(url, ctype, content, connectTimeout, readTimeout, null);
    }
    
    private static String _doPost(String url, String ctype, byte[] content, int connectTimeout, int readTimeout,
        Map<String, String> headerMap)
        throws IOException
    {
        HttpURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        try
        {
            try
            {
                conn = getConnection(new URL(url), METHOD_POST, ctype, headerMap);
                conn.setConnectTimeout(connectTimeout);
                conn.setReadTimeout(readTimeout);
            }
            catch (IOException e)
            {
                logger.error("创建HTTP连接时异常", e);
                Map<String, String> map = getParamsFromUrl(url);
                // TaobaoLogger.logCommError(e, url, map.get("app_key"), map.get("method"), content);
                throw e;
            }
            try
            {
                out = conn.getOutputStream();
                out.write(content);
                rsp = getResponseAsString(conn);
            }
            catch (IOException e)
            {
                logger.error("获取响应信息时异常", e);
                Map<String, String> map = getParamsFromUrl(url);
                
                // TaobaoLogger.logCommError(e, conn, map.get("app_key"), map.get("method"), content);
                throw e;
            }
        }
        finally
        {
            if (out != null)
            {
                out.close();
            }
            if (conn != null)
            {
                conn.disconnect();
            }
        }
        
        return rsp;
    }


    

    

    
    private static byte[] getTextEntry(String fieldName, String fieldValue, String charset)
        throws IOException
    {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\"\r\nContent-Type:text/plain\r\n\r\n");
        entry.append(fieldValue);
        return entry.toString().getBytes(charset);
    }
    
    private static byte[] getFileEntry(String fieldName, String fileName, String mimeType, String charset)
        throws IOException
    {
        StringBuilder entry = new StringBuilder();
        entry.append("Content-Disposition:form-data;name=\"");
        entry.append(fieldName);
        entry.append("\";filename=\"");
        entry.append(fileName);
        entry.append("\"\r\nContent-Type:");
        entry.append(mimeType);
        entry.append("\r\n\r\n");
        return entry.toString().getBytes(charset);
    }
    
    /**
     * 执行HTTP GET请求。
     * 
     * @param url 请求地址
     * @param params 请求参数
     * @return 响应字符串
     */
    public static String doGet(String url, Map<String, String> params)
        throws IOException
    {
        return doGet(url, params, DEFAULT_CHARSET);
    }
    
    /**
     * 执行HTTP GET请求。
     * 
     * @param url 请求地址
     * @param params 请求参数
     * @param charset 字符集，如UTF-8, GBK, GB2312
     * @return 响应字符串
     */
    public static String doGet(String url, Map<String, String> params, String charset)
        throws IOException
    {
        HttpURLConnection conn = null;
        String rsp = null;
        
        try
        {
            String ctype = "application/x-www-form-urlencoded;charset=" + charset;
            String query = buildQuery(params, charset);
            try
            {
                conn = getConnection(buildGetUrl(url, query), METHOD_GET, ctype, null);
            }
            catch (IOException e)
            {
                Map<String, String> map = getParamsFromUrl(url);
                // TaobaoLogger.logCommError(e, url, map.get("app_key"), map.get("method"), params);
                logger.error("创建HTTP连接时异常", e);
                throw e;
            }
            
            try
            {
                rsp = getResponseAsString(conn);
            }
            catch (IOException e)
            {
                Map<String, String> map = getParamsFromUrl(url);
                // TaobaoLogger.logCommError(e, conn, map.get("app_key"), map.get("method"), params);
                logger.error("获取响应信息时异常", e);
                throw e;
            }
        }
        finally
        {
            if (conn != null)
            {
                conn.disconnect();
            }
        }
        
        return rsp;
    }
    
    private static HttpURLConnection getConnection(URL url, String method, String ctype, Map<String, String> headerMap)
        throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        if (conn instanceof HttpsURLConnection)
        {
            HttpsURLConnection connHttps = (HttpsURLConnection)conn;
            if (ignoreSSLCheck)
            {
                try
                {
                    SSLContext ctx = SSLContext.getInstance("TLS");
                    ctx.init(null, new TrustManager[] {new TrustAllTrustManager()}, new SecureRandom());
                    connHttps.setSSLSocketFactory(ctx.getSocketFactory());
                    connHttps.setHostnameVerifier(new HostnameVerifier()
                    {
                        public boolean verify(String hostname, SSLSession session)
                        {
                            return true;
                        }
                    });
                }
                catch (Exception e)
                {
                    throw new IOException(e);
                }
            }
            else
            {
                try
                {
                    SSLContext ctx = SSLContext.getInstance("TLS");
                    ctx.init(null, new TrustManager[] {new TrustAllTrustManager()}, new SecureRandom());
                    connHttps.setSSLSocketFactory(ctx.getSocketFactory());
                    if (ignoreHostCheck)
                    {
                        connHttps.setHostnameVerifier(new HostnameVerifier()
                        {
                            public boolean verify(String hostname, SSLSession session)
                            {
                                return true;
                            }
                        });
                    }
                }
                catch (Exception e)
                {
                    throw new IOException(e);
                }
            }
            conn = connHttps;
        }
        
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Host", url.getHost());
        conn.setRequestProperty("Accept", "text/xml,text/javascript");
        conn.setRequestProperty("User-Agent", "top-sdk-java");
        conn.setRequestProperty("Content-Type", ctype);
        if (headerMap != null)
        {
            for (Entry<String, String> entry : headerMap.entrySet())
            {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return conn;
    }
    
    private static URL buildGetUrl(String strUrl, String query)
        throws IOException
    {
        URL url = new URL(strUrl);
        if (StringUtils.isEmpty(query))
        {
            return url;
        }
        
        if (StringUtils.isEmpty(url.getQuery()))
        {
            if (strUrl.endsWith("?"))
            {
                strUrl = strUrl + query;
            }
            else
            {
                strUrl = strUrl + "?" + query;
            }
        }
        else
        {
            if (strUrl.endsWith("&"))
            {
                strUrl = strUrl + query;
            }
            else
            {
                strUrl = strUrl + "&" + query;
            }
        }
        
        return new URL(strUrl);
    }
    
    public static String buildQuery(Map<String, String> params, String charset)
        throws IOException
    {
        if (params == null || params.isEmpty())
        {
            return null;
        }
        
        StringBuilder query = new StringBuilder();
        Set<Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;
        
        for (Entry<String, String> entry : entries)
        {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(value))
            {
                if (hasParam)
                {
                    query.append("&");
                }
                else
                {
                    hasParam = true;
                }
                
                query.append(name).append("=").append(URLEncoder.encode(value, charset));
            }
        }
        
        return query.toString();
    }
    
    protected static String getResponseAsString(HttpURLConnection conn)
        throws IOException
    {
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();
        if (es == null)
        {
            String contentEncoding = conn.getContentEncoding();
            if ("gzip".equalsIgnoreCase(contentEncoding))
            {
                return getStreamAsString(new GZIPInputStream(conn.getInputStream()), charset);
            }
            else
            {
                return getStreamAsString(conn.getInputStream(), charset);
            }
        }
        else
        {
            String msg = getStreamAsString(es, charset);
            if (StringUtils.isEmpty(msg))
            {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            }
            else
            {
                throw new IOException(msg);
            }
        }
    }
    
    public static String getStreamAsString(InputStream stream, String charset)
        throws IOException
    {
        try
        {
            Reader reader = new InputStreamReader(stream, charset);
            StringBuilder response = new StringBuilder();
            
            final char[] buff = new char[1024];
            int read = 0;
            while ((read = reader.read(buff)) > 0)
            {
                response.append(buff, 0, read);
            }
            
            return response.toString();
        }
        finally
        {
            if (stream != null)
            {
                stream.close();
            }
        }
    }
    
    public static String getResponseCharset(String ctype)
    {
        String charset = DEFAULT_CHARSET;
        
        if (!StringUtils.isEmpty(ctype))
        {
            String[] params = ctype.split(";");
            for (String param : params)
            {
                param = param.trim();
                if (param.startsWith("charset"))
                {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2)
                    {
                        if (!StringUtils.isEmpty(pair[1]))
                        {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }
        
        return charset;
    }
    
    /**
     * 使用默认的UTF-8字符集反编码请求参数值。
     * 
     * @param value 参数值
     * @return 反编码后的参数值
     */
    public static String decode(String value)
    {
        return decode(value, DEFAULT_CHARSET);
    }
    
    /**
     * 使用默认的UTF-8字符集编码请求参数值。
     * 
     * @param value 参数值
     * @return 编码后的参数值
     */
    public static String encode(String value)
    {
        return encode(value, DEFAULT_CHARSET);
    }
    
    /**
     * 使用指定的字符集反编码请求参数值。
     * 
     * @param value 参数值
     * @param charset 字符集
     * @return 反编码后的参数值
     */
    public static String decode(String value, String charset)
    {
        String result = null;
        if (!StringUtils.isEmpty(value))
        {
            try
            {
                result = URLDecoder.decode(value, charset);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    
    /**
     * 使用指定的字符集编码请求参数值。
     * 
     * @param value 参数值
     * @param charset 字符集
     * @return 编码后的参数值
     */
    public static String encode(String value, String charset)
    {
        String result = null;
        if (!StringUtils.isEmpty(value))
        {
            try
            {
                result = URLEncoder.encode(value, charset);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    
    private static Map<String, String> getParamsFromUrl(String url)
    {
        Map<String, String> map = null;
        if (url != null && url.indexOf('?') != -1)
        {
            map = splitUrlQuery(url.substring(url.indexOf('?') + 1));
        }
        if (map == null)
        {
            map = new HashMap<String, String>();
        }
        return map;
    }
    
    /**
     * 从URL中提取所有的参数。
     * 
     * @param query URL地址
     * @return 参数映射
     */
    public static Map<String, String> splitUrlQuery(String query)
    {
        Map<String, String> result = new HashMap<String, String>();
        
        String[] pairs = query.split("&");
        if (pairs != null && pairs.length > 0)
        {
            for (String pair : pairs)
            {
                String[] param = pair.split("=", 2);
                if (param != null && param.length == 2)
                {
                    result.put(param[0], param[1]);
                }
            }
        }
        
        return result;
    }
    
    public static Map<String, String> getRequestParameter(String callMethod, String appKey, String loginId)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, String> requestParamter = new HashMap<String, String>();
        requestParamter.put("method", strToUrlEncoder(callMethod));
        requestParamter.put("format", strToUrlEncoder("xml"));
        requestParamter.put("app_key", strToUrlEncoder(appKey));
        requestParamter.put("v", strToUrlEncoder("2.0"));
        requestParamter.put("sign_method", strToUrlEncoder("md5"));
        requestParamter.put("customerId", strToUrlEncoder(loginId));
        requestParamter.put("timestamp", strToUrlEncoder(sdf.format(new Date())));
        
        return requestParamter;
        
    }
    
    private static String strToUrlEncoder(String value)
    {
        String result = value;
        try
        {
            URLEncoder.encode(value, "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            // logger.error("请求参数转换成urlencode时异常", e);
        }
        return result;
    }
    
}
