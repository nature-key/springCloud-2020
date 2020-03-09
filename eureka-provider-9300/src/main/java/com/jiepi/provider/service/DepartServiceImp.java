package com.jiepi.provider.service;

import com.jiepi.provider.bean.Depart;
import com.jiepi.provider.repository.DepartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartServiceImp implements DepartService {

    @Autowired
    DepartRepository departRepository;

    @Override
    public boolean saveDepart(Depart depart) {
        log.info("provider-9300");
        Depart result = departRepository.save(depart);
        if (null != result) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepart(int id) {
        log.info("provider-9300");
        if (departRepository.existsById(id)) {
            departRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        log.info("provider-9300");
        Depart result = departRepository.save(depart);
        if (null != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        log.info("provider-9300");
        if (departRepository.existsById(id)) {
            Depart result = departRepository.getOne(id);
            return result;
        }
        Depart depart = new Depart();
        depart.setName("no this depart");
        return depart;
    }

    @Override
    public List<Depart> listDeparts() {
        log.info("provider-9300");
        return departRepository.findAll();
    }
}
