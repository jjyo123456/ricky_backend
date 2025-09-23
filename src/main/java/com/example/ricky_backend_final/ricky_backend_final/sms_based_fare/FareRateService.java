package com.example.ricky_backend_final.ricky_backend_final.sms_based_fare;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FareRateService {

    private final ObjectMapper objectMapper;
    private final File fareRateFile;

    public FareRateService() {
        this.objectMapper = new ObjectMapper();
        this.fareRateFile = new File("fare_rate.json"); // make sure this file exists or provide absolute path
    }

    // Get current fare rate
    public fare_rate_object getFareRate() {
        try {
            if (!fareRateFile.exists()) {
                // If file does not exist, create a default rate
                fare_rate_object defaultRate = new fare_rate_object();
                defaultRate.setFare_rate(15.0);
                saveFareRateToFile(defaultRate);
                return defaultRate;
            }
            return objectMapper.readValue(fareRateFile, fare_rate_object.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // optionally throw a custom exception
        }
    }

    // Change fare rate
    public void changeFareRate(double newFareRate) {
        fare_rate_object updatedRate = new fare_rate_object();
        updatedRate.setFare_rate(newFareRate);
        saveFareRateToFile(updatedRate);
    }

    // Helper method to write to file
    private void saveFareRateToFile(fare_rate_object rate) {
        try {
            objectMapper.writeValue(fareRateFile, rate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
