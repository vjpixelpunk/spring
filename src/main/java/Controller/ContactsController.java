package Controller;

import ContactService.ContactService;
import domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactsController {
    @Autowired
    ContactService  contactService;
@GetMapping("/allContact")
  private List<Contact>getAllContacts(){

      return ContactService.getAllContacts();
  }
@GetMapping("/contact/{id}")
  private Contact getContact(@PathVariable("id") int id){

    return ContactService.getContactById(id);
  }
@PostMapping("/contact")
private int addContact(@RequestBody Contact contact){

    ContactService.saveOrUpdate(contact);
    return contact.getId();
}
@PutMapping("/contact")
 private Contact update(@RequestBody Contact contact){

    ContactService.saveOrUpdate(contact);
    return contact;
 }

}
