package com.wenqiang.springcloud.controller;

import cn.hutool.db.handler.HandleHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wenqiang.springcloud.entities.CommonResult;
import com.wenqiang.springcloud.entities.Payment;
import com.wenqiang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("all")
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //新增
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"新增成功！8001",payment);
        }
        return new CommonResult(404,"新增失败！",null);
    }
    //通过id进行查询
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果为：****");
        if(payment!=null){
            return new CommonResult(200,"查询成功8001",payment);
        }
        return new CommonResult(444,"查询失败",null);
    }


//    public static void main(String[] args) {
//
////        Payment payment1 = new Payment();
////        payment1.setId(1L);
////        payment1.setSerial("1");
////        Payment payment2 = new Payment();
////        payment2.setId(2L);
////        payment2.setSerial("2");
////        Payment payment3 = new Payment();
////        payment3.setId(3L);
////        payment3.setSerial("3");
////        Payment payment4 = new Payment();
////        payment4.setId(2L);
////        payment4.setSerial("4");
////
////        List<Payment> list = new ArrayList();
////        list.add(payment2);
////        list.add(payment1);
////        list.add(payment3);
////        list.add(payment4);
////
////        System.out.println(list);
////
//////        Method getAttributeMethod = null;
//////        try {
//////            getAttributeMethod = Payment.class.getDeclaredMethod("getId");
//////            Object invoke = getAttributeMethod.invoke(payment2);
//////            System.out.println("invoke " + invoke);
//////        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//////            e.printStackTrace();
//////        }
////
////
////        Function<Payment, Long> getId = x -> {
////            Method getAttributeMethod = null;
////            Long invoke = null;
////            try {
////                getAttributeMethod = Payment.class.getDeclaredMethod("getId");
////                invoke = (Long) getAttributeMethod.invoke(x);
////            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
////                e.printStackTrace();
////            }
////            return invoke;
////        };
////        List<Payment> collect = list.stream().sorted(Comparator.comparing(getId)).collect(Collectors.toList());
////
////
////
////
////
////        Function<Payment, String> getSerial = x -> {
////            Method getAttributeMethod = null;
////            String invoke = null;
////            try {
////                getAttributeMethod = Payment.class.getDeclaredMethod("getSerial");
////                invoke = (String) getAttributeMethod.invoke(x);
////            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
////                e.printStackTrace();
////            }
////            return invoke;
////        };
////
////        Comparator<Payment> paymentComparator = Comparator.comparing(Payment::getId);
////        Method declaredMethod1 = null;
////        Comparator<Payment> invoke = null;
////        try {
////            declaredMethod1 = Comparator.class.getDeclaredMethod("thenComparing", Function.class);
////            invoke = (Comparator<Payment>)declaredMethod1.invoke(paymentComparator, getSerial);
////        } catch (NoSuchMethodException e) {
////            e.printStackTrace();
////        } catch (IllegalAccessException e) {
////            e.printStackTrace();
////        } catch (InvocationTargetException e) {
////            e.printStackTrace();
////        }
////
////
////        List<Payment> collect1 = list.stream().sorted(invoke).collect(Collectors.toList());
////
////        System.out.println(collect);
////        System.out.println(collect1);
////
////        int pageNum = 2;
////        int rowNum = 3;
//
//
//
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("id", "9.2423424");
//        Map<String, Object> map2 = new HashMap<>();
//        map2.put("id", "7.2443424");
//        Map<String, Object> map3 = new HashMap<>();
//        map3.put("id", "8.2443424");
//        Map<String, Object> map4 = new HashMap<>();
//        map4.put("id", "7.2423424");
//
//
//
//        List<Map<String, Object>> list = new ArrayList();
//        list.add(map2);
//        list.add(map1);
//        list.add(map3);
//        list.add(map4);
//
////        List<Map<String, Object>> rows = getRows(pageNum, rowNum, list);
////        System.out.println("page: " + rows);
//
//        Function<Map<String, String>, Float> getId = x -> {
//            String invoke = x.get("id");
//            return Float.valueOf(invoke);
//        };
//        Function<Map<String, Object>, Float> fun = x -> {
//            String invoke = x.get("id").toString();
//            return Float.valueOf(invoke);
//        };
//        Comparator<Map<String, Object>> id = Comparator.comparing(fun);
//        List<Map<String, Object>> collect = list.stream().sorted(id.reversed()).collect(Collectors.toList());
//        System.out.println(collect);
//
//
//
//
//
//    }


//    public static void main(String[] args) {
//
//        JsonObject resp = new JsonObject();
//
//
//        JsonObject object = new JsonObject();
//        object.addProperty("id",1);
//        object.addProperty("age",14);
//        JsonObject object2 = new JsonObject();
//        object2.addProperty("id",2);
//        object2.addProperty("age",15);
//        JsonObject object3 = new JsonObject();
//        object3.addProperty("id",3);
//        object3.addProperty("age",14);
//
//        JsonArray jsonElements = new JsonArray();
//        jsonElements.add(object);
//        jsonElements.add(object2);
//        jsonElements.add(object3);
//
//
//
//        JsonArray jsonElements1 = new JsonArray();
//
//        Gson gson = new Gson();
//        List list = gson.fromJson(jsonElements, List.class);
//
//        for (Object obj: list) {
//            JsonElement jsonElement = gson.toJsonTree(obj);
//            jsonElements1.add(jsonElement);
//
//        }
//
//
//        Map map = gson.fromJson(resp, Map.class);
//        map.put("list", list);
//
//        String json =new Gson().toJson(map);
//        resp =new JsonParser().parse(json).getAsJsonObject();
//
//
//        System.out.println(resp);
//
//    }


    public static void main(String[] args) {
        Map<String, Object> objectMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        Object o = objectMap.get("");
        if(o != null) {
            stringBuilder.append(o.toString());
        }
        String a = stringBuilder.append("a").toString();


        StringBuilder stringBuilder1 = new StringBuilder();
        String a1 = stringBuilder1.append("a").toString();

        System.out.println(a.equals(a1));

    }



    private static List<Map<String, Object>> getRows(int pageNum, int rowsNum, List<Map<String, Object>> datas) {

        int startNum = (pageNum - 1) * rowsNum;
        int endNum = startNum + rowsNum;
        endNum = endNum > datas.size() ? datas.size() : endNum;
        List<Map<String, Object>> objects = datas.subList(startNum, endNum);
        return objects;


    }





}