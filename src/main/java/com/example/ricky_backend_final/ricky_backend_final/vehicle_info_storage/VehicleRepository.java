package com.example.ricky_backend_final.ricky_backend_final.vehicle_info_storage;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Vehicle findByPlateNumber(String plateNumber);
}

