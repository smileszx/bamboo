package com.bamboo.distribute.provider.service;

import com.bamboo.distribute.provider.bean.Depart;
import com.bamboo.distribute.provider.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartRepository repository;

    // 插入
    @Override
    public boolean saveDepart(Depart depart) {
        // save()可以完成插入与修改操作
        // 若操作对象中的id为null，则执行插入
        // 若操作对象中的id不为null且存在，则执行修改
        // 若操作对象中的id不为null但不存在，则执行插入，
        //    但插入后该对象的id并非是指定的id，而是由DB自动生成的
        // save()方法的返回结果为：
        // 执行成功，则返回操作对象
        // 执行失败，则返回null
        Depart obj = repository.save(depart);
        if(obj != null) {
            return true;
        }
        return false;
    }

    // 根据id删除
    @Override
    public boolean removeDepartById(int id) {
        // deleteById()中指定的id若不存在，则抛出异常
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = repository.save(depart);
        if(obj != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        // getOne()指定的id若不存在，则抛出异常
        if(repository.existsById(id)) {
            return repository.getOne(id);
        }
        Depart depart = new Depart();
        depart.setName("no this depart");
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
