package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name="event_type")
public class EventType {
    @Id
    @Column(name = "event_type_id")
    private Long eventTypeId;

    @Column(name = "program_unit_code")
    private String programUnitCode;

    @Column(name = "event_type_code")
    private String eventTypeCode;

    @Column(name = "event_type_name")
    private String eventTypeName;

    @Column(name = "description")
    private String description;

    @Column(name = "effective_start_date")
    private LocalDateTime effectiveStartDate;

    @Column(name = "effective_end_date")
    private LocalDateTime effectiveEndDate;

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

    public Long getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getProgramUnitCode() {
        return programUnitCode;
    }

    public void setProgramUnitCode(String programUnitCode) {
        this.programUnitCode = programUnitCode;
    }

    public String getEventTypeCode() {
        return eventTypeCode;
    }

    public void setEventTypeCode(String eventTypeCode) {
        this.eventTypeCode = eventTypeCode;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEffectiveStartDate() {
        return effectiveStartDate;
    }

    public void setEffectiveStartDate(LocalDateTime effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    public LocalDateTime getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(LocalDateTime effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventType eventType = (EventType) o;
        return Objects.equals(eventTypeId, eventType.eventTypeId) &&
                Objects.equals(programUnitCode, eventType.programUnitCode) &&
                Objects.equals(eventTypeCode, eventType.eventTypeCode) &&
                Objects.equals(eventTypeName, eventType.eventTypeName) &&
                Objects.equals(description, eventType.description) &&
                Objects.equals(effectiveStartDate, eventType.effectiveStartDate) &&
                Objects.equals(effectiveEndDate, eventType.effectiveEndDate) &&
                Objects.equals(dataSourceCode, eventType.dataSourceCode) &&
                Objects.equals(createdBy, eventType.createdBy) &&
                Objects.equals(createdDate, eventType.createdDate) &&
                Objects.equals(modifiedBy, eventType.modifiedBy) &&
                Objects.equals(modifiedDate, eventType.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventTypeId, programUnitCode, eventTypeCode, eventTypeName, description, effectiveStartDate, effectiveEndDate, dataSourceCode, createdBy, createdDate, modifiedBy, modifiedDate);
    }


    public EventType(){

    }
    public EventType(Long eventTypeId, String programUnitCode, String eventTypeCode, String eventTypeName, String description, LocalDateTime effectiveStartDate, LocalDateTime effectiveEndDate, String dataSourceCode, String createdBy, LocalDateTime createdDate, String modifiedBy, LocalDateTime modifiedDate) {
        this.eventTypeId = eventTypeId;
        this.programUnitCode = programUnitCode;
        this.eventTypeCode = eventTypeCode;
        this.eventTypeName = eventTypeName;
        this.description = description;
        this.effectiveStartDate = effectiveStartDate;
        this.effectiveEndDate = effectiveEndDate;
        this.dataSourceCode = dataSourceCode;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }
}
