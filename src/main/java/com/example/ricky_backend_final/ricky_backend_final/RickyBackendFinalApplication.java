package com.example.ricky_backend_final.ricky_backend_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages = {
		"com.example.ricky_backend_final.ricky_backend_final.fare_info_storage",
		"com.example.ricky_backend_final.ricky_backend_final.driver_info_storage",
		"com.example.ricky_backend_final.ricky_backend_final.vehicle_info_storage",
		"com.example.ricky_backend_final.ricky_backend_final.sms_based_fare",
		"com/example/ricky_backend_final/ricky_backend_final/sos_package"
})

public class RickyBackendFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickyBackendFinalApplication.class, args);
	}

}
