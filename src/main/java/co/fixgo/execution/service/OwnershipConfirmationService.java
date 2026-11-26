package co.fixgo.execution.service;

import java.util.List;

import co.fixgo.execution.dto.OwnershipConfirmationRequestDto;
import co.fixgo.execution.dto.OwnershipConfirmationResponseDto;

public interface OwnershipConfirmationService {

    List<OwnershipConfirmationResponseDto> findAll();

    OwnershipConfirmationResponseDto findByRequestId(Long requestId);

    OwnershipConfirmationResponseDto save(OwnershipConfirmationRequestDto objRequest);
}
