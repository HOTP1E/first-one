package ru.crew.management.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddCrewMemberDTO {
    private Long crewId;
    private Long aircraftId;
}
