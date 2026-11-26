package co.fixgo.execution.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.fixgo.execution.dto.ServiceReportRequestDto;
import co.fixgo.execution.dto.ServiceReportResponseDto;
import co.fixgo.execution.model.ServiceReport;

@Component
public class ServiceReportMapper {

    public ServiceReport toEntity(ServiceReportRequestDto objRequest, Integer cycle) {
        ServiceReport objReport = new ServiceReport();
        objReport.setRequestId(objRequest.getRequestId());
        objReport.setProfessionalId(objRequest.getProfessionalId());
        objReport.setCycle(cycle);
        objReport.setWorkDone(objRequest.getWorkDone().trim());
        objReport.setMaterials(objRequest.getMaterials());
        objReport.setFinalValue(objRequest.getFinalValue());
        objReport.setWarrantyDays(objRequest.getWarrantyDays());
        objReport.setCreatedAt(LocalDateTime.now());
        return objReport;
    }

    public ServiceReportResponseDto toResponseDto(ServiceReport objReport) {
        LocalDateTime expiresAt = objReport.getCreatedAt().plusDays(objReport.getWarrantyDays());
        boolean active = objReport.getWarrantyDays() > 0 && !LocalDateTime.now().isAfter(expiresAt);
        return new ServiceReportResponseDto(
                objReport.getId(),
                objReport.getRequestId(),
                objReport.getProfessionalId(),
                objReport.getCycle(),
                objReport.getWorkDone(),
                objReport.getMaterials(),
                objReport.getFinalValue(),
                objReport.getWarrantyDays(),
                objReport.getCreatedAt(),
                expiresAt,
                active);
    }

    public List<ServiceReportResponseDto> toResponseDtoList(List<ServiceReport> objReports) {
        List<ServiceReportResponseDto> objList = new ArrayList<>();
        for (ServiceReport objReport : objReports) {
            objList.add(toResponseDto(objReport));
        }
        return objList;
    }
}
