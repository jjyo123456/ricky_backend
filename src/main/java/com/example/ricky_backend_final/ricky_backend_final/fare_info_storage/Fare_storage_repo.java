package com.example.ricky_backend_final.ricky_backend_final.fare_info_storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Fare_storage_repo extends JpaRepository<Fare_info_data_class, String> {

    // Corrected method name to match entity fields
    Optional<Fare_info_data_class> findByFareDateAndFareId(Date fareDate, String fareId);

    // Search by driver name
    @Query("SELECT f FROM Fare_info_data_class f JOIN f.driver d WHERE d.driverName = :driverName")
    List<Fare_info_data_class> findByDriverName(@Param("driverName") String driverName);

    // Search by vehicle plate
    @Query("SELECT f FROM Fare_info_data_class f JOIN f.vehicle v WHERE v.plateNumber = :plateNumber")
    List<Fare_info_data_class> findByVehiclePlate(@Param("plateNumber") String plateNumber);
}
