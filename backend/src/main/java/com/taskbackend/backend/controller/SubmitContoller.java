package com.taskbackend.backend.controller;
import com.taskbackend.backend.dto.SubmitRequest;
import com.taskbackend.backend.service.SubmitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SubmitContoller {

private final SubmitService submitService;

    @PostMapping("/submit")
    public ResponseEntity<String> intakeSubmit(@RequestBody SubmitRequest submitRequest) {
        log.info("RequestBody {}", submitRequest);
        submitService.intakeSubmit(submitRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"success\":\"true\"}");
    }

    @PostMapping("/validatePostalCode")
    public ResponseEntity<Void> validatePostalCode(@RequestBody String postalCode) {
        return submitService.isValidPostalCode(postalCode) ?
                ResponseEntity.ok().build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
