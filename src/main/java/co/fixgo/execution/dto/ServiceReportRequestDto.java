package co.fixgo.execution.dto;

public class ServiceReportRequestDto {

    private Long requestId;

    private Long professionalId;

    private String workDone;

    private String materials;

    private Double finalValue;

    private Integer warrantyDays;

    private Integer cycle;

    public ServiceReportRequestDto() {
    }

    public ServiceReportRequestDto(Long requestId, Long professionalId, String workDone, String materials, Double finalValue, Integer warrantyDays) {
        this.requestId = requestId;
        this.professionalId = professionalId;
        this.workDone = workDone;
        this.materials = materials;
        this.finalValue = finalValue;
        this.warrantyDays = warrantyDays;
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

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }
}
