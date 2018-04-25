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