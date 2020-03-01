package com.jiepi.consumer.controller;


import com.jiepi.consumer.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        String url = "http://localhost:8081/provider/depart/save";
        return restTemplate.postForObject(url, depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        String url = "http://localhost:8081/provider/depart/del/" + id;
        restTemplate.delete(url);
    }

    @PutMapping("/update")
    public void updateHandle(Depart depart) {
        String url = "http://localhost:8081/provider/depart/update";
        restTemplate.put(url, depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        String url = "http://localhost:8081/provider/depart/get/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        String url = "http://localhost:8081/provider/depart/list";
        return restTemplate.getForObject(url, List.class);
    }

}
