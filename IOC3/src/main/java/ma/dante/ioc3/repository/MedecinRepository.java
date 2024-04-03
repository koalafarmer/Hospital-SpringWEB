package ma.dante.ioc3.repository;

import ma.dante.ioc3.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {}