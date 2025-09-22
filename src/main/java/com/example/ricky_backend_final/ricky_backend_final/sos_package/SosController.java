package com.example.ricky_backend_final.ricky_backend_final.sos_package;




import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/sos")
public class SosController {

    private final SimpMessagingTemplate messagingTemplate;

    public SosController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Receive SOS from frontend (PyQt or mobile app)
    @PostMapping
    public com.example.ricky_backend_final.ricky_backend_final.sos_package.SosAlert receiveSos(@RequestParam double latitude,
                                                                                               @RequestParam double longitude) {
        com.example.ricky_backend_final.ricky_backend_final.sos_package.SosAlert alert = new com.example.ricky_backend_final.ricky_backend_final.sos_package.SosAlert(
                "SOS-" + UUID.randomUUID(),
                latitude,
                longitude,
                LocalDateTime.now().toString()
        );

        // Push immediately to all admin clients via WebSocket
        messagingTemplate.convertAndSend("/topic/sos-alerts", alert);

        return alert; // response back to sender
    }
}

