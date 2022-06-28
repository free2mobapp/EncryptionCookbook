package uk.co.ksb.EncryptionCookbook;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployerRepository extends CrudRepository<Employer, Long> {

    public List<Employer> findAll();
}
