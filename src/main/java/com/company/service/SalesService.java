package com.company.service;

import com.company.entity.Sale;
import com.company.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SalesService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getSales() {
        Iterable<Sale> it = saleRepository.findAll();
        ArrayList<Sale> sales = new ArrayList<>();
        it.forEach((obj) -> sales.add(obj));
        return sales;
    }
}
