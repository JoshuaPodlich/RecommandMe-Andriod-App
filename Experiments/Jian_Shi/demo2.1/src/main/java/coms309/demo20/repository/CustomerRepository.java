package coms309.demo20.repository;

import coms309.demo20.model.CustomerContact;
import coms309.demo20.model.MailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerContact, Long> {
}
