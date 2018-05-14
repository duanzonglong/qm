<?php
/**
 * Created by PhpStorm.
 * User: zhangtao
 * Date: 2018/5/14
 * Time: 下午3:48
 */

class Qimen
{
    private $secret = 'RA8wjgCNocNo99IAd5wFFW93Wll1TuRC';          // 奇门提供的安全码(签名用)

    private $param = array(                      // 按接口提供的逐一填写
        "format" => 'xml',
        "app_key" => '201804261190',
        "v" => '2.0',
        "sign_method" => 'md5',
        "customerId" => 'lt',
    );

    /**
     * 签名
     * @param $secret  安全码
     * @param $param   提交参数
     * @param $body     提交文档内容
     */
    public function sign($secret, $param, $body)
    {
        if (empty($body)) {
            exit('Body can\'t empty!');
        }

        if (empty($secret)) {
            exit('Secret error!');
        }

        ksort($param);
        $outputStr = '';
        foreach ($param as $k => &$v) {
            if (empty($v)) {
                exit('Param can\'t error!');
            }
            $outputStr .= $k . $v;
        }

        $outputStr = $secret . $outputStr . $body . $secret;
        return strtoupper(md5($outputStr));
    }

    // 业务逻辑
    public function request($baseUrl, $method, $body)
    {
        $this->param['method'] = $method;                                           // 此处填写要应对应BODY，具体参考白皮书的 ‘ERP调用的奇门API名称’
        $this->param['timestamp'] = date("Y-m-d H:i:s");                               // 时间
        $this->param['sign'] = $this->sign($this->secret, $this->param, $body);   // 利用body签名
        $url = $baseUrl . "?" . http_build_query($this->param);
        echo $url . "\n";
        echo $body . "\n";
        $return = $this->httpCurl($url, $body, 'post');

        echo $return . "\n";

    }

    /**
     * 请求数据
     * @param $url             请求地址
     * @param $data        提交数据
     * @param $requestType  请求类型
     */
    public function httpCurl($url, $data, $requestType = 'get')
    {
        //初始化curl
        $ch = curl_init();
        //设置超时
        curl_setopt($ch, CURLOPT_TIMEOUT, 30);
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_SSLVERSION, CURL_SSLVERSION_TLSv1);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);
        curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, FALSE);
        curl_setopt($ch, CURLOPT_HEADER, FALSE);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, TRUE);
        if (strtolower($requestType) == 'post') {
            curl_setopt($ch, CURLOPT_POST, 1);
            curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        }
        $return = curl_exec($ch);
        curl_close($ch);
        return $return;
    }

    public function json_to_xml($source, $charset = 'utf8')
    {
        if (empty($source)) {
            return false;
        }
        //php5，以及以上，如果是更早版本，请查看JSON.php
        $array = json_decode($source);
        $xml = '';
        $xml .= $this->change($array);
        return $xml;
    }

    public function change($source)
    {
        $string = "";
        foreach ($source as $k => $v) {
            $string .= "<" . $k . ">";
            //判断是否是数组，或者，对像
            if (is_array($v) || is_object($v)) {
                //是数组或者对像就的递归调用
                $string .= $this->change($v);
            } else {
                //取得标签数据
                $string .= $v;
            }
            $string .= "</" . $k . ">";
        }
        return $string;
    }

    public function xml_to_json($source)
    {
        if (is_file($source)) { //传的是文件，还是xml的string的判断
            $xml_array = simplexml_load_file($source);
        } else {
            $xml_array = simplexml_load_string($source);
        }
        $json = json_encode($xml_array); //php5，以及以上，如果是更早版本，请查看JSON.php
        return $json;
    }
}