package ru.crew.management.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.crew.management.model.Crew;
import ru.crew.management.service.CrewService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/crews")
public class CrewController {


    private final CrewService crewService;

    @PostMapping
    public ResponseEntity<String> createCrew(@RequestBody Crew crew) {
        crewService.save(crew);
        return ResponseEntity.ok("Crew member saved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crew> findCrew(@PathVariable Long id) {
        return ResponseEntity.ok(crewService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Crew>> findAll() {
        return ResponseEntity.ok(crewService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        crewService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
