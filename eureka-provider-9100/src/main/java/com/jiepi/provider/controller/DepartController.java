package com.jiepi.provider.controller;


import com.jiepi.provider.bean.Depart;
import com.jiepi.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public boolean saveDepart(@RequestBody Depart depart){
        return departService.saveDepart(depart);
    }

    @DeleteMapping("del/{id}")
    public  boolean deleteDepart(@PathVariable("id") int id){
        return departService.removeDepart(id);
    }


    @PutMapping("/update")
    public boolean updateDepart(@RequestBody Depart depart){
        return  departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getDepart(@PathVariable("id") int id){
        return  departService.getDepartById(id);
    }


    @GetMapping("get/list")
    public List<Depart> getAll(){
        return  departService.listDeparts();
    }

    @GetMapping("discovery")
    public Object getInfo(){
        List<String> services = client.getServices();
        services.forEach(it->{
            List<ServiceInstance> instances = client.getInstances(it);
            instances.forEach(item->{
                String host = item.getHost();
                int port = item.getPort();
                System.out.println("host:"+host+"port:"+port);
            });
        });
        return services;
    }


}
