package fare_info_storage;

import fare_info_storage.Fare_info_data_class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Fare_storage_repo extends JpaRepository<Fare_info_data_class, String> {
    Optional<Fare_info_data_class> findByfare_dateAndfareId(Date date , String id);

    @Query("SELECT f FROM Fare_info_data_class f JOIN f.driver d WHERE d.driverName = :driverName")
    List<Fare_info_data_class> findByDriverName(String driverName);

    // search by vehicle plate
    @Query("SELECT f FROM Fare_info_data_class f JOIN f.vehicle v WHERE v.plateNumber = :plateNumber")
    List<Fare_info_data_class> findByVehiclePlate(String plateNumber);
}
