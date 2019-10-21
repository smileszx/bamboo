package com.bamboo.distribute.controller;

import com.bamboo.distribute.po.Depart;
import com.bamboo.distribute.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("/provider/depart")
@RestController
public class DepartController {
    @Autowired
    private DepartService service;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        return service.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
        return service.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(@RequestBody Depart depart) {
        return service.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return service.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        return service.listAllDeparts();
    }

    @GetMapping("/discovery")
    public Object discoveryHandle() {
        //获取注册表中所有微服务名称，也就是spring.application.name的名称
        List<String> springApplicationNames = client.getServices();
        for(String name : springApplicationNames) {
            List<ServiceInstance> instances = client.getInstances(name);
            for (ServiceInstance instance : instances) {
                String host = instance.getHost();
                int port = instance.getPort();
                Map<String, String> meta = instance.getMetadata();
                System.out.println(host + " : " + port + " , Metadata: " + meta);
            }
        }
        return springApplicationNames;
    }

    @GetMapping("/url")
    public String portHandle (HttpServletRequest request) {
        System.out.println("URL: " + request.getServerName() + ":" + request.getServerPort() + request.getServletPath());
        return "URL: " + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
    }
}
