package co.fixgo.execution.service;

import java.util.List;

import co.fixgo.execution.dto.ServiceReportRequestDto;
import co.fixgo.execution.dto.ServiceReportResponseDto;

public interface ServiceReportService {

    List<ServiceReportResponseDto> findAll();

    ServiceReportResponseDto findById(Long id);

    List<ServiceReportResponseDto> findByRequestId(Long requestId);

    ServiceReportResponseDto findLatestByRequestId(Long requestId);

    ServiceReportResponseDto save(ServiceReportRequestDto objRequest);
}
