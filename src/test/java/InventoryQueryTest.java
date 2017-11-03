import com.cwms.qm.model.CustomerRequestDto;
import com.cwms.qm.model.inventory.Criteria;
import com.cwms.qm.model.inventory.CriteriaList;
import com.cwms.qm.model.inventory.QmInventoryQueryRequest;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.WebUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by duanzonglong on 2017/8/18.
 */
public class InventoryQueryTest
{
    public static void main(String[] args)
        throws JAXBException, IOException
    {
        QmInventoryQueryRequest inventoryQueryRequest = new QmInventoryQueryRequest();
        CriteriaList criteriaList = new CriteriaList();
        inventoryQueryRequest.setCriteriaList(criteriaList);
        Criteria criteria = new Criteria();
        criteria.setInventoryType("ZP");
        criteria.setItemCode("DPB002001");
        criteria.setOwnerCode("DPB002");
        criteriaList.getCriteria().add(criteria);
        JAXBContext jc = JAXBContext.newInstance(QmInventoryQueryRequest.class);
        Marshaller ms = jc.createMarshaller();
        StringWriter writer = new StringWriter();
        ms.marshal(inventoryQueryRequest, writer);
        String xml = writer.toString();

        String appKey = "dongpingbang";

        String qmCustomerId = "DBP";

        String secretKey = "1234567890";

        Map<String, String> requestParamter =
            WebUtils.getRequestParameter("inventory.query", appKey, qmCustomerId);

        String sign = QimenSignUtils.sign(requestParamter, xml, secretKey);
        requestParamter.put("sign", sign);
        String url = "http://172.172.172.205:8080/BH_CLIS/qimen" + "?" + QimenSignUtils.joinRequestParams(requestParamter);
        String result = WebUtils.doQmPost(url, xml);

        System.out.println(result);

    }
}
