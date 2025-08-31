package driver_info_storage;

import jakarta.persistence.*;
import vehicle_info_storage.Vehicle;

import java.util.UUID;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    private String driverId;

    private String driverName;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Vehicle vehicle;

    @PrePersist
    public void prePersist() {
        if (driverId == null) {
            this.driverId = "DRIVER-" + UUID.randomUUID().toString();
        }
    }

    // getters & setters
    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
}
