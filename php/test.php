<?php
/**
 * Created by PhpStorm.
 * User: zhangtao
 * Date: 2018/5/14
 * Time: 下午3:49
 */

include "Qimen.php";
include "SingleitemSynchronizeRequest.php";

$qimen = new Qimen();

$itemDto = new SingleitemSynchronizeRequest;

$itemDto->warehouseCode = "LTCK";
$itemDto->putOtherTextParam("actionType", "ADD");
$itemDto->putOtherTextParam("ownerCode", "lt");
$itemDto->putOtherTextParam("supplierCode", "111");
$itemDto->putOtherTextParam("supplierName", "111");
$itemDto->item->itemCode = '000001';
$itemDto->item->itemName = '000001';
$itemDto->item->itemType = 'ZC';
$itemDto->item->brandName = 'XXX品牌';
$itemDto->item->barCode = '000001,111111';
$jsonStr = json_encode($itemDto);
echo $jsonStr . "\n";
$body = '<?xml version="1.0" encoding="UTF-8" standalone="yes"?><request>' . $qimen->json_to_xml($jsonStr) . '</request>';

$method = "singleitem.synchronize";

$qimen->request("http://c-wms.iask.in:8081/BH_CLIS/qimen", "singleitem.synchronize", $body);