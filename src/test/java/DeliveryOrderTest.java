import com.cwms.qm.model.outorder.*;
import com.cwms.qm.model.sitem.Item;
import com.cwms.qm.model.sitem.SingleItem;
import com.cwms.qm.util.QimenSignUtils;
import com.cwms.qm.util.WebUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

public class DeliveryOrderTest
{
    private static  final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args)
        throws JAXBException, IOException
    {
        for (int i=0;i<=500;i++)
        {
            create();
        }
    }

    public static void create()
        throws JAXBException, IOException
    {
        DeliveryOrderDto deliveryOrderDto = new DeliveryOrderDto();
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setPlaceOrderTime(sdf.format(new Date()));
        deliveryOrder.setCreateTime(sdf.format(new Date()));
        deliveryOrder.setOperateTime(sdf.format(new Date()));
        deliveryOrder.setDeliveryOrderCode("YGDJ" + (long)(Math.random()*1000000000));
        deliveryOrder.setLogisticsCode("SF");
        deliveryOrder.setOrderType("JYCK");
        deliveryOrder.setWarehouseCode("LTCK");
        deliveryOrder.setShopNick("金林专供");
        deliveryOrder.setSourcePlatformCode("TB");
        ReceiverInfo receiverInfo = new ReceiverInfo();
        receiverInfo.setCountryCode("中国");
        receiverInfo.setProvince("江苏省");
        receiverInfo.setCity("南京市");
        receiverInfo.setArea("江宁区");
        receiverInfo.setDetailAddress("建邺区");
        receiverInfo.setMobile("13888888888");
        receiverInfo.setName("冯金林");
        deliveryOrder.setReceiverInfo(receiverInfo);
        deliveryOrderDto.setDeliveryOrder(deliveryOrder);
        deliveryOrder.setSenderInfo(new SenderInfo());
        OrderLines orderLines = new OrderLines();
        OrderLine item1 = new OrderLine();
        item1.setItemCode("000001");
        item1.setInventoryType("ZP");
        item1.setItemName("000001");
        item1.setOrderLineNo("1");
        item1.setOwnerCode("lt");
        item1.setActualPrice(1d);
        item1.setPlanQty("1");
        orderLines.getOrderLine().add(item1);
        OrderLine item2 = new OrderLine();
        item2.setItemCode("000002");
        item2.setInventoryType("ZP");
        item2.setItemName("000002");
        item2.setOrderLineNo("2");
        item2.setOwnerCode("lt");
        item2.setPlanQty("10");
        item2.setActualPrice(1d);
//        orderLines.getOrderLine().add(item2);
        deliveryOrderDto.setOrderLines(orderLines);
        JAXBContext jc = JAXBContext.newInstance(DeliveryOrderDto.class);
        Marshaller ms = jc.createMarshaller();
        StringWriter writer = new StringWriter();
        ms.marshal(deliveryOrderDto, writer);
        String xml = writer.toString();

        String appKey = "201804261190";

        String qmCustomerId = "lt";

        String secretKey = "RA8wjgCNocNo99IAd5wFFW93Wll1TuRC";

        Map<String, String> requestParamter =
            WebUtils.getRequestParameter("deliveryorder.create", appKey, qmCustomerId);

        String sign = QimenSignUtils.sign(requestParamter, xml, secretKey);
        requestParamter.put("sign", sign);
        String url = "http://c-wms.iask.in:8081/BH_CLIS/qimen" + "?" + QimenSignUtils.joinRequestParams(requestParamter);
        String result = WebUtils.doQmPost(url, xml);

        System.out.println(result);
    }
}
