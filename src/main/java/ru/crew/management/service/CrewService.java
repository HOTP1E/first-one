package ru.crew.management.service;

import ru.crew.management.model.Crew;

import java.util.List;

public interface CrewService {

    void delete(long id);

    void save(Crew crew);

    Crew findById(Long id);

    List<Crew> findAll();
}
