package co.fixgo.execution.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.fixgo.execution.dto.ServiceReportRequestDto;
import co.fixgo.execution.dto.ServiceReportResponseDto;
import co.fixgo.execution.mapper.ServiceReportMapper;
import co.fixgo.execution.model.ServiceReport;
import co.fixgo.execution.repository.ServiceReportRepository;
import co.fixgo.execution.service.ServiceReportService;

@Service
public class ServiceReportServiceImpl implements ServiceReportService {

    private static final int MAX_WARRANTY_DAYS = 365;

    private final ServiceReportRepository reportRepository;
    private final ServiceReportMapper reportMapper;

    public ServiceReportServiceImpl(ServiceReportRepository reportRepository, ServiceReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
    }

    @Override
    public List<ServiceReportResponseDto> findAll() {
        return reportMapper.toResponseDtoList(reportRepository.findAll());
    }

    @Override
    public ServiceReportResponseDto findById(Long id) {
        ServiceReport objReport = reportRepository.findById(id).orElse(null);
        if (objReport == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Informe " + id + " no encontrado");
        }
        return reportMapper.toResponseDto(objReport);
    }

    @Override
    public List<ServiceReportResponseDto> findByRequestId(Long requestId) {
        return reportMapper.toResponseDtoList(reportRepository.findByRequestIdOrderByCycleAsc(requestId));
    }

    @Override
    public ServiceReportResponseDto findLatestByRequestId(Long requestId) {
        ServiceReport objReport = reportRepository.findTopByRequestIdOrderByCycleDesc(requestId).orElse(null);
        if (objReport == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "La solicitud " + requestId + " no tiene informes");
        }
        return reportMapper.toResponseDto(objReport);
    }

    @Override
    public ServiceReportResponseDto save(ServiceReportRequestDto objRequest) {
        validate(objRequest);

        if (objRequest.getCycle() != null) {
            ServiceReport objExisting = reportRepository
                    .findByRequestIdAndCycle(objRequest.getRequestId(), objRequest.getCycle()).orElse(null);
            if (objExisting != null) {
                return reportMapper.toResponseDto(objExisting);
            }
        }

        ServiceReport objLatest = reportRepository.findTopByRequestIdOrderByCycleDesc(objRequest.getRequestId())
                .orElse(null);
        int cycle = 1;
        if (objLatest != null) {
            LocalDateTime expiresAt = objLatest.getCreatedAt().plusDays(objLatest.getWarrantyDays());
            boolean warrantyActive = objLatest.getWarrantyDays() > 0 && !LocalDateTime.now().isAfter(expiresAt);
            if (!warrantyActive) {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "La solicitud " + objRequest.getRequestId()
                                + " ya tiene informe y su garantia no esta vigente: no se puede abrir un nuevo ciclo");
            }
            cycle = objLatest.getCycle() + 1;
        }

        if (objRequest.getCycle() != null && objRequest.getCycle() != cycle) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "El ciclo esperado para la solicitud " + objRequest.getRequestId() + " es " + cycle);
        }

        ServiceReport objReport = reportMapper.toEntity(objRequest, cycle);
        ServiceReport objSaved = reportRepository.save(objReport);
        return reportMapper.toResponseDto(objSaved);
    }

    private void validate(ServiceReportRequestDto objRequest) {
        if (objRequest.getRequestId() == null || objRequest.getProfessionalId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "requestId y professionalId son obligatorios");
        }
        if (objRequest.getWorkDone() == null || objRequest.getWorkDone().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "workDone es obligatorio");
        }
        if (objRequest.getFinalValue() == null || objRequest.getFinalValue() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "finalValue es obligatorio y no puede ser negativo");
        }
        if (objRequest.getCycle() != null && objRequest.getCycle() < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cycle debe ser mayor o igual a 1");
        }
        if (objRequest.getWarrantyDays() == null || objRequest.getWarrantyDays() < 0
                || objRequest.getWarrantyDays() > MAX_WARRANTY_DAYS) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "warrantyDays debe estar entre 0 y " + MAX_WARRANTY_DAYS);
        }
    }
}
