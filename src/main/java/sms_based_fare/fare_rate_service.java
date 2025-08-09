package sms_based_fare;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class fare_rate_service {
    public fare_rate_object get_fare_rate(){
        ObjectMapper object = new ObjectMapper();
        fare_rate_object a = null;
        try {
            a = object.readValue(new File("fare_rate.json"), fare_rate_object.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void change_fare_rate(double new_fare_rate){
        ObjectMapper object = new ObjectMapper();

        fare_rate_object a = new fare_rate_object();
        a.setFare_rate(new_fare_rate);
        try{
            object.writeValue(new File("fare_rate.json") , a);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}