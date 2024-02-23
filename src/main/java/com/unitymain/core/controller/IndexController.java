package com.unitymain.core.controller;

import com.unitymain.core.bean.Result;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @author unitymain
 */
@RestController
public class IndexController {

    private List list  = Collections.synchronizedList(new ArrayList()) ;


    @RequestMapping("/index")
    public Result<List> index() throws InterruptedException {
        List list = myTread();
        Result<List> body = Result.ok().body(list);
        System.out.println("返回数据后的线程id"+Thread.currentThread().getId());
        return body;
    }

    public List myTread() throws InterruptedException {
        List result = new ArrayList();
        synchronized (this){
            if(list.size()!=0){
                list.clear();
            }
            Thread.sleep(100);
            for(int i = 0;i<1000;i++){
                Map map = new HashMap();
                map.put("菜d单"+i,i);
                list.add(map);
            }

            result.add(new HashMap<String,String>(){{
                put("机构","32");
            }});
            HashSet h = new HashSet(list);
            list.clear();
            result.addAll(h);

        }
        return result;
    }

    @RequestMapping("/demo")
    public void demo(HttpServletRequest request){
        try {
            Config config = Config.fromYAML(getClass().getClassLoader().getResource("demo.yml"));
            RedissonClient redissonClient = Redisson.create(config);
            RLock lock = redissonClient.getLock("123");
            boolean b = lock.tryLock();
            System.out.println(b);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

}

