package fare_info_storage;

import fare_info_storage.Fare_info_data_class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Fare_storage_repo extends JpaRepository<Fare_info_data_class, Integer> {

}
