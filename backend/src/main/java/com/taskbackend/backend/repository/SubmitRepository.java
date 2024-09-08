package com.taskbackend.backend.repository;

import com.taskbackend.backend.model.SubmitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitRepository extends JpaRepository<SubmitModel, Long> {
}
