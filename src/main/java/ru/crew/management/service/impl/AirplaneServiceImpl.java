package ru.crew.management.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crew.management.model.Airplane;
import ru.crew.management.repository.AirplaneRepository;
import ru.crew.management.service.AirplaneService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;

    @Override
    public void save(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    public Airplane findById(Long id) {
        return airplaneRepository.findById(id).orElseThrow(() -> new IllegalStateException("Airplane not found"));
    }

    @Override
    public List<Airplane> findAll() {
        return airplaneRepository.findAll();
    }

    @Override
    public void delete(long id) {
        airplaneRepository.deleteById(id);
    }
}

