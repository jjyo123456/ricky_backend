public class fare_info_datA_CLASS{
    @Id 
    @AutoGennerate(GennerationType = Gennerate.UNQIUE)
    private int id;

    private String auto_id;
    private String auto_driver_name;
    private Double fare;
    private TimeStamp time;

}