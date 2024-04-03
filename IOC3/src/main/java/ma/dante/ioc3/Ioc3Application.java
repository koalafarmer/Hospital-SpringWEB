package ma.dante.ioc3;

import ma.dante.ioc3.entities.Patient;
import ma.dante.ioc3.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Ioc3Application implements CommandLineRunner {
@Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ioc3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        patientRepository.save(new Patient(null,"John.F",new Date(),true,888));
        patientRepository.save(new Patient(null,"Abraham",new Date(),false,999));
        patientRepository.save(new Patient(null,"Thomas",new Date(),true,111));
        patientRepository.save(new Patient(null,"Joe",new Date(),false,444));
        patientRepository.save(new Patient(null,"Donald",new Date(),true,666));
        patientRepository.save(new Patient(null,"Barack",new Date(),false,777));


    }
}
