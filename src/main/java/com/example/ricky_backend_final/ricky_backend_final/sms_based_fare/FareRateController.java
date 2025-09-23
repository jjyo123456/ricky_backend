package com.example.ricky_backend_final.ricky_backend_final.sms_based_fare;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fare")
public class FareRateController {

    private final FareRateService fareRateService;

    public FareRateController(FareRateService fareRateService) {
        this.fareRateService = fareRateService;
    }

    @GetMapping("/get")
    public ResponseEntity<fare_rate_object> getFareRate() {
        fare_rate_object rate = fareRateService.getFareRate();
        return ResponseEntity.ok(rate);
    }

    @PostMapping("/change")
    public ResponseEntity<String> changeFareRate(@RequestParam double newRate) {
        fareRateService.changeFareRate(newRate);
        return ResponseEntity.ok("Fare rate updated successfully");
    }
}
