package ru.crew.management.service;

import ru.crew.management.model.Airplane;

import java.util.List;


public interface AirplaneService {

    void delete(long id);

    void save(Airplane airplane);

    Airplane findById(Long id);

    List<Airplane> findAll();
}