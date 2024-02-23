package com.unitymain.core;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
//        String result = "{\"data\":[{\"currentNode\":{\"busiCode\":\"model-011-001\",\"code\":\"40289eda6d75a12f016dbdc29b760bdb\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdba15100bd1\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dbdc29b760bdb\",\"name\":\"市场出清1\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{\"FUNC_URL\":\"/pxf-trade-medium/marcleanHome/homePage\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-trade-medium/marcleanHome/homePage\"},\"name\":\"市场出清1\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"model-011-001-002\",\"code\":\"40289eda6d75a12f016dbdecd9e30c38\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdc29b760bdb\",\"funcOtherInfo\":\"/pxf-contract-management/HomePage\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dbdecd9e30c38\",\"name\":\"合同1\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/HomePage\",\"PS\":\"/pxf-contract-management/HomePage\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/HomePage\"},\"name\":\"合同1\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"model-011-001-002-001\",\"code\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdecd9e30c38\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"name\":\"合同生成管理1\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\"},\"name\":\"合同生成管理1\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"model-011-001-002-001-001\",\"code\":\"40289eda6d75a12f016dc81b24cf0db7\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dc81b24cf0db7\",\"name\":\"合同生成管理1\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/generatingContract\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/generatingContract\"},\"name\":\"合同生成管理1\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"snrghtlr\",\"code\":\"40289e057ed20317017f971240206c48\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289e057ed20317017f971240206c48\",\"name\":\"省内人工合同录入1\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/contractInnerInput\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-contract-management/contractInnerInput\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/contractInnerInput\"},\"name\":\"省内人工合同录入1\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"hhhh12435\",\"code\":\"40289e057ed20317017f9714d6ac6e67\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289e057ed20317017f9714d6ac6e67\",\"name\":\"菜单名省内合同变更1\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/provinContractInfoManagement\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-contract-management/provinContractInfoManagement\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/provinContractInfoManagement\"},\"name\":\"菜单名省内合同变更1\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"2334234\",\"code\":\"40289e057ed20317017fd4b5e44f3ca5\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289e057ed20317017fd4b5e44f3ca5\",\"name\":\"龙江合同变更管理1\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-pdblj-contract-imanagement/provinContractInfoManagement\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-pdblj-contract-imanagement/provinContractInfoManagement\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-pdblj-contract-imanagement/provinContractInfoManagement\"},\"name\":\"龙江合同变更管理1\",\"nextNode\":[]}]}]},{\"currentNode\":{\"busiCode\":\"123abc\",\"code\":\"40289e057ed2031701802c944b856680\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdc29b760bdb\",\"funcType\":\"01\",\"id\":\"40289e057ed2031701802c944b856680\",\"name\":\"青海差异化合同\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\"},\"name\":\"青海差异化合同1\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"112233\",\"code\":\"40289e057ed203170180409f2b7272a9\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed203170180409f2b7272a9\",\"name\":\"合同信息推送发改委1\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-dif-contract-management/sendContractBaseInfoSinsei\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-dif-contract-management/sendContractBaseInfoSinsei\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-dif-contract-management/sendContractBaseInfoSinsei\"},\"name\":\"合同信息推送发改委1\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"223344\",\"code\":\"40289e057ed20317018040a0094072b3\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed20317018040a0094072b3\",\"name\":\"合同电量统计分析1\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-dif-trade-medium/trPxbqhUserContract/TrPxbqhUserContract\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-dif-trade-medium/trPxbqhUserContract/TrPxbqhUserContract\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-dif-trade-medium/trPxbqhUserContract/TrPxbqhUserContract\"},\"name\":\"合同电量统计分析1\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"334455\",\"code\":\"40289e057ed20317018040a0a87b72bd\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed20317018040a0a87b72bd\",\"name\":\"统计月度市场化交易1（new）\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-dif-trade-medium/trPxbqhTradeReport/TrQhTradeReportNew\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-dif-trade-medium/trPxbqhTradeReport/TrQhTradeReportNew\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-dif-trade-medium/trPxbqhTradeReport/TrQhTradeReportNew\"},\"name\":\"统计月度市场化交易1（new）\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"556677\",\"code\":\"40289e057ed20317018040a14aae72c7\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed20317018040a14aae72c7\",\"name\":\"交易单元管理差异化1\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-qh-trade-medium/trade-unit/TradeUnitManage\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-qh-trade-medium/trade-unit/TradeUnitManage\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-qh-trade-medium/trade-unit/TradeUnitManage\"},\"name\":\"交易单元管理差异化1\",\"nextNode\":[]}]}]}," +
//                "{\"currentNode\":{\"busiCode\":\"model-011-001\",\"code\":\"40289eda6d75a12f016dbdc29b760bdb\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdba15100bd1\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dbdc29b760bdb\",\"name\":\"市场出清2\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{\"FUNC_URL\":\"/pxf-trade-medium/marcleanHome/homePage\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-trade-medium/marcleanHome/homePage\"},\"name\":\"市场出清2\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"model-011-001-002\",\"code\":\"40289eda6d75a12f016dbdecd9e30c38\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdc29b760bdb\",\"funcOtherInfo\":\"/pxf-contract-management/HomePage\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dbdecd9e30c38\",\"name\":\"合同2\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/HomePage\",\"PS\":\"/pxf-contract-management/HomePage\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/HomePage\"},\"name\":\"合同2\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"model-011-001-002-001\",\"code\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdecd9e30c38\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"name\":\"合同生成管理2\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\"},\"name\":\"合同生成管理2\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"model-011-001-002-001-001\",\"code\":\"40289eda6d75a12f016dc81b24cf0db7\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289eda6d75a12f016dc81b24cf0db7\",\"name\":\"合同生成管理2\",\"nodeId\":\"8a23694f424b956e01424c4298330006\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/generatingContract\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/generatingContract\"},\"name\":\"合同生成管理2\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"snrghtlr\",\"code\":\"40289e057ed20317017f971240206c48\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289e057ed20317017f971240206c48\",\"name\":\"省内人工合同录入2\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/contractInnerInput\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-contract-management/contractInnerInput\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/contractInnerInput\"},\"name\":\"省内人工合同录入2\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"hhhh12435\",\"code\":\"40289e057ed20317017f9714d6ac6e67\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289e057ed20317017f9714d6ac6e67\",\"name\":\"菜单名省内合同变更2\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-contract-management/provinContractInfoManagement\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-contract-management/provinContractInfoManagement\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-contract-management/provinContractInfoManagement\"},\"name\":\"菜单名省内合同变更2\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"2334234\",\"code\":\"40289e057ed20317017fd4b5e44f3ca5\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dc816cf1b0d7b\",\"funcType\":\"01\",\"id\":\"40289e057ed20317017fd4b5e44f3ca5\",\"name\":\"龙江合同变更管理2\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-pdblj-contract-imanagement/provinContractInfoManagement\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-pdblj-contract-imanagement/provinContractInfoManagement\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-pdblj-contract-imanagement/provinContractInfoManagement\"},\"name\":\"龙江合同变更管理2\",\"nextNode\":[]}]}]},{\"currentNode\":{\"busiCode\":\"123abc\",\"code\":\"40289e057ed2031701802c944b856680\",\"funcCategory\":\"01\",\"funcId\":\"40289eda6d75a12f016dbdc29b760bdb\",\"funcType\":\"01\",\"id\":\"40289e057ed2031701802c944b856680\",\"name\":\"青海差异化合同\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\"},\"name\":\"青海差异化合同2\",\"nextNode\":[{\"currentNode\":{\"busiCode\":\"112233\",\"code\":\"40289e057ed203170180409f2b7272a9\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed203170180409f2b7272a9\",\"name\":\"合同信息推送发改委2\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-dif-contract-management/sendContractBaseInfoSinsei\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-dif-contract-management/sendContractBaseInfoSinsei\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-dif-contract-management/sendContractBaseInfoSinsei\"},\"name\":\"合同信息推送发改委2\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"223344\",\"code\":\"40289e057ed20317018040a0094072b3\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed20317018040a0094072b3\",\"name\":\"合同电量统计分析2\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-dif-trade-medium/trPxbqhUserContract/TrPxbqhUserContract\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-dif-trade-medium/trPxbqhUserContract/TrPxbqhUserContract\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-dif-trade-medium/trPxbqhUserContract/TrPxbqhUserContract\"},\"name\":\"合同电量统计分析2\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"334455\",\"code\":\"40289e057ed20317018040a0a87b72bd\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed20317018040a0a87b72bd\",\"name\":\"统计月度市场化交易2（new）\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-dif-trade-medium/trPxbqhTradeReport/TrQhTradeReportNew\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-dif-trade-medium/trPxbqhTradeReport/TrQhTradeReportNew\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-dif-trade-medium/trPxbqhTradeReport/TrQhTradeReportNew\"},\"name\":\"统计月度市场化交易2（new）\",\"nextNode\":[]},{\"currentNode\":{\"busiCode\":\"556677\",\"code\":\"40289e057ed20317018040a14aae72c7\",\"funcCategory\":\"01\",\"funcId\":\"40289e057ed2031701802c944b856680\",\"funcType\":\"01\",\"id\":\"40289e057ed20317018040a14aae72c7\",\"name\":\"交易单元管理差异化2\",\"nodeId\":\"40289eda6d75a12f016e44e7b5d36fab\",\"resExt\":{\"FUNC_URL\":\"/pxf-qh-trade-medium/trade-unit/TradeUnitManage\",\"absoluteURL\":\"http://localhost:9000/px-common-identity/user1/test/pxf-qh-trade-medium/trade-unit/TradeUnitManage\"},\"systemId\":\"8a23694f424b956e01424b99dc5c0004\",\"url\":\"/pxf-qh-trade-medium/trade-unit/TradeUnitManage\"},\"name\":\"交易单元管理差异化2\",\"nextNode\":[]}]}]}]," +
//                "\"message\":\"Success\",\"status\":0}";
        String result = FileUtil.readString("/Users/panyuanbiao/Documents/work/UmBoot/src/test/java/com/unitymain/core/demo.json", Charset.forName("UTF-8"));

        // 新建一个List存放解析的json数据用于返回前台
        List<JSONObject> list = new ArrayList<>();
        // 开始解析Json
        JSONObject resultObj = JSONUtil.parseObj(result);
        List<Integer> deleteIndex = new ArrayList<>();
        // 判断转换过的json对象是否为空
        if (resultObj != null && !resultObj.isEmpty()) {
            // 获取json数组data
            JSONArray dataArr = resultObj.getJSONArray("data");
            for (Object obj : dataArr) {
                JSONObject jsonobj = (JSONObject) obj;
                jsonobj.set("root", true);
            }
//            id -> 40289eda6d75a12f016dc816cf1b0d7b
            // 开始递归
//            id -> 40289eda6d75a12f016dc81b24cf0db7




            getNextNode(dataArr, list,deleteIndex, "0");
        }
//        List<Integer> collect = deleteIndex.stream().distinct().sorted().collect(Collectors.toList());

        for (int i=deleteIndex.size()-1;i>=0;i--){
           list.remove(deleteIndex.get(i));
        }
        System.out.println(list);


    }

    /**
     * 递归调用
     *
     * @return
     */
    private static void getNextNode(JSONArray nextNode, List<JSONObject> list,List<Integer> deleteIndex, String parentId) {
        if (nextNode != null && nextNode.size() > 0) {
            int k = 0;
            for (Object item : nextNode) {
                k++;
                JSONObject dataItem = (JSONObject) item;
                // 获取当前节点CurrentNode
                JSONObject currentNode = dataItem.getJSONObject("currentNode");
                if (currentNode != null && !currentNode.isEmpty()) {
                    if (dataItem.getBool("root") != null && dataItem.getBool("root")) {
                        JSONObject treeNode = new JSONObject();
                        treeNode.set("name", dataItem.getStr("name"));
                        treeNode.set("id", currentNode.getStr("id"));
                        list.add(treeNode);
                    } else {
//                        JSONObject resExt = currentNode.getJSONObject("resExt");

//                        JSONArray nextNode1 = dataItem.getJSONArray("nextNode");
                        /*//有子节点
                        if (nextNode1 != null && !nextNode1.isEmpty()) {
                            tianjia(k, list, currentNode, parentId,deleteIndex);
                        }
                        //是叶子节点
                        else {
                            //是菜单，且是叶子节点
                            if (resExt != null && !resExt.isEmpty()) {
                                tianjia(k, list, currentNode, parentId,deleteIndex);
                            } else {
                                //todo 不要这一条数据
                            }

                        }*/
                        tianjia(k, list, currentNode, parentId,deleteIndex);
                    }

                    // 获取下一级节点nextNode
                    JSONArray nextNode2 = dataItem.getJSONArray("nextNode");
                    String parentIds = currentNode.getStr("id");
                    if (nextNode2 != null && !nextNode2.isEmpty()) {
                        getNextNode(nextNode2, list,deleteIndex, parentIds);
                    }
                }
            }
        }
    }


    public static void tianjia(int k, List<JSONObject> list, JSONObject currentNode, String parentId,List<Integer> deleteIndex) {
        JSONObject resExt = currentNode.getJSONObject("resExt");
        int size = list.size();
        JSONObject result = null;
        int i = 0;
        for (; i < list.size(); i++) {
            result = findParentNode(list.get(i), parentId);
            if (result != null && !result.isEmpty()) {
                break;
            }
        }

        if (result != null) {
            if (resExt == null || resExt.isEmpty()) {
                deleteIndex.add(size);
            }

            JSONObject newResult = JSONUtil.parseObj(list.get(i).toString());
            JSONObject leaf = findLeaf(newResult);

            JSONObject treeNode = new JSONObject();
            treeNode.set("name", currentNode.getStr("name"));
            treeNode.set("id", currentNode.getStr("id"));
            leaf.append("nextNode", treeNode);

            list.add(newResult);
        }
    }


    private static JSONObject findParentNode(JSONObject tree, String parentId) {
        if (tree != null && !tree.isEmpty()) {
            JSONArray nextNode = tree.getJSONArray("nextNode");
            if (nextNode == null || nextNode.isEmpty()) {
                String id = tree.getStr("id");
                if (StrUtil.equals(id, parentId)) {
                    return tree;
                }
            } else {
                for (int i = 0; i < nextNode.size(); i++) {
                    JSONObject childNode = nextNode.getJSONObject(i);
                    return findParentNode(childNode, parentId);
                }
            }
        }
        return null;
    }

    private static JSONObject findLeaf(JSONObject tree) {
        if (tree != null && !tree.isEmpty()) {
            JSONArray nextNode = tree.getJSONArray("nextNode");
            if (nextNode == null || nextNode.isEmpty()) {
                return tree;
            } else {
                for (int i = 0; i < nextNode.size(); i++) {
                    JSONObject childNode = nextNode.getJSONObject(i);
                    return findLeaf(childNode);
                }
            }
        }
        return null;
    }
}
