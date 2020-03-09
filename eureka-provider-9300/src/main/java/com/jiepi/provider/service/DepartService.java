package com.jiepi.provider.service;


import com.jiepi.provider.bean.Depart;

import java.util.List;

public interface DepartService {

    boolean saveDepart(Depart depart);

    boolean removeDepart(int id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listDeparts();

}
