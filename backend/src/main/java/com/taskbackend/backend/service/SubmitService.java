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
    private static final List<String> VALID_POSTAL_CODES = Arrays.asList(
            "M1G3T1", "L8M1J6", "M4B1B3", "K1A0B1", "H2X1Y4",
            "V5K0A1", "R3C4L9", "S7K3T2", "T5J3N5", "B3J1P3",
            "C1A1A9", "E2L3Z8"
    );

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
        return VALID_POSTAL_CODES.contains(postalCode);
    }
}
