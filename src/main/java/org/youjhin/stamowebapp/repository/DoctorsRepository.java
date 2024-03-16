package org.youjhin.stamowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youjhin.stamowebapp.models.Doctors;

import java.util.Optional;

public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
    Optional<Doctors> findByUsername(String username);
}
