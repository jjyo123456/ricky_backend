package com.example.ricky_backend_final.ricky_backend_final.sms_based_fare;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class fare_rate_object {

    @JsonProperty("fare_rate")
    @JsonAlias("fareRate")  // accepts both "fare_rate" and "fareRate"
    private double fare_rate;

    public double getFare_rate() {
        return fare_rate;
    }

    public void setFare_rate(double fare_rate) {
        this.fare_rate = fare_rate;
    }
}
