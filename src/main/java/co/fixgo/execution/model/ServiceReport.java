package co.fixgo.execution.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_reports")
public class ServiceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_id", nullable = false)
    private Long requestId;

    @Column(name = "professional_id", nullable = false)
    private Long professionalId;

    @Column(name = "cycle", nullable = false)
    private Integer cycle;

    @Column(name = "work_done", nullable = false, length = 1000)
    private String workDone;

    @Column(name = "materials", length = 500)
    private String materials;

    @Column(name = "final_value", nullable = false)
    private Double finalValue;

    @Column(name = "warranty_days", nullable = false)
    private Integer warrantyDays;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ServiceReport() {
    }

    public ServiceReport(Long id, Long requestId, Long professionalId, Integer cycle, String workDone, String materials, Double finalValue, Integer warrantyDays, LocalDateTime createdAt) {
        this.id = id;
        this.requestId = requestId;
        this.professionalId = professionalId;
        this.cycle = cycle;
        this.workDone = workDone;
        this.materials = materials;
        this.finalValue = finalValue;
        this.warrantyDays = warrantyDays;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getWorkDone() {
        return workDone;
    }

    public void setWorkDone(String workDone) {
        this.workDone = workDone;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public Double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(Double finalValue) {
        this.finalValue = finalValue;
    }

    public Integer getWarrantyDays() {
        return warrantyDays;
    }

    public void setWarrantyDays(Integer warrantyDays) {
        this.warrantyDays = warrantyDays;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
