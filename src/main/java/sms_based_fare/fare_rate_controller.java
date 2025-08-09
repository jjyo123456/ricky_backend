package sms_based_fare;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@Controller("")
public class fare_rate_controller {
    @GetMapping("/get_fare_rate")
    public static ResponseEntity<fare_rate_object> get_farerate(){
        fare_rate_service s = new fare_rate_service();
        fare_rate_object a  = s.get_fare_rate();
        return ResponseEntity.ok(a);
    }

    @PostMapping("/change_fare_rate")
    public static ResponseEntity<String> change_fare_rate(@RequestParam double a){

        fare_rate_service s = new fare_rate_service();
        s.change_fare_rate(a);
        return ResponseEntity.ok("fare rate updated");
    }
}
