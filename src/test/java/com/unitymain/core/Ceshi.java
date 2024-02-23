package com.unitymain.core;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.unitymain.core.entity.SysOperate;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Ceshi {

    @Test
    public void test1() throws ParseException {
        String dateStr = "2022-04-02T02:02:53.981 UTC";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date date = dateFormat.parse(dateStr);
        System.out.println(date);
    }

    @Test
    public void test2() {
        SysOperate operate = new SysOperate();
        operate.setCode("测试测试");
        String[] test = {"123", "321"};
        System.out.println(operate);
        System.out.println(test);
        Console.log("测试测试:{}", operate);
        Console.log(test);
        Console.log(operate);
    }

    @Test
    public void test3() {
        System.setProperty("proxyHost", "127.0.0.1");
        System.setProperty("proxyPort", "7890");
        HttpResponse execute = HttpRequest.get("https://www.youtube.com").execute();
        Console.log(execute.body());
    }

    @Test
    public void test4() {
        Student student = new Student();
//        student.setName("小明");
        Student student1 = null;
        Student student2 = new Student();
        boolean bool1 = BeanUtil.isNotEmpty(student);
        boolean bool2 = BeanUtil.isNotEmpty(student1);
        boolean bool3 = BeanUtil.isNotEmpty(student2);
        Console.log(bool1);
        Console.log(bool2);
        Console.log(bool3);
    }

    @Test
    public void test5() {
        Student student = new Student();
//        student.setName("小明");
        JSONUtil.toJsonStr(student);
    }

    @Test
    public void test6() {
        String s = IdUtil.nanoId();
        Console.log(s);
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("23", "3", "325");
        Collections.sort(list);
        Console.log(list);
    }

    @Test
    public void test8() {
        User user = new User();
        user.setId(1);
        user.setPrims(Arrays.asList("车","马","象"));

        User user1 = new User();
        user1.setId(2);
        user1.setPrims(Arrays.asList("车","士"));

        User user2 = new User();
        user2.setId(3);
        user2.setPrims(Arrays.asList("王","炮","象","马"));


        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);

        List<String> strings = list.stream()
                .flatMap(user3 -> user3.getPrims().stream())
                .distinct().collect(Collectors.toList());
//                .collect(Collectors.groupingBy(String::toString
//                        ,Collectors.counting()));
//        List<String> collect = list.stream()
//                .map(User::getPrims)
//                .map((String)::toString)
//                .collect(Collectors.toList());

        Console.log(strings);
    }

    @Test
    public void test9() {
        List<Integer> list = new ArrayList<>();
        for(int i=0 ;i<1000;i++){
            list.add(i);
        }
    }


    @Test
    public void test10(){
        byte[] demo =  HexUtil.decodeHex("08c34e109bc6c8bf9a30180520013a027062429e0508e90710c34e1a05302e342e312200280330013a0e373734376639653a6d61737465724209c23e060800100118014a01305a09646f7579696e5f70637a130a0b73657373696f6e5f6169641204363338337a100a0b73657373696f6e5f6469641201307a150a086170705f6e616d651209646f7579696e5f70637a150a0f7072696f726974795f726567696f6e1202636e7a83010a0a757365725f6167656e7412754d6f7a696c6c612f352e3020284d6163696e746f73683b20496e74656c204d6163204f5320582031305f31355f3729204170706c655765624b69742f3533372e333620284b48544d4c2c206c696b65204765636b6f29204368726f6d652f3130332e302e302e30205361666172692f3533372e33367a160a0e636f6f6b69655f656e61626c65641204747275657a190a1062726f777365725f6c616e677561676512057a682d434e7a1c0a1062726f777365725f706c6174666f726d12084d6163496e74656c7a170a0c62726f777365725f6e616d6512074d6f7a696c6c617a80010a0f62726f777365725f76657273696f6e126d352e3020284d6163696e746f73683b20496e74656c204d6163204f5320582031305f31355f3729204170706c655765624b69742f3533372e333620284b48544d4c2c206c696b65204765636b6f29204368726f6d652f3130332e302e302e30205361666172692f3533372e33367a160a0e62726f777365725f6f6e6c696e651204747275657a140a0c73637265656e5f77696474681204313238307a140a0d73637265656e5f68656967687412033830307a0b0a077265666572657212007a1e0a0d74696d657a6f6e655f6e616d65120d417369612f5368616e676861697a0d0a086465766963654964120130900101aa010a646f7579696e5f776562b201077765625f73646b");
        byte[] demo1 =  HexUtil.decodeHex("08cef4daf102109eeed89299aca9fe16180620022a4b0a12785f66726f6e746965725f74726163656964123530323136353633383036303134353030303030303030303030303030303030303030306666666630616431313936303930343132302a1a0a15785f66726f6e746965725f6172726976657261746512013132057574662d383a09746578742f6a736f6e42417b226d73675f74797065223a312c22746f6173745f636f6e74656e74223a22222c227374617475735f636f6465223a302c227570646174655f74696d65223a307d4a353032313635363338303630313435303030303030303030303030303030303030303030666666663061643131393630393034313230");

        String s = new String(demo);
        String s1 = new String(demo1);
//        System.out.println(s);
        System.out.println(s1);
    }

    @Test
    public void test11(){
        String str = "你好吗？";
        byte[] GBK = str.getBytes(Charset.forName("GBK"));
        char[] chars = HexUtil.encodeHex(GBK);
        System.out.println(chars);

        String UTF8 = new String(GBK, Charset.forName("UTF-8"));
        byte[] bytes = UTF8.getBytes(Charset.forName("UTF-8"));

        char[] chars1 = HexUtil.encodeHex(bytes);
        System.out.println(chars1);

        String gbk = new String(bytes, Charset.forName("GBK"));

        System.out.println(UTF8);
        System.out.println(gbk);


    }

    @Test
    public void test12() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        //格式化
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        //编码格式
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
        //是否省略xml头信息，默认不省略（false）
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT,true);
        StringWriter writer = new StringWriter();
        Student student = new Student();
        marshaller.marshal(student,writer);
        String s = writer.toString();
        System.out.println(s);
    }

    @Test
    public void test13(){
        Ceshi ceshi = new Ceshi();

        int i = ceshi.test14(1);
        System.out.println(i);
    }

    public int test14(int i){
        if(i<=100) {
            int k = i += 1;
            int j = i + test14(k);
            System.out.println(j+"---"+k);
            return j;
        }
        return 0;
    }

    @Test
    public void test15(){
        Map<String,Integer> map = new HashMap<>();
        map.put("n",100);
        map.put("sum",0);
        Ceshi ceshi = new Ceshi();
        System.out.println(map);
        ceshi.fun(map);
    }


    public void fun(Map<String,Integer> map){
        Integer n = map.get("n");
        Integer sum = map.get("sum");
        if(n!=0){
            sum = sum +n;
            n = n-1;
            map.put("n",n);
            map.put("sum",sum);
            fun(map);
        }
        System.out.println(n+"---"+sum);
    }
    private List list  = new ArrayList();

    @Test
    public void test16(){
        Thread thread1 = new Thread(()->{
            List list1 = this.myTread();
            Console.log(list1);
        });

        Thread thread2 = new Thread(()->{
            List list2 = this.myTread();
            Console.log(list2);
        });
        thread1.start();
        thread2.start();
    }


    public List myTread(){
        List result = new ArrayList();
        synchronized (Ceshi.class){
            if(list.size()!=0){
                list.clear();
            }
            System.out.println(this.hashCode());
            for(int i = 0;i<1000;i++){
                Map map = new HashMap();
                map.put("菜单"+i,i);
                list.add(map);
            }
            result = list;
            result.add(new HashMap<String,String>(){{
                put("机构","32");
            }});
            HashSet h = new HashSet(list);
            result.clear();
            result.addAll(h);
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
        return result;

    }

    @Test
    public void test17(){
        new Thread(()->{
            String s = this.myThread1();
            System.out.println(s);
        }).start();
        new Thread(()->{
            String s = this.myThread1();
            System.out.println(s);
        }).start();
        new Thread(()->{
            String s = this.myThread1();
            System.out.println(s);
        }).start();
//        System.out.println(body);
    }

    @Test
    public String myThread1(){
        HttpResponse execute = HttpRequest.get("http://www.baidu.com")
                .execute();
        System.out.println(execute.headers());
//        System.out.println(body);
        return null;
    }

    @Test
    public void test18(){
        String str = HexUtil.encodeHexStr("😊我2a你", CharsetUtil.CHARSET_UTF_8);
        System.out.println(str);
        String str1 = HexUtil.decodeHexStr("F09F9880", CharsetUtil.CHARSET_UTF_8);
        System.out.println(str1);
//        11100011 10000001 10000010
    }
}
