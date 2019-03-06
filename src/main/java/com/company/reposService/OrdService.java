package com.company.reposService;

import com.company.entity.Ord;

import java.util.List;

public interface OrdService {
    List<Ord> getListOrd();
    Ord editOrd(Ord ord);

}
