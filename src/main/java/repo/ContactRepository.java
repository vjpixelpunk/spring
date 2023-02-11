package repo;

import domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository  extends JpaRepository<Contact, Integer> {
@Query(nativeQuery = true, value = " select * from contact_book")
List<Contact> getAllContacts();
}
