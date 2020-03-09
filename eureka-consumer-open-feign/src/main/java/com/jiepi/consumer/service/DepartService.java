package com.jiepi.consumer.service;




import com.jiepi.consumer.bean.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient("eureka-provider")
@RequestMapping("/provider/depart")
public interface DepartService {

    @PostMapping("/save")
    boolean saveDepart(Depart depart);
    @DeleteMapping("del/{id}")
    boolean removeDepart(@PathVariable("id") int id);
    @PutMapping("/update")
    boolean modifyDepart(Depart depart);
    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable("id") int id);
    @GetMapping("get/list")
    List<Depart> listDeparts();

}
