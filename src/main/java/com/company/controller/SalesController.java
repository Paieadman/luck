package com.company.controller;

import com.company.entity.Sale;
import com.company.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SalesController {
    @Autowired
    private SalesService salesService;

    @RequestMapping("/sales")
    public List<Sale> getSale() {
        return salesService.getSales();
    }
}
