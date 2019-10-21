package com.bamboo.compass.consumer.controller;

import com.bamboo.compass.consumer.bean.Depart;
import com.bamboo.compass.consumer.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@RequestMapping("/consumer/feign")
@RestController
public class FeignController {

    //此处调用的是Feign Client，而非真正的业务接口
    @Autowired
    private DepartService departService;

    @Autowired
    private StringRedisTemplate template;

    private ForkJoinPool pool = new ForkJoinPool(5);

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id, HttpServletRequest request) {
        System.out.println("URL: " + request.getServerName() + ":" + request.getServerPort() + request.getServletPath());
        String key = request.getLocalAddr() + "_getDepartById_fallback";
        queryCache(key);
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return departService.listAllDeparts();
    }

    @GetMapping("/discovery")
    public Object discoveryHandle() {
       return departService.discoveryHandle();
    }
    @GetMapping("/url")
    public String portHandle() {
        return departService.portHandle();
    }

    private void queryCache(String key) {
        BoundValueOperations<String, String> ops = template.boundValueOps(key);
        String value = ops.get();
        if (value == null) {
            synchronized (this) {
                value = ops.get();
                if (value == null) {
                    sendFallBackMsg(key);
                    ops.set("短信已发出", 10, TimeUnit.SECONDS);
                }
            }

        }
    }

    private void sendFallBackMsg(String key) {
        pool.submit(() ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("发送服务异常报警短信： " + key);
        });
    }

}
