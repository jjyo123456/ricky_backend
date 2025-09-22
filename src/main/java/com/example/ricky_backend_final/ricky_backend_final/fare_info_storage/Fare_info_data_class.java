package com.example.ricky_backend_final.ricky_backend_final.fare_info_storage;

import com.example.ricky_backend_final.ricky_backend_final.driver_info_storage.Driver;
import com.example.ricky_backend_final.ricky_backend_final.vehicle_info_storage.Vehicle;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "fare_info")
public class Fare_info_data_class {

    @Id
    private String fareId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private Date fareDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double distanceKm;
    private Double fareAmount;

    @PrePersist
    public void prePersist() {
        if (fareId == null) {
            this.fareId = "FARE-" + UUID.randomUUID().toString();
        }
    }

    // getters & setters
    public String getFareId() { return fareId; }
    public void setFareId(String fareId) { this.fareId = fareId; }

    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Date getFareDate() { return fareDate; }
    public void setFareDate(Date fareDate) { this.fareDate = fareDate; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public Double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(Double distanceKm) { this.distanceKm = distanceKm; }

    public Double getFareAmount() { return fareAmount; }
    public void setFareAmount(Double fareAmount) { this.fareAmount = fareAmount; }
}
