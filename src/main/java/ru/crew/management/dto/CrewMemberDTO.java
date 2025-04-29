package ru.crew.management.dto;

import lombok.*;
import ru.crew.management.model.Position;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CrewMemberDTO {
    private String firstName;
    private String lastName;
    private Position position;
}
