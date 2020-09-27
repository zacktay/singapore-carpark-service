package com.example.singaporecarparkservice.service;

import com.example.singaporecarparkservice.entity.Carpark;
import com.example.singaporecarparkservice.repository.CarparkRepository;
import com.example.singaporecarparkservice.util.CarparkCsvParser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Log4j2
public class CarparkService {

    @Autowired
    private CarparkRepository repository;

    @Autowired
    private CarparkCsvParser carparkCsvParser;

    @Transactional
    public List<Carpark> loadData() throws IOException {
        List<Carpark> carparks = carparkCsvParser.getCarparks();
        log.debug(String.format("%s records parsed", carparks.size()));

        return repository.saveAll(carparks);
    }

    @Transactional(readOnly = true)
    public List<Carpark> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Long getCount() {
        return repository.count();
    }

    @Transactional(readOnly = true)
    public List<Carpark> getByGantryHeightAbove(Double height) {
        log.debug(String.format("Gantry Height - %s", height));

        return repository.findByGantryHeightGreaterThanEqual(height);
    }

}
