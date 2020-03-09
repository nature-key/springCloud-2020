package com.jiepi.consumer.controller;


import com.jiepi.consumer.bean.Depart;
import com.jiepi.consumer.service.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class DepartController {


    @Autowired
    private DepartService departService;

    /**
     * @param depart
     * @return
     */
    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
//        String url = "http://localhost:8081/provider/depart/save";
//        return restTemplate.postForObject(url, depart, Boolean.class);
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") int id) {
//        String url = "http://localhost:8081/provider/depart/del/" + id;
////        restTemplate.delete(url);
        return departService.removeDepart(id);
    }

    @PutMapping("/update")
    public boolean updateHandle(Depart depart) {
//        String url = "http://localhost:8081/provider/depart/update";
//        restTemplate.put(url, depart);
        return departService.modifyDepart(depart);
    }

    /**
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "getDepartById")
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
//        String url = "http://localhost:8081/provider/depart/get/" + id;
//        return restTemplate.getForObject(url, Depart.class);
        Depart depart = departService.getDepartById(id);
        if (null == depart) {
            throw new RuntimeException("no depart service");
        }

        return depart;
    }

//    private Depart getDepartById(@PathVariable("id") int id) {
//        Depart depart = new Depart();
//        depart.setDbase("test");
//        depart.setName("no    test  depart service");
//        return depart;
//    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
//        String url = "http://localhost:8081/provider/depart/list";
//        return restTemplate.getForObject(url, List.class);
        return departService.listDeparts();
    }

}
