package com.bamboo.compass.consumer.service;



import com.bamboo.compass.consumer.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(value = "bamboo-provider", fallback = DepartFallBack.class)
//@FeignClient(value = "bamboo-provider", fallbackFactory = FallBackFactory.class)
@RequestMapping("/provider/depart")
@Service
public interface DepartService {
    @RequestMapping("/save")
    boolean saveDepart(@RequestBody Depart depart);

    @DeleteMapping("/del/{id}")
    boolean removeDepartById(@PathVariable int id);

    @PutMapping("/update")
    boolean modifyDepart(@RequestBody Depart depart);
    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable int id);

    @GetMapping("/list")
    List<Depart> listAllDeparts();

    @GetMapping("/discovery")
    Object discoveryHandle ();
    @GetMapping("/url")
    String portHandle();
}
