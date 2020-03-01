package com.jiepi.provider.service;

import com.jiepi.provider.bean.Depart;
import com.jiepi.provider.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImp implements DepartService {

    @Autowired
    DepartRepository departRepository;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart result = departRepository.save(depart);
        if (null != result) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDepart(int id) {
        if (departRepository.existsById(id)) {
            departRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {

        Depart result = departRepository.save(depart);
        if (null != null) {
            return true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
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
        return departRepository.findAll();
    }
}
