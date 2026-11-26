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

import co.fixgo.execution.dto.OwnershipConfirmationRequestDto;
import co.fixgo.execution.dto.OwnershipConfirmationResponseDto;
import co.fixgo.execution.service.OwnershipConfirmationService;

@RestController
@RequestMapping("/api/ownership-confirmations")
public class OwnershipConfirmationController {

    private final OwnershipConfirmationService confirmationService;

    public OwnershipConfirmationController(OwnershipConfirmationService confirmationService) {
        this.confirmationService = confirmationService;
    }

    @GetMapping
    public List<OwnershipConfirmationResponseDto> findAll() {
        return confirmationService.findAll();
    }

    @GetMapping("/request/{requestId}")
    public OwnershipConfirmationResponseDto findByRequestId(@PathVariable Long requestId) {
        return confirmationService.findByRequestId(requestId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnershipConfirmationResponseDto save(@RequestBody OwnershipConfirmationRequestDto objRequest) {
        return confirmationService.save(objRequest);
    }
}
