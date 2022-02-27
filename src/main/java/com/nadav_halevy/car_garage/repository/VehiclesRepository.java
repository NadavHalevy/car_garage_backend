package com.nadav_halevy.car_garage.repository;

import com.nadav_halevy.car_garage.model.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends JpaRepository <Vehicles, Integer> {
    //It's an integrator because the primary key is a (private int) id
}
