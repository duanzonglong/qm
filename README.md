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

## 接口开发顺序
+ 商品接口 4.1
+ 入库单接口 4.3
+ 入库单反馈接口 4.4
+ 出库或发货单接口 4.7或4.9
+ 出库或发货单反馈接口 4.8或4.10 并一一对应
+ 取消接口 4.14 含所有单据取消
+ 退货入库单同步接口 4.5
+ 退货入库单确认接口 4.6
+ 库存盘点通知4.16或库存异动通知接口4.17 二选一即可(wms发起的损益反馈给ERP)

## 关于多仓多货主说明
1 wms支持 一个APPKEY一个货主(customerId和ownerCode一样) ERP和WMS同步新增货主 wms还需要同步新增奇门配置
2 一个APPKY多个货主（customerId不变ownerCode变，可以使用货主同步接口自动同步货主）

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

## 2018.6.12更新说明
采购单反馈添加供应商

## 2018.7.6更新说明
更新上架回调接口

## 2018.7.20更新说明
更新订单修改接口

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