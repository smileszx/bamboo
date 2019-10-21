package com.bamboo.compass.consumer.repository;

import com.bamboo.compass.consumer.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 这是一个接口
 * 两个泛型分别是：
 * 1. 当前Repository所操作的实体类类型
 * 2. 该实体类的id的类型
 */
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
