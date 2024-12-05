package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.ShipmentCompany;
import com.group8.alomilktea.repository.ShipmentCompanyRepository;
import com.group8.alomilktea.service.IShipmentCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentCompanyImpl implements IShipmentCompany {
    @Autowired
    private ShipmentCompanyRepository repo;

    public ShipmentCompanyImpl(ShipmentCompanyRepository repo) {
        this.repo = repo;
    }

    public List<ShipmentCompany> findAll() {
        return repo.findAll();
    }
}
