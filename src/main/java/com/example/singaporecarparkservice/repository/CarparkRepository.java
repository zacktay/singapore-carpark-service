package com.example.singaporecarparkservice.repository;

import com.example.singaporecarparkservice.entity.Carpark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarparkRepository extends JpaRepository<Carpark, String> {

    List<Carpark> findByGantryHeightGreaterThanEqual(Double height);

}
