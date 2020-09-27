package com.example.singaporecarparkservice.controller;

import com.example.singaporecarparkservice.entity.Carpark;
import com.example.singaporecarparkservice.service.CarparkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/carpark")
public class CarparkController {

    @Autowired
    private CarparkService service;

    @PostMapping
    public ResponseEntity<List<Carpark>> loadData() throws IOException {
        return ResponseEntity.ok(service.loadData());
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Carpark>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(service.getCount());
    }

    @GetMapping(path = "/getByGantryHeight")
    public ResponseEntity<List<Carpark>> getByGantryHeightAbove(@RequestParam Double height) {
        return ResponseEntity.ok(service.getByGantryHeightAbove(height));
    }

}
