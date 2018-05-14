# qm接口对接

## 回调接口文件
QmController
## 商品测试文件
SingleItemTest
## 发货单测试文件
DeliveryOrderTest
## 出货单测试文件
StockOrderTest
## 重要说明:
商品接口itemCode货主唯一<br>
商品ID对接方式<br>
  1 商品接口得到wms的id记录到自己的商品表，订单接口中itemId传wmsId<br>
  2 所有接口不传itemId,wms通过itemCode匹配（ERP无需记录wmsId,耦合度更小）<br>
关于接口的选择<br>
发货接口适用于电商订单，不可部分发货订单<br>
出库接口适用于2B订单支持部分发货和全发控制<br>

## 2018.1.15更新说明
发货确认接口明细添加返回SN<br>
发货确认接口添加多包裹返回<br>
入库确认接口添加多商品形态返回<br>
出库接口添加单价字段<br>

## 2018.2.5更新说明
库存查询接口添加储位返回

## 2018.4.25更新说明
添加商城确认接口

## 2018.4.26更新说明
商品接口添加包装率

## 2018.5.14更新说明
添加php开发示例 php/test.php


### 开始联调
+ 找运维拿到自己的appkey secret customerId 货主编码-ownerCode 仓库编码-warehouseCode 
+ 以商品接口举例修改 SingleItemTest
```
        SingleItem singleItem = new SingleItem();
        singleItem.setActionType("ADD");
        //修改自己的 ownerCode 对应wms货主
        singleItem.setOwnerCode("lt");
        //修改自己的 warehouseCode 对应wms仓库
        singleItem.setWarehouseCode("LTCK");
        Item item = new Item();
        item.setItemCode("000001");
        item.setItemName("000001");
        item.setItemType("ZC");
        item.setBrandName("xxxx品牌");
        item.setBarCode("000001");
        singleItem.setItem(item);
        JAXBContext jc = JAXBContext.newInstance(SingleItem.class);
        Marshaller ms = jc.createMarshaller();
        StringWriter writer = new StringWriter();
        ms.marshal(singleItem, writer);
        String xml = writer.toString();
        
        //修改自己的appKey
        String appKey = "201804261190";
        
        //修改自己的customerId
        String qmCustomerId = "lt";
        
        //修改自己的secret
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
```