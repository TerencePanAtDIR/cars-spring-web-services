package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.services;

import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;


}
