package co.fixgo.execution.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ownership_confirmations")
public class OwnershipConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_id", nullable = false)
    private Long requestId;

    @Column(name = "professional_id", nullable = false)
    private Long professionalId;

    @Column(name = "notes", length = 255)
    private String notes;

    @Column(name = "confirmed_at", nullable = false)
    private LocalDateTime confirmedAt;

    public OwnershipConfirmation() {
    }

    public OwnershipConfirmation(Long id, Long requestId, Long professionalId, String notes, LocalDateTime confirmedAt) {
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
