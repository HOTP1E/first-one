package ru.crew.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crew.management.model.Crew;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {
}
