import com.cwms.qm.model.CustomerRequestDto;
import com.cwms.qm.model.sitem.Item;
import com.cwms.qm.model.sitem.SingleItem;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.WebUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by duanzonglong on 2017/8/3.
 */
public class CustomerTest
{
    public static void main(String[] args)
        throws JAXBException, IOException
    {
        CustomerRequestDto customerRequestDto = new CustomerRequestDto();
        customerRequestDto.setCountry("中国");
        customerRequestDto.setProvince("江苏省");
        customerRequestDto.setCity("南京市");
        customerRequestDto.setDistrict("雨花台区");
        customerRequestDto.setContactor("张三");
        customerRequestDto.setCustomerCode("DPB001");
        customerRequestDto.setCustomerName("海鲜大咖");
        JAXBContext jc = JAXBContext.newInstance(CustomerRequestDto.class);
        Marshaller ms = jc.createMarshaller();
        StringWriter writer = new StringWriter();
        ms.marshal(customerRequestDto, writer);
        String xml = writer.toString();

        String appKey = "dongpingbang";

        String qmCustomerId = "DBP";

        String secretKey = "1234567890";

        Map<String, String> requestParamter =
            WebUtils.getRequestParameter("customer.sync", appKey, qmCustomerId);

        String sign = QimenSignUtils.sign(requestParamter, xml, secretKey);
        requestParamter.put("sign", sign);
        String url = "http://155o313k01.iask.in:12983/BH_CLIS/qimen" + "?" + QimenSignUtils.joinRequestParams(requestParamter);
        String result = WebUtils.doQmPost(url, xml);

        System.out.println(result);

    }
}
