package com.bamboo.compass.consumer.controller;

import com.bamboo.compass.consumer.bean.Depart;
import com.bamboo.compass.consumer.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/consumer/feign")
@RestController
public class FeignController {

    //此处调用的是Feign Client，而非真正的业务接口
    @Autowired
    private DepartService departService;

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
    public Depart getHandle(@PathVariable("id") int id) {
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
}
