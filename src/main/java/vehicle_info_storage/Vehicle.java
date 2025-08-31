package vehicle_info_storage;

import driver_info_storage.Driver;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    private String vehicleId;

    private String plateNumber;

    @OneToOne
    @JoinColumn(name = "driver_id", unique = true)
    private Driver driver;

    @PrePersist
    public void prePersist() {
        if (vehicleId == null) {
            this.vehicleId = "VEH-" + UUID.randomUUID().toString();
        }
    }

    // getters & setters
    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public String getPlateNumber() { return plateNumber; }
    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
}
