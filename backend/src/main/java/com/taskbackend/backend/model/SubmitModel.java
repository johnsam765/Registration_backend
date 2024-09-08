package com.taskbackend.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "t_submit")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String addressLine;
    private String city;
    private String postalCode;
}
