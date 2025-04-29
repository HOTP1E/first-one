package ru.crew.management.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.crew.management.model.AirplaneFamily;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AirplaneDTO {

    @Enumerated(EnumType.STRING)
    private AirplaneFamily family;

    private int year;

    private int seats;

    private int crewAmount;

    private Long crewMember;
}
