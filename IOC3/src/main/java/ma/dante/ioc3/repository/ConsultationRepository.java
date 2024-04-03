package ma.dante.ioc3.repository;

import ma.dante.ioc3.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {}
