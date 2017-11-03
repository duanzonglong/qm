import com.cwms.qm.model.outorder.DeliveryOrderDto;
import com.cwms.qm.model.stockout.*;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.WebUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Map;

public class StockOrderTest
{
    public static void main(String[] args)
        throws JAXBException, IOException
    {
        QmStockoutRequestDto qmStockoutRequestDto = new QmStockoutRequestDto();
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        ReceiverInfo receiverInfo = new ReceiverInfo();
        receiverInfo.setCountryCode("中国");
        receiverInfo.setProvince("江苏省");
        receiverInfo.setCity("南京市");
        receiverInfo.setArea("江宁区");
        receiverInfo.setDetailAddress("建邺区");
        receiverInfo.setMobile("13888888888");
        receiverInfo.setName("冯金林");
        deliveryOrder.setReceiverInfo(receiverInfo);
        qmStockoutRequestDto.setDeliveryOrder(deliveryOrder);
        deliveryOrder.setSenderInfo(new SenderInfo());
        deliveryOrder.setWarehouseCode("legou");
        deliveryOrder.setDeliveryOrderCode("YGXX" + (long)(Math.random()*1000000000));
        deliveryOrder.setOrderType("PTCK");
        deliveryOrder.setLogisticsCode("SF");
        OrderLines orderLines = new OrderLines();
        OrderLine item1 = new OrderLine();
        item1.setItemCode("000001");
        item1.setInventoryType("ZP");
        item1.setItemName("000001");
        item1.setOrderLineNo("1");
        item1.setOwnerCode("legou");
        item1.setPlanQty(BigInteger.valueOf(1));
        orderLines.getOrderLine().add(item1);
        qmStockoutRequestDto.setOrderLines(orderLines);

        JAXBContext jc = JAXBContext.newInstance(QmStockoutRequestDto.class);
        Marshaller ms = jc.createMarshaller();
        StringWriter writer = new StringWriter();
        ms.marshal(qmStockoutRequestDto, writer);
        String xml = writer.toString();
        String appKey = "123456";
        String qmCustomerId = "legou";
        String secretKey = "123456";

        Map<String, String> requestParamter =
            WebUtils.getRequestParameter("stockout.create", appKey, qmCustomerId);

        String sign = QimenSignUtils.sign(requestParamter, xml, secretKey);
        requestParamter.put("sign", sign);
        String url = "http://172.172.172.205:8080/BH_CLIS/qimen" + "?" + QimenSignUtils.joinRequestParams(requestParamter);
        String result = WebUtils.doQmPost(url, xml);

        System.out.println(result);
    }
}
