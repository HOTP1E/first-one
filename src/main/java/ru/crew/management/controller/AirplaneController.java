package ru.crew.management.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.crew.management.model.Airplane;
import ru.crew.management.service.AirplaneService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/airplanes")
public class AirplaneController {


    private final AirplaneService airplaneService;

    @PostMapping
    public ResponseEntity<String> createAirplane(@RequestBody Airplane airplane) {
        airplaneService.save(airplane);
        return ResponseEntity.ok("Airplane saved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> findAirplane(@PathVariable Long id) {
        return ResponseEntity.ok(airplaneService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Airplane>> findAll() {
        return ResponseEntity.ok(airplaneService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        airplaneService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
