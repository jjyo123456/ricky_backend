package fare_info_storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class fare_info_service_class {
    @Autowired
    private Fare_storage_repo fare_storage_repo;

    private void add_fare_info(Fare_info_data_class fare){
        fare_storage_repo.save(fare);
    }
    private Fare_info_data_class delete_fare_info(String id){
        Fare_info_data_class fare = fare_storage_repo.findById(id);
        fare_storage_repo.deleteById(id);
        return fare;
    }
    private Fare_info_data_class get_fare_info(String id){
        Fare_info_data_class fare = fare_storage_repo.findById(id);
        return fare;
    }
    private void update_fare_info(Fare_info_data_class fare){
        fare_storage_repo.save(fare);
    }
}
