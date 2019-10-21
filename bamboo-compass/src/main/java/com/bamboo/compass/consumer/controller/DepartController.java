package com.bamboo.compass.consumer.controller;

import com.bamboo.compass.consumer.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/consumer/depart")
@RestController
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVICE_PROVIDER = "http://bamboo-consumer";

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        String url = SERVICE_PROVIDER + "/consumer/depart/save";
        return restTemplate.patchForObject(url, depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        String url = SERVICE_PROVIDER + "/consumer/depart/del/" + id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandle(@RequestBody Depart depart) {
        String url = SERVICE_PROVIDER + "/consumer/depart/update";
        restTemplate.put(url, depart, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        String url = SERVICE_PROVIDER + "/consumer/depart/get/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        String url = SERVICE_PROVIDER + "/consumer/depart/list";
        return restTemplate.getForObject(url, List.class);
    }

    @GetMapping("/discovery")
    public Object discoveryHandle() {
        String url = SERVICE_PROVIDER + "/consumer/depart/discovery";
        return restTemplate.getForObject(url, Object.class);
    }
}
