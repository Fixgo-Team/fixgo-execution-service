package co.fixgo.execution.dto;

import java.time.LocalDateTime;

public class ServiceReportResponseDto {

    private Long id;

    private Long requestId;

    private Long professionalId;

    private Integer cycle;

    private String workDone;

    private String materials;

    private Double finalValue;

    private Integer warrantyDays;

    private LocalDateTime createdAt;

    private LocalDateTime warrantyExpiresAt;

    private Boolean warrantyActive;

    public ServiceReportResponseDto() {
    }

    public ServiceReportResponseDto(Long id, Long requestId, Long professionalId, Integer cycle, String workDone, String materials, Double finalValue, Integer warrantyDays, LocalDateTime createdAt, LocalDateTime warrantyExpiresAt, Boolean warrantyActive) {
        this.id = id;
        this.requestId = requestId;
        this.professionalId = professionalId;
        this.cycle = cycle;
        this.workDone = workDone;
        this.materials = materials;
        this.finalValue = finalValue;
        this.warrantyDays = warrantyDays;
        this.createdAt = createdAt;
        this.warrantyExpiresAt = warrantyExpiresAt;
        this.warrantyActive = warrantyActive;
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

    public LocalDateTime getWarrantyExpiresAt() {
        return warrantyExpiresAt;
    }

    public void setWarrantyExpiresAt(LocalDateTime warrantyExpiresAt) {
        this.warrantyExpiresAt = warrantyExpiresAt;
    }

    public Boolean getWarrantyActive() {
        return warrantyActive;
    }

    public void setWarrantyActive(Boolean warrantyActive) {
        this.warrantyActive = warrantyActive;
    }
}
