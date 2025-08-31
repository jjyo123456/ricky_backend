package fare_info_storage;

//import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor


public class Fare_info_service_class {

    private final Fare_storage_repo fareRepository;

    public Fare_info_service_class(Fare_storage_repo fareRepository) {
        this.fareRepository = fareRepository;
    }


    // Add new fare
    public Fare_info_data_class addFare(Fare_info_data_class fare) {
        return fareRepository.save(fare);
    }

    // Update existing fare
    public Fare_info_data_class updateFare(String fareId, Fare_info_data_class updatedFare) {
        return fareRepository.findById(fareId)
                .map(f -> {
                    f.setDriver(updatedFare.getDriver());
                    f.setVehicle(updatedFare.getVehicle());
                    f.setFareDate(updatedFare.getFareDate());
                    f.setStartTime(updatedFare.getStartTime());
                    f.setEndTime(updatedFare.getEndTime());
                    f.setDistanceKm(updatedFare.getDistanceKm());
                    f.setFareAmount(updatedFare.getFareAmount());
                    return fareRepository.save(f);
                })
                .orElseThrow(() -> new RuntimeException("Fare not found with id " + fareId));
    }

    // Delete fare
    public void deleteFare(String fareId) {
        fareRepository.deleteById(fareId);
    }

    // Get single fare by ID
    public Optional<Fare_info_data_class> getFareById(String fareId) {
        return fareRepository.findById(fareId);
    }

    // Get all fares
    public List<Fare_info_data_class> getAllFares() {
        return fareRepository.findAll();
    }

    // Search fares by driver name
    public List<Fare_info_data_class> getFaresByDriverName(String driverName) {
        return fareRepository.findByDriverName(driverName);
    }

    // Search fares by vehicle plate
    public List<Fare_info_data_class> getFaresByVehiclePlate(String plateNumber) {
        return fareRepository.findByVehiclePlate(plateNumber);
    }
}
