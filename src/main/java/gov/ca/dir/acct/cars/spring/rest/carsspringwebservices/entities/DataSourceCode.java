package gov.ca.dir.acct.cars.spring.rest.carsspringwebservices.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="data_source")
public class DataSourceCode {

    @Id
    @Column(name = "data_source_code")
    private String dataSourceCode;

    @Column(name = "description")
    private String description;

    @Column(name = "effective_start_date")
    private LocalDateTime effectiveStartDate;

    @Column(name = "effective_end_date")
    private LocalDateTime effectiveEndDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
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
        DataSourceCode that = (DataSourceCode) o;
        return Objects.equals(dataSourceCode, that.dataSourceCode) &&
                Objects.equals(description, that.description) &&
                Objects.equals(effectiveStartDate, that.effectiveStartDate) &&
                Objects.equals(effectiveEndDate, that.effectiveEndDate) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(modifiedBy, that.modifiedBy) &&
                Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataSourceCode, description, effectiveStartDate, effectiveEndDate, createdBy, createdDate, modifiedBy, modifiedDate);
    }

    @Override
    public String toString() {
        return "DataSourceCode{" +
                "dataSourceCode='" + dataSourceCode + '\'' +
                ", description='" + description + '\'' +
                ", effectiveStartDate=" + effectiveStartDate +
                ", effectiveEndDate=" + effectiveEndDate +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
