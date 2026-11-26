package co.fixgo.execution.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.fixgo.execution.model.OwnershipConfirmation;

public interface OwnershipConfirmationRepository extends JpaRepository<OwnershipConfirmation, Long> {

    Optional<OwnershipConfirmation> findByRequestId(Long requestId);

    boolean existsByRequestId(Long requestId);
}
