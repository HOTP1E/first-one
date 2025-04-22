package ru.crew.management.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crew.management.model.Crew;
import ru.crew.management.repository.CrewRepository;
import ru.crew.management.service.CrewService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CrewServiceImpl implements CrewService {


    private final CrewRepository crewRepository;

    @Override
    public void save(Crew crew) {
        crewRepository.save(crew);
    }

    @Override
    public Crew findById(Long id) {
        return crewRepository.findById(id).orElseThrow(() -> new IllegalStateException("Crew not found"));
    }

    @Override
    public List<Crew> findAll() {
        return crewRepository.findAll();
    }

    @Override
    public void delete(long id) {
        crewRepository.deleteById(id);
    }
}
