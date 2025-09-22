package com.example.ricky_backend_final.ricky_backend_final.sms_based_fare;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FareRateController {

    private final fare_rate_service fareRateService = new fare_rate_service();

    @GetMapping("/get_fare_rate")
    public ResponseEntity<fare_rate_object> getFareRate() {
        fare_rate_object rate = fareRateService.get_fare_rate();
        return ResponseEntity.ok(rate);
    }

    @PostMapping("/change_fare_rate")
    public ResponseEntity<String> changeFareRate(@RequestParam double newRate) {
        fareRateService.change_fare_rate(newRate);
        return ResponseEntity.ok("Fare rate updated");
    }
}
