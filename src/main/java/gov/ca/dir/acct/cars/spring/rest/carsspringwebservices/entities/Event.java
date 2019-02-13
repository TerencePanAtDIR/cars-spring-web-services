package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="event")
public class Event {

    @Id
    @Column(name = "event_id")
    private Long eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "event_type_id")
    private EventType eventType;

    @Column(name = "ar_status_id")
    private Long arStatusId;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "ar_root_document")
    private String rootDocument;

    @Column(name = "current_document")
    private String currentDocument;

    @Column(name = "reference_document")
    private String referenceDocument;

    @Column(name = "additional_reference")
    private String additionalReference;

    @Column(name = "data_source_code")
    private String dataSourceCode;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    //Get Parent attribute, include in JSON, but not mapped via Hibernate
    @JsonInclude()
    @Transient
    private String eventTypeCode;

    @JsonInclude()
    @Transient
    private String eventTypeName;

    @JsonInclude()
    @Transient
    private String programUnitCode;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Long getArStatusId() {
        return arStatusId;
    }

    public void setArStatusId(Long arStatusId) {
        this.arStatusId = arStatusId;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getRootDocument() {
        return rootDocument;
    }

    public void setRootDocument(String rootDocument) {
        this.rootDocument = rootDocument;
    }

    public String getCurrentDocument() {
        return currentDocument;
    }

    public void setCurrentDocument(String currentDocument) {
        this.currentDocument = currentDocument;
    }

    public String getReferenceDocument() {
        return referenceDocument;
    }

    public void setReferenceDocument(String referenceDocument) {
        this.referenceDocument = referenceDocument;
    }

    public String getAdditionalReference() {
        return additionalReference;
    }

    public void setAdditionalReference(String additionalReference) {
        this.additionalReference = additionalReference;
    }

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getEventTypeCode() {
        return eventType.getEventTypeCode();
    }

    public String getEventTypeName() {
        return eventType.getEventTypeName();
    }

    public String getProgramUnitCode() {
        return eventType.getProgramUnitCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId) &&
                Objects.equals(eventType, event.eventType) &&
                Objects.equals(arStatusId, event.arStatusId) &&
                Objects.equals(eventDate, event.eventDate) &&
                Objects.equals(rootDocument, event.rootDocument) &&
                Objects.equals(currentDocument, event.currentDocument) &&
                Objects.equals(referenceDocument, event.referenceDocument) &&
                Objects.equals(additionalReference, event.additionalReference) &&
                Objects.equals(dataSourceCode, event.dataSourceCode) &&
                Objects.equals(createdBy, event.createdBy) &&
                Objects.equals(createdDate, event.createdDate) &&
                Objects.equals(modifiedBy, event.modifiedBy) &&
                Objects.equals(modifiedDate, event.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, eventType, arStatusId, eventDate, rootDocument, currentDocument, referenceDocument, additionalReference, dataSourceCode, createdBy, createdDate, modifiedBy, modifiedDate);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventType=" + eventType +
                ", arStatusId=" + arStatusId +
                ", eventDate=" + eventDate +
                ", rootDocument='" + rootDocument + '\'' +
                ", currentDocument='" + currentDocument + '\'' +
                ", referenceDocument='" + referenceDocument + '\'' +
                ", additionalReference='" + additionalReference + '\'' +
                ", dataSourceCode='" + dataSourceCode + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    public Event(){

    }

    public Event(Long eventId, EventType eventType, Long arStatusId, LocalDateTime eventDate, String rootDocument, String currentDocument, String referenceDocument, String additionalReference, String dataSourceCode, String createdBy, LocalDateTime createdDate, String modifiedBy, LocalDateTime modifiedDate) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.arStatusId = arStatusId;
        this.eventDate = eventDate;
        this.rootDocument = rootDocument;
        this.currentDocument = currentDocument;
        this.referenceDocument = referenceDocument;
        this.additionalReference = additionalReference;
        this.dataSourceCode = dataSourceCode;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }
}
