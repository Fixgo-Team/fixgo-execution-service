package co.fixgo.execution.dto;

import java.time.LocalDateTime;

public class OwnershipConfirmationResponseDto {

    private Long id;

    private Long requestId;

    private Long professionalId;

    private String notes;

    private LocalDateTime confirmedAt;

    public OwnershipConfirmationResponseDto() {
    }

    public OwnershipConfirmationResponseDto(Long id, Long requestId, Long professionalId, String notes, LocalDateTime confirmedAt) {
        this.id = id;
        this.requestId = requestId;
        this.professionalId = professionalId;
        this.notes = notes;
        this.confirmedAt = confirmedAt;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(LocalDateTime confirmedAt) {
        this.confirmedAt = confirmedAt;
    }
}
