package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 汤欢庆
 * 2017/10/15.
 */
@RestController
public class HelloSpringBoot {
    @Autowired
    private Girl girl;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say() {


        return girl.getName() + girl.getAge();


    }

    /*@GetMapping(value = "/GetId/{id}")*/
    @RequestMapping(value = "/GetId", method = RequestMethod.GET)

    public String byId(@RequestParam(value = "id", required = false, defaultValue = "0") Integer Id) {
        return "Id:" + Id;
    }

}
