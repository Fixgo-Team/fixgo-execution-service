package co.fixgo.execution.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.fixgo.execution.dto.OwnershipConfirmationRequestDto;
import co.fixgo.execution.dto.OwnershipConfirmationResponseDto;
import co.fixgo.execution.mapper.OwnershipConfirmationMapper;
import co.fixgo.execution.model.OwnershipConfirmation;
import co.fixgo.execution.repository.OwnershipConfirmationRepository;
import co.fixgo.execution.service.OwnershipConfirmationService;

@Service
public class OwnershipConfirmationServiceImpl implements OwnershipConfirmationService {

    private final OwnershipConfirmationRepository confirmationRepository;
    private final OwnershipConfirmationMapper confirmationMapper;

    public OwnershipConfirmationServiceImpl(OwnershipConfirmationRepository confirmationRepository,
            OwnershipConfirmationMapper confirmationMapper) {
        this.confirmationRepository = confirmationRepository;
        this.confirmationMapper = confirmationMapper;
    }

    @Override
    public List<OwnershipConfirmationResponseDto> findAll() {
        return confirmationMapper.toResponseDtoList(confirmationRepository.findAll());
    }

    @Override
    public OwnershipConfirmationResponseDto findByRequestId(Long requestId) {
        OwnershipConfirmation objConfirmation = confirmationRepository.findByRequestId(requestId).orElse(null);
        if (objConfirmation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "La solicitud " + requestId + " no tiene confirmacion de propiedad");
        }
        return confirmationMapper.toResponseDto(objConfirmation);
    }

    @Override
    public OwnershipConfirmationResponseDto save(OwnershipConfirmationRequestDto objRequest) {
        if (objRequest.getRequestId() == null || objRequest.getProfessionalId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "requestId y professionalId son obligatorios");
        }
        if (confirmationRepository.existsByRequestId(objRequest.getRequestId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "La solicitud " + objRequest.getRequestId() + " ya tiene confirmacion de propiedad");
        }
        OwnershipConfirmation objConfirmation = confirmationMapper.toEntity(objRequest);
        OwnershipConfirmation objSaved = confirmationRepository.save(objConfirmation);
        return confirmationMapper.toResponseDto(objSaved);
    }
}
