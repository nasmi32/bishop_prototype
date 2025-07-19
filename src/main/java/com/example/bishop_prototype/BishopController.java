package com.example.bishop_prototype;

import com.weyland.bishop_synthetic_core_starter.service.CommandService;
import com.weyland.bishop_synthetic_core_starter.service.MetricsService;
import com.weyland.bishop_synthetic_core_starter.model.Command;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bishop")
@RequiredArgsConstructor
public class BishopController {

    private final CommandService commandService;
    private final MetricsService metricsService;

    @PostMapping("/command")
    public ResponseEntity<String> submitCommand(@RequestBody @Valid Command command) {
        commandService.processCommand(command);
        return ResponseEntity.ok("Command accepted");
    }

    @GetMapping("/metrics")
    public Map<String, Object> getMetrics() {
        return metricsService.getMetrics();
    }
}