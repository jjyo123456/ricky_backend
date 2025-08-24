package fare_info_storage;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fare_info")
public class Fare_info_data_class {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "fare_id_sequence" , sequenceName = "fare_id_sequence", allocationSize = 1)
    private String fareId;

    private String driverId;   // to be connected to the driver database
    private String vehicleId;  // to be connected to the vehicle database

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


    public String getFareId() {
        return fareId;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

    public String getDriverId() {
        return driverId;
    }

    public Fare_info_data_class(String fareId, String driverId, String vehicleId, LocalDateTime startTime, LocalDateTime endTime, Double distanceKm, Double fareAmount) {
        this.fareId = fareId;
        this.driverId = driverId;
        this.vehicleId = vehicleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distanceKm = distanceKm;
        this.fareAmount = fareAmount;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Double getFareAmount() {
        return fareAmount;
    }

    public void setFareAmount(Double fareAmount) {
        this.fareAmount = fareAmount;
    }



    // getters & setters
}
