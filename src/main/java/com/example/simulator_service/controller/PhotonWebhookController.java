package com.example.simulator_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/photon")
public class PhotonWebhookController {

    private final Map<String, Integer> salas = new HashMap<>();

    @PostMapping("/webhook")
    public ResponseEntity<Void> recibirEvento(@RequestBody Map<String, Object> evento) {
        String tipo = (String) evento.get("Type");
        String sala = (String) evento.get("GameId");

        switch (tipo) {
            case "GameCreated":
                salas.put(sala, 0);
                System.out.println("Sala creada : " + sala);
                break;
            case "PlayerJoined":
                salas.put(sala, salas.getOrDefault(sala, 0) + 1);
                System.out.println("Jugador entró a: " + sala);
                break;
            case "PlayerLeft":
                salas.put(sala, Math.max(0, salas.getOrDefault(sala, 1) - 1));
                System.out.println("Jugador salió de: " + sala);
                break;
            case "GameClosed":
                salas.remove(sala);
                System.out.println("Sala cerrada: " + sala);
                break;
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stats")
    public Map<String, Object> obtenerEstadisticas(){
        int total=salas.values().stream().mapToInt(Integer::intValue).sum();
        return Map.of(
                "salas", salas,
                "totalUsuarios", total
        );
    }

}
