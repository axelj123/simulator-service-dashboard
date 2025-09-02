package com.example.simulator_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/photon/webhook")
public class PhotonWebhookController {

    @PostMapping("/Create")
    public ResponseEntity<String> onRoomCreate(@RequestBody String payload) {
        System.out.println("Room created: " + payload);
        return ResponseEntity.ok("{\"ResultCode\": 0, \"Data\": {}}");
    }

    @PostMapping("/Join")
    public ResponseEntity<String> onPlayerJoin(@RequestBody String payload) {
        System.out.println("Player joined: " + payload);
        return ResponseEntity.ok("{\"ResultCode\": 0, \"Data\": {}}");
    }

    @PostMapping("/Leave")
    public ResponseEntity<String> onPlayerLeave(@RequestBody String payload) {
        System.out.println("Player left: " + payload);
        return ResponseEntity.ok("{\"ResultCode\": 0, \"Data\": {}}");
    }

    @PostMapping("/Close")
    public ResponseEntity<String> onRoomClose(@RequestBody String payload) {
        System.out.println("Room closed: " + payload);
        return ResponseEntity.ok("{\"ResultCode\": 0, \"Data\": {}}");
    }
}
