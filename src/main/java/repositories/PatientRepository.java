package repositories;

import entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {

    public Patient findByFirstName(String firstName);
    public List<Patient> findByLastName(String lastName);

}
