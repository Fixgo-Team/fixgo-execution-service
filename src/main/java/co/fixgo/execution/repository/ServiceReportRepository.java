package co.fixgo.execution.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.fixgo.execution.model.ServiceReport;

public interface ServiceReportRepository extends JpaRepository<ServiceReport, Long> {

    List<ServiceReport> findByRequestIdOrderByCycleAsc(Long requestId);

    Optional<ServiceReport> findTopByRequestIdOrderByCycleDesc(Long requestId);

    Optional<ServiceReport> findByRequestIdAndCycle(Long requestId, Integer cycle);
}
