package com.jiepi.consumer.service;

import com.jiepi.consumer.bean.Depart;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartServiceFallBack implements FallbackFactory<DepartService> {

    @Override
    public DepartService create(Throwable throwable) {
        return new DepartService() {
            @Override
            public boolean saveDepart(Depart depart) {
                return false;
            }

            @Override
            public boolean removeDepart(int id) {
                return false;
            }

            @Override
            public boolean modifyDepart(Depart depart) {
                return false;
            }

            @Override
            public Depart getDepartById(int id) {
                Depart depart = new Depart();
                depart.setId(id);
                depart.setName("列级别");
                depart.setDbase("类级别");
                return depart;
            }

            @Override
            public List<Depart> listDeparts() {
                return null;
            }
        };
    }
}
