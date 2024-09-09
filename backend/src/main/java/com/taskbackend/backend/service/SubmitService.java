package com.taskbackend.backend.service;
import com.taskbackend.backend.dto.SubmitRequest;
import com.taskbackend.backend.model.SubmitModel;
import com.taskbackend.backend.repository.SubmitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubmitService {
    private final SubmitRepository submitRepository;
    public void intakeSubmit(SubmitRequest submitRequest) {
        log.info("RequestBody {}", submitRequest);
        SubmitModel submission = SubmitModel.builder()
                .firstName(submitRequest.getFirstName())
                .lastName(submitRequest.getLastName())
                .addressLine(submitRequest.getAddress().getAddressLine())
                .city(submitRequest.getAddress().getCity())
                .postalCode(submitRequest.getAddress().getPostalCode())
                .build();
        submitRepository.save(submission);
    }
    public boolean isValidPostalCode(String postalCode) {
        String postalCodePattern = "^[MLN][0-9][A-Za-z][0-9][A-Za-z][0-9]$";
        return postalCode != null && postalCode.matches(postalCodePattern);
    }
}
