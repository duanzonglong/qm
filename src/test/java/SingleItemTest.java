import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.cwms.qm.model.sitem.Item;
import com.cwms.qm.model.sitem.SingleItem;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.WebUtils;

/**
 * Created by duanzonglong on 2017/8/3.
 */
public class SingleItemTest
{
    public static void main(String[] args)
        throws JAXBException, IOException
    {
        SingleItem singleItem = new SingleItem();
        singleItem.setActionType("ADD");
        singleItem.setOwnerCode("lt");
        singleItem.setWarehouseCode("LTCK");
        Item item = new Item();
        item.setItemCode("3333");
        item.setItemName("3333");
        item.setItemType("ZC");
        item.setBrandName("xxxx品牌");
        item.setBarCode("123,345678");
        singleItem.setItem(item);
        JAXBContext jc = JAXBContext.newInstance(SingleItem.class);
        Marshaller ms = jc.createMarshaller();
        StringWriter writer = new StringWriter();
        ms.marshal(singleItem, writer);
        String xml = writer.toString();
        
        String appKey = "201804261190";
        
        String qmCustomerId = "lt";
        
        String secretKey = "RA8wjgCNocNo99IAd5wFFW93Wll1TuRC";
        
        Map<String, String> requestParamter =
            WebUtils.getRequestParameter("singleitem.synchronize", appKey, qmCustomerId);
        
        String sign = QimenSignUtils.sign(requestParamter, xml, secretKey);
        requestParamter.put("sign", sign);
        String url =
            "http://c-wms.iask.in:8081/BH_CLIS/qimen" + "?" + QimenSignUtils.joinRequestParams(requestParamter);
        String result = WebUtils.doQmPost(url, xml);
        System.out.println("请求URL:" + url + "请求报文:" + xml);
        System.out.println(result);
        
    }
}
