package com.group8.alomilktea.service.impl;

import com.group8.alomilktea.entity.ShipmentCompany;
import com.group8.alomilktea.repository.ShipmentRepository;
import com.group8.alomilktea.service.IShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IShipmentServiceImpl implements IShipmentService {

    @Autowired
    private ShipmentRepository repo;
    @Override
    public ShipmentCompany save(ShipmentCompany shipmentCompany) {
        return repo.save(shipmentCompany);
    }

    @Override
    public ShipmentCompany findById(Integer shipCid) {
        return repo.findById(shipCid).orElse(null);
    }

    @Override
    public void deleteById(Integer shipCid) {
        repo.deleteById(shipCid);
    }

    @Override
    public Page<ShipmentCompany> getAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<ShipmentCompany> findAll() {
        return repo.findAll();
    }
}