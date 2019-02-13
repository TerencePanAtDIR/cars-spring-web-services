package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.controller;

import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.controllers.EventDataController;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities.Event;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities.EventType;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.repositories.EventRepository;
import gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.repositories.EventTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EventDataController.class)
public class CarsSpringWebServicesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private EventTypeRepository eventTypeRepository;

    //Dates to test with
    LocalDateTime currentLocalDateTime = LocalDateTime.now();
    LocalDateTime currentLocalDateTimeAddDay =
            LocalDateTime.now().plus(1, ChronoUnit.DAYS);
    LocalDateTime currentLocalDateTimeAddYear =
            LocalDateTime.now().plus(1, ChronoUnit.YEARS);

    @Test
    public void givenCurrentDoc_whenFindByCurrentDoc_thenReturnJsonArray()
        throws Exception{

        EventType testEventType1 = new EventType(1L,
                "CALOSHA",
                "001",
                "New Event",
                "Test Description",
                currentLocalDateTime,
                currentLocalDateTimeAddYear,
                "CARS",
                "TPAN",
                currentLocalDateTime,
                "ZPAN",
                currentLocalDateTimeAddYear);

        Event testEvent1 = new Event(1L,
                testEventType1,
                1L,
                currentLocalDateTimeAddDay,
                "OSH-123456",
                "OSH-123456-001-1111111",
                "OSH-123456",
                "1234",
                "CALOSHA-AR",
                "CALOTPAN",
                currentLocalDateTimeAddDay,
                null,
                null);

        given(eventRepository.findByCurrentDocument("OSH-123456-001-1111111")).willReturn(testEvent1);

        mvc.perform(get("/events-rest/findByCurrentDoc/OSH-123456-001-1111111")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(15)))
                .andExpect(jsonPath("$.eventId", is(testEvent1.getEventId().intValue())))
                .andExpect(jsonPath("$.arStatusId", is(testEvent1.getArStatusId().intValue())))
                .andExpect(jsonPath("$.rootDocument", is(testEvent1.getRootDocument())))
                .andExpect(jsonPath("$.currentDocument", is(testEvent1.getCurrentDocument())))
                .andExpect(jsonPath("$.referenceDocument", is(testEvent1.getReferenceDocument())))
                .andExpect(jsonPath("$.additionalReference", is(testEvent1.getAdditionalReference())))
                .andExpect(jsonPath("$.dataSourceCode", is(testEvent1.getDataSourceCode())))
                .andExpect(jsonPath("$.createdBy", is(testEvent1.getCreatedBy())));
    }

    @Test
    public void givenRootDoc_whenFindByRootDoc_thenReturnJsonArray()
            throws Exception{

        EventType testEventType1 = new EventType(1L,
                "CALOSHA",
                "001",
                "New Event",
                "Test Description",
                currentLocalDateTime,
                currentLocalDateTimeAddYear,
                "CARS",
                "TPAN",
                currentLocalDateTime,
                "ZPAN",
                currentLocalDateTimeAddYear);

        Event testEvent1 = new Event(1L,
                testEventType1,
                1L,
                currentLocalDateTimeAddDay,
                "OSH-123456",
                "OSH-123456-001-1111111",
                "OSH-123456",
                "1234",
                "CALOSHA-AR",
                "CALOTPAN",
                currentLocalDateTimeAddDay,
                null,
                null);

        Event testEvent2 = new Event(2L,
                testEventType1,
                2L,
                currentLocalDateTimeAddDay,
                "OSH-123456",
                "OSH-123456-002-1111111",
                "OSH-123456",
                "12345",
                "CALOSHA-AR",
                "CALOTPAN",
                currentLocalDateTimeAddDay,
                null,
                null);

        List<Event> events = Arrays.asList(testEvent1, testEvent2);
        given(eventRepository.findByRootDocument("OSH-123456")).willReturn(events);

        mvc.perform(get("/events-rest/findByRootDoc/OSH-123456")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].eventId", is(testEvent1.getEventId().intValue())))
                .andExpect(jsonPath("$[0].arStatusId", is(testEvent1.getArStatusId().intValue())))
                .andExpect(jsonPath("$[0].rootDocument", is(testEvent1.getRootDocument())))
                .andExpect(jsonPath("$[0].currentDocument", is(testEvent1.getCurrentDocument())))
                .andExpect(jsonPath("$[0].referenceDocument", is(testEvent1.getReferenceDocument())))
                .andExpect(jsonPath("$[0].additionalReference", is(testEvent1.getAdditionalReference())))
                .andExpect(jsonPath("$[0].dataSourceCode", is(testEvent1.getDataSourceCode())))
                .andExpect(jsonPath("$[0].createdBy", is(testEvent1.getCreatedBy())))
                .andExpect(jsonPath("$[1].eventId", is(testEvent2.getEventId().intValue())))
                .andExpect(jsonPath("$[1].arStatusId", is(testEvent2.getArStatusId().intValue())))
                .andExpect(jsonPath("$[1].rootDocument", is(testEvent2.getRootDocument())))
                .andExpect(jsonPath("$[1].currentDocument", is(testEvent2.getCurrentDocument())))
                .andExpect(jsonPath("$[1].referenceDocument", is(testEvent2.getReferenceDocument())))
                .andExpect(jsonPath("$[1].additionalReference", is(testEvent2.getAdditionalReference())))
                .andExpect(jsonPath("$[1].dataSourceCode", is(testEvent2.getDataSourceCode())))
                .andExpect(jsonPath("$[1].createdBy", is(testEvent2.getCreatedBy())));
    }

    @Test
    public void givenEventId_whenFindByEventId_thenReturnJsonArray()
            throws Exception{

        EventType testEventType1 = new EventType(1L,
                "CALOSHA",
                "001",
                "New Event",
                "Test Description",
                currentLocalDateTime,
                currentLocalDateTimeAddYear,
                "CARS",
                "TPAN",
                currentLocalDateTime,
                "ZPAN",
                currentLocalDateTimeAddYear);

        Event testEvent1 = new Event(1L,
                testEventType1,
                1L,
                currentLocalDateTimeAddDay,
                "OSH-123456",
                "OSH-123456-001-1111111",
                "OSH-123456",
                "1234",
                "CALOSHA-AR",
                "CALOTPAN",
                currentLocalDateTimeAddDay,
                null,
                null);

        Event testEvent2 = new Event(2L,
                testEventType1,
                2L,
                currentLocalDateTimeAddDay,
                "OSH-123456",
                "OSH-123456-002-1111111",
                "OSH-123456",
                "12345",
                "CALOSHA-AR",
                "CALOTPAN",
                currentLocalDateTimeAddDay,
                null,
                null);

        given(eventRepository.findByEventId(1L)).willReturn(testEvent1);

        mvc.perform(get("/events-rest/findByEventId/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(15)))
                .andExpect(jsonPath("$.eventId", is(testEvent1.getEventId().intValue())))
                .andExpect(jsonPath("$.arStatusId", is(testEvent1.getArStatusId().intValue())))
                .andExpect(jsonPath("$.rootDocument", is(testEvent1.getRootDocument())))
                .andExpect(jsonPath("$.currentDocument", is(testEvent1.getCurrentDocument())))
                .andExpect(jsonPath("$.referenceDocument", is(testEvent1.getReferenceDocument())))
                .andExpect(jsonPath("$.additionalReference", is(testEvent1.getAdditionalReference())))
                .andExpect(jsonPath("$.dataSourceCode", is(testEvent1.getDataSourceCode())))
                .andExpect(jsonPath("$.createdBy", is(testEvent1.getCreatedBy())));

        given(eventRepository.findByEventId(2L)).willReturn(testEvent2);

        mvc.perform(get("/events-rest/findByEventId/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(15)))
                .andExpect(jsonPath("$.eventId", is(testEvent2.getEventId().intValue())))
                .andExpect(jsonPath("$.arStatusId", is(testEvent2.getArStatusId().intValue())))
                .andExpect(jsonPath("$.rootDocument", is(testEvent2.getRootDocument())))
                .andExpect(jsonPath("$.currentDocument", is(testEvent2.getCurrentDocument())))
                .andExpect(jsonPath("$.referenceDocument", is(testEvent2.getReferenceDocument())))
                .andExpect(jsonPath("$.additionalReference", is(testEvent2.getAdditionalReference())))
                .andExpect(jsonPath("$.dataSourceCode", is(testEvent2.getDataSourceCode())))
                .andExpect(jsonPath("$.createdBy", is(testEvent2.getCreatedBy())));
    }

    @Test
    public void givenReferenceDocument_whenFindByRefDoc_thenReturnJsonArray()
            throws Exception{

        EventType testEventType1 = new EventType(1L,
                "CALOSHA",
                "001",
                "New Event",
                "Test Description",
                currentLocalDateTime,
                currentLocalDateTimeAddYear,
                "CARS",
                "TPAN",
                currentLocalDateTime,
                "ZPAN",
                currentLocalDateTimeAddYear);

        Event testEvent1 = new Event(1L,
                testEventType1,
                1L,
                currentLocalDateTimeAddDay,
                "OSH-123456",
                "OSH-123456-001-1111111",
                "OSH-123456",
                "1234",
                "CALOSHA-AR",
                "CALOTPAN",
                currentLocalDateTimeAddDay,
                null,
                null);

        Event testEvent2 = new Event(2L,
                testEventType1,
                2L,
                currentLocalDateTimeAddDay,
                "OSH-123456",
                "OSH-123456-002-1111111",
                "OSH-123456",
                "12345",
                "CALOSHA-AR",
                "CALOTPAN",
                currentLocalDateTimeAddDay,
                null,
                null);

        List<Event> events = Arrays.asList(testEvent1, testEvent2);
        given(eventRepository.findByReferenceDocument("OSH-123456")).willReturn(events);

        mvc.perform(get("/events-rest/findByRefDoc/OSH-123456")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].eventId", is(testEvent1.getEventId().intValue())))
                .andExpect(jsonPath("$[0].arStatusId", is(testEvent1.getArStatusId().intValue())))
                .andExpect(jsonPath("$[0].rootDocument", is(testEvent1.getRootDocument())))
                .andExpect(jsonPath("$[0].currentDocument", is(testEvent1.getCurrentDocument())))
                .andExpect(jsonPath("$[0].referenceDocument", is(testEvent1.getReferenceDocument())))
                .andExpect(jsonPath("$[0].additionalReference", is(testEvent1.getAdditionalReference())))
                .andExpect(jsonPath("$[0].dataSourceCode", is(testEvent1.getDataSourceCode())))
                .andExpect(jsonPath("$[0].createdBy", is(testEvent1.getCreatedBy())))
                .andExpect(jsonPath("$[1].eventId", is(testEvent2.getEventId().intValue())))
                .andExpect(jsonPath("$[1].arStatusId", is(testEvent2.getArStatusId().intValue())))
                .andExpect(jsonPath("$[1].rootDocument", is(testEvent2.getRootDocument())))
                .andExpect(jsonPath("$[1].currentDocument", is(testEvent2.getCurrentDocument())))
                .andExpect(jsonPath("$[1].referenceDocument", is(testEvent2.getReferenceDocument())))
                .andExpect(jsonPath("$[1].additionalReference", is(testEvent2.getAdditionalReference())))
                .andExpect(jsonPath("$[1].dataSourceCode", is(testEvent2.getDataSourceCode())))
                .andExpect(jsonPath("$[1].createdBy", is(testEvent2.getCreatedBy())));
    }

    @Test
    public void givenProgramUnitCode_whenGetAvailableEventsByProgramUnit_thenReturnJsonArray()
            throws Exception{

        EventType testEventType1 = new EventType(1L,
                "CALOSHA",
                "001",
                "New Event",
                "Test Description",
                currentLocalDateTime,
                currentLocalDateTimeAddYear,
                "CARS",
                "TPAN",
                currentLocalDateTime,
                "ZPAN",
                currentLocalDateTimeAddYear);

        List<EventType> eventTypes = Arrays.asList(testEventType1);
        given(eventTypeRepository.findByProgramUnitCode("CALOSHA")).willReturn(eventTypes);

        mvc.perform(get("/events-rest/getAvailableEventsByProgramUnit/CALOSHA")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].eventTypeId", is(testEventType1.getEventTypeId().intValue())))
                .andExpect(jsonPath("$[0].programUnitCode", is(testEventType1.getProgramUnitCode())))
                .andExpect(jsonPath("$[0].eventTypeCode", is(testEventType1.getEventTypeCode())))
                .andExpect(jsonPath("$[0].eventTypeName", is(testEventType1.getEventTypeName())))
                .andExpect(jsonPath("$[0].description", is(testEventType1.getDescription())));
    }
}
