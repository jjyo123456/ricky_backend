package fare_info_storage;

//import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fares")
//@RequiredArgsConstructor
public class Fare_info_storage_controller {

    private final Fare_info_service_class fareService;

    public Fare_info_storage_controller(Fare_info_service_class fareService) {
        this.fareService = fareService;
    }

    // Create new fare
    @PostMapping
    public ResponseEntity<Fare_info_data_class> createFare(@RequestBody Fare_info_data_class fare) {
        return ResponseEntity.ok(fareService.addFare(fare));
    }

    // Update fare
    @PutMapping("/{fareId}")
    public ResponseEntity<Fare_info_data_class> updateFare(
            @PathVariable String fareId,
            @RequestBody Fare_info_data_class updatedFare) {
        return ResponseEntity.ok(fareService.updateFare(fareId, updatedFare));
    }

    // Delete fare
    @DeleteMapping("/{fareId}")
    public ResponseEntity<Void> deleteFare(@PathVariable String fareId) {
        fareService.deleteFare(fareId);
        return ResponseEntity.noContent().build();
    }

    // Get fare by ID
    @GetMapping("/{fareId}")
    public ResponseEntity<Fare_info_data_class> getFareById(@PathVariable String fareId) {
        return fareService.getFareById(fareId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all fares
    @GetMapping
    public ResponseEntity<List<Fare_info_data_class>> getAllFares() {
        return ResponseEntity.ok(fareService.getAllFares());
    }

    // Get fares by driver name
    @GetMapping("/search/driver")
    public ResponseEntity<List<Fare_info_data_class>> getFaresByDriverName(@RequestParam String driverName) {
        return ResponseEntity.ok(fareService.getFaresByDriverName(driverName));
    }

    // Get fares by vehicle plate
    @GetMapping("/search/vehicle")
    public ResponseEntity<List<Fare_info_data_class>> getFaresByVehiclePlate(@RequestParam String plateNumber) {
        return ResponseEntity.ok(fareService.getFaresByVehiclePlate(plateNumber));
    }
}
