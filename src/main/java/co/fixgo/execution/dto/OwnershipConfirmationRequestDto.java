package co.fixgo.execution.dto;

public class OwnershipConfirmationRequestDto {

    private Long requestId;

    private Long professionalId;

    private String notes;

    public OwnershipConfirmationRequestDto() {
    }

    public OwnershipConfirmationRequestDto(Long requestId, Long professionalId, String notes) {
        this.requestId = requestId;
        this.professionalId = professionalId;
        this.notes = notes;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
