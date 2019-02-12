package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.repositories;

import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByCurrentDocument(String currentDocument);
    List<Event> findByRootDocument(String rootDocument);
    List<Event> findByEventId(Long eventId);
    List<Event> findByReferenceDocument(String referenceDocument);

}
