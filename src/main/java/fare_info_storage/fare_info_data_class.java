public class fare_info_data_class{
    @Id 
    @AutoGennerate(GennerationType = Gennerate.UNQIUE)
    @SqeyenceGennerator(sequence_name = "fare_id_sequence" table_name = "fare_id_sequence" Allocationsize = "1")
    private String fare_id;

    private String driver_id;//to be connected to the driver database
    private String vehicle_id;// to be connected to the vehicle database

    private TimeStamp start_time;
    private TimeStamp end_time;
    private Double distance_km;
    private Double fare_amount;
    

    @PrePersist
    public void prePersist(){
    if(fare_id == null){
    this.fare_id = "FARE-" + UUID.randomUUID().toString();
    }
    }


}
