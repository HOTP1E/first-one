package ru.crew.management.service;

import ru.crew.management.dto.AddCrewMemberDTO;
import ru.crew.management.dto.AirplaneDTO;
import ru.crew.management.dto.CrewMemberDTO;
import ru.crew.management.model.Airplane;

import java.util.List;


public interface AirplaneService {

    void delete(long id);

    void save(AirplaneDTO airplane);

    Airplane findById(Long id);

    List<Airplane> findAll();

    CrewMemberDTO addCrewMember(AddCrewMemberDTO addCrewMemberDTO);
}