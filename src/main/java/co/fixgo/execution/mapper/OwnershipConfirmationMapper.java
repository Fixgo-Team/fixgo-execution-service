package co.fixgo.execution.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.fixgo.execution.dto.OwnershipConfirmationRequestDto;
import co.fixgo.execution.dto.OwnershipConfirmationResponseDto;
import co.fixgo.execution.model.OwnershipConfirmation;

@Component
public class OwnershipConfirmationMapper {

    public OwnershipConfirmation toEntity(OwnershipConfirmationRequestDto objRequest) {
        OwnershipConfirmation objConfirmation = new OwnershipConfirmation();
        objConfirmation.setRequestId(objRequest.getRequestId());
        objConfirmation.setProfessionalId(objRequest.getProfessionalId());
        objConfirmation.setNotes(objRequest.getNotes());
        objConfirmation.setConfirmedAt(LocalDateTime.now());
        return objConfirmation;
    }

    public OwnershipConfirmationResponseDto toResponseDto(OwnershipConfirmation objConfirmation) {
        return new OwnershipConfirmationResponseDto(
                objConfirmation.getId(),
                objConfirmation.getRequestId(),
                objConfirmation.getProfessionalId(),
                objConfirmation.getNotes(),
                objConfirmation.getConfirmedAt());
    }

    public List<OwnershipConfirmationResponseDto> toResponseDtoList(List<OwnershipConfirmation> objConfirmations) {
        List<OwnershipConfirmationResponseDto> objList = new ArrayList<>();
        for (OwnershipConfirmation objConfirmation : objConfirmations) {
            objList.add(toResponseDto(objConfirmation));
        }
        return objList;
    }
}
