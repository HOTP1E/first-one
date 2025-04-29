package ru.crew.management.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.crew.management.model.Airplane;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
