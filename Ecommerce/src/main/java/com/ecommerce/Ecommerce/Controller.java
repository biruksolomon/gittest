package com.ecommerce.Ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Car car;
    @GetMapping("/h")
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/{name}")
    public String hello1(@PathVariable String name){
        return "hello" +name;
    }
    @GetMapping("hello")
    public HelloResponse hello1(){
        return new HelloResponse("hello");
    }
    @GetMapping("helloob/{name}")
    public HelloResponse helloob(@PathVariable String name){
        return new HelloResponse("Hello" + name);
    }
    @PostMapping("hello")
    public String hellopost(@RequestBody String name){
        return "Hello"+name;
    }
    @PostMapping("show")
    public String  add(@RequestBody Car car){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        return "Succusfully added";
    }
}
