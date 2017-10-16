package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 汤欢庆
 * 2017/10/15.
 */
@RestController
public class GilrController {
    @Autowired
    private GirlReosed girlReosed;

    /**
     * 查询列表
     *
     * @return
     */
    @GetMapping(value = "/list")
    public List<Girls> girlsList() {
        return girlReosed.findAll();
    }

    /**
     * @param adder
     * @param age
     * @return
     */
    @PostMapping(value = "/add")
    public Girls add(@RequestParam("name") String name, @RequestParam("adder") String adder, @RequestParam("age") Integer age) {
        Girls girls = new Girls();

        girls.setName(name);
        girls.setAdder(adder);
        girls.setAge(age);

        return girlReosed.save(girls);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping(value = "/GetId/{id}")
    public Girls girlone(@PathVariable("id") Integer id) {
        return girlReosed.findOne(id);
    }

    @PostMapping(value = "/update/{id}")
    public void update(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("adder") String adder, @RequestParam("age") Integer age) {
        Girls girls = new Girls();
        girls.setId(id);
        girls.setName(name);
        girls.setAdder(adder);
        girls.setAge(age);
        girlReosed.save(girls);
    }

    /**
     * @param id
     */
    @DeleteMapping(value = "/delte/{id}")
    public void delete(@PathVariable("id") Integer id) {
        girlReosed.delete(id);
    }

    @GetMapping(value = "getbyAge/{age}")
    public List<Girls> findByage(@PathVariable(value = "age") Integer age) {
        return girlReosed.findByAge(age);
    }
}
