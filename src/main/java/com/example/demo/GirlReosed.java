package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 汤欢庆
 * 2017/10/15.
 */
public interface GirlReosed extends JpaRepository<Girls, Integer> {
    List<Girls> findByAge(Integer age);
}
