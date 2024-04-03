package ma.dante.ioc3.repository;

import ma.dante.ioc3.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNameContains(String keyword,Pageable pageable);

}
