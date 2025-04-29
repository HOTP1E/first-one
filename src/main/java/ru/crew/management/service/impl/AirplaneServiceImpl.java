package ru.crew.management.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.crew.management.dto.AddCrewMemberDTO;
import ru.crew.management.dto.AirplaneDTO;
import ru.crew.management.dto.CrewMemberDTO;
import ru.crew.management.exception.ApiException;
import ru.crew.management.model.Airplane;
import ru.crew.management.model.Crew;
import ru.crew.management.repository.AirplaneRepository;
import ru.crew.management.repository.CrewRepository;
import ru.crew.management.service.AirplaneService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;
    private final CrewRepository crewRepository;

    @Transactional
    @Override
    public void save(AirplaneDTO airplaneDTO) {

        Airplane airplane = new Airplane();
        if (Objects.nonNull(airplaneDTO.getFamily())) {
            airplane.setFamily(airplaneDTO.getFamily());
        }
        if (Objects.nonNull(airplaneDTO.getCrewAmount())) {
            airplane.setCrewAmount(airplaneDTO.getCrewAmount());
        }
        if (Objects.nonNull(airplaneDTO.getYear())) {
            airplane.setYear(airplaneDTO.getYear());
        }
        if (Objects.nonNull(airplaneDTO.getSeats())) {
            airplane.setSeats(airplaneDTO.getSeats());
        }
        if (Objects.nonNull(airplaneDTO.getCrewMember())) {
            Crew crew = crewRepository.findById(
                    airplaneDTO
                            .getCrewMember()).orElseThrow(
                    () -> new ApiException("Unable to create the airplane ,crew member not found")
            );
            if (airplaneDTO.getFamily().equals(crew.getTypeRating())) {
                airplane.setCrewMember(airplaneDTO.getCrewMember());
            }
            else {
                throw new ApiException("Unable to create the airplane ,crew member has incorrect typeRating, Biiaaaach!");
            }
        }

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

    @Override
    public CrewMemberDTO addCrewMember(AddCrewMemberDTO addCrewMemberDTO) {
        Optional<Crew> crewMember = crewRepository.findById(addCrewMemberDTO.getCrewId());
        if (crewMember.isPresent()) {

            Optional<Airplane> optionalAirplane = airplaneRepository.findById(addCrewMemberDTO.getAircraftId());

            if (optionalAirplane.isPresent()) {
                Airplane airplane = optionalAirplane.get();
                if (airplane.getCrewMember() != null) {
                    throw new ApiException("Crew member already exists");
                }
                airplane.setCrewMember(addCrewMemberDTO.getCrewId());
                airplaneRepository.save(airplane);
                Crew crew = crewMember.get();
                return new CrewMemberDTO(crew.getFirstName(), crew.getLastName(), crew.getPosition());

            } else {
                throw new ApiException("Unable to add a CrewMember to unexisting Airplane");
            }

        } else {
            throw new ApiException("Unable to add unexisting CrewMember");
        }
    }
}

