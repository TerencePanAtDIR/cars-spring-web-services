package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.controllers;

import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities.Event;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities.EventType;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.repositories.EventRepository;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.repositories.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("events-rest")
public class EventDataController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventTypeRepository eventTypeRepository;

    @GetMapping("/findByCurrentDoc/{currentDocument}")
    public @ResponseBody
    Event getEventByCurrentDoc(@PathVariable String currentDocument){
        return eventRepository.findByCurrentDocument(currentDocument);
    }

    @GetMapping("/findByRootDoc/{rootDocument}")
    public @ResponseBody
    List<Event> getEventsByRootDoc(@PathVariable String rootDocument){
        return eventRepository.findByRootDocument(rootDocument);
    }

    @GetMapping("/findByEventId/{eventId}")
    public @ResponseBody
    Event getEventsByEventId(@PathVariable Long eventId){
        return eventRepository.findByEventId(eventId);
    }

    @GetMapping("/findByRefDoc/{referenceDocument}")
    public @ResponseBody
    List<Event> getEventsByRefDoc(@PathVariable String referenceDocument){
        return eventRepository.findByReferenceDocument(referenceDocument);
    }

    @GetMapping("/getAvailableEventsByProgramUnit/{programUnitCode}")
    public @ResponseBody
    List<EventType> getAvailableEventsByProgramUnit(@PathVariable String programUnitCode){
        return eventTypeRepository.findByProgramUnitCode(programUnitCode);
    }


}
