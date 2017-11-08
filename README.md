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
  1 商品接口得到wms的id记录到自己的商品表，订单接口中itemId传wmsId
  2 所有接口不传itemId,wms通过itemCode匹配（ERP无需记录wmsId,耦合度更小）
 
