package ContactService;

import lombok.extern.slf4j.Slf4j;
import domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ContactRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ContactService {
    @Autowired
    static
    ContactRepository contactRepository;

    public static List<Contact> getAllContacts()
        {
        List<Contact> contact = new ArrayList<Contact>();
        contactRepository.findAll().forEach(contact1 -> contact.add(contact1));
        return contact;

    }

    public static Contact getContactById(int id) {
        return contactRepository.findById(id).get();
    }

    public static void saveOrUpdate(Contact contact) {
        contactRepository.save(contact);
    }

    public void delete(int id){
        contactRepository.deleteById(id);
    }

    public void update(Contact contact, int id){
        contactRepository.save(contact);
    }

}
