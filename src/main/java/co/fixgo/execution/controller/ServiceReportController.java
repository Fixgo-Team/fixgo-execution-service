package co.fixgo.execution.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.fixgo.execution.dto.ServiceReportRequestDto;
import co.fixgo.execution.dto.ServiceReportResponseDto;
import co.fixgo.execution.service.ServiceReportService;

@RestController
@RequestMapping("/api/service-reports")
public class ServiceReportController {

    private final ServiceReportService reportService;

    public ServiceReportController(ServiceReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<ServiceReportResponseDto> findAll() {
        return reportService.findAll();
    }

    @GetMapping("/{id}")
    public ServiceReportResponseDto findById(@PathVariable Long id) {
        return reportService.findById(id);
    }

    @GetMapping("/request/{requestId}")
    public List<ServiceReportResponseDto> findByRequestId(@PathVariable Long requestId) {
        return reportService.findByRequestId(requestId);
    }

    @GetMapping("/request/{requestId}/latest")
    public ServiceReportResponseDto findLatestByRequestId(@PathVariable Long requestId) {
        return reportService.findLatestByRequestId(requestId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceReportResponseDto save(@RequestBody ServiceReportRequestDto objRequest) {
        return reportService.save(objRequest);
    }
}
