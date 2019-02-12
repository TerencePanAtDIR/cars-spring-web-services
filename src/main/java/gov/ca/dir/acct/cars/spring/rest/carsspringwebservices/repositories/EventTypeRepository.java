package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.repositories;

import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities.Event;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities.EventType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventTypeRepository extends CrudRepository<EventType, Long> {
    List<EventType> findByProgramUnitCode(String programUnitCode);
}
