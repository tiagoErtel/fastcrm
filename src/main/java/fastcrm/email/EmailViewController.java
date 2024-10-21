package fastcrm.email;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailViewController {

    @Autowired
    private EmailRepository emailRepository; // Assume you have a JPA repository for Email

    // List all emails
    @GetMapping("/email")
    public String listEmails(Model model) {
        List<Email> emails = emailRepository.findAll();
        model.addAttribute("emails", emails);
        return "email-list";
    }

 // Controller method for displaying the create form
    @GetMapping("/email/new")
    public String showCreateEmailForm(Model model) {
        model.addAttribute("email", new Email());
        return "email-create";
    }

    // Controller method for handling the form submission for creating a new email
    @PostMapping("/email/create")
    public String createEmail(@ModelAttribute Email email) {
        emailRepository.save(email);  // Save new email
        return "redirect:/email";
    }

    // Controller method for displaying the edit form
    @GetMapping("/email/edit/{id}")
    public String showEditEmailForm(@PathVariable("id") Long id, Model model) {
        Email email = emailRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid email Id:" + id));
        model.addAttribute("email", email);
        return "email-edit";
    }

    // Controller method for handling the form submission for updating an email
    @PostMapping("/email/edit")
    public String updateEmail(@ModelAttribute Email email) {
        emailRepository.save(email);  // Update existing email
        return "redirect:/email";
    }

    // Delete an email
    @GetMapping("/email/delete/{id}")
    public String deleteEmail(@PathVariable("id") Long id) {
        Email email = emailRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid email Id:" + id));
        emailRepository.delete(email);
        return "redirect:/email";
    }
    
    @GetMapping("/email/preview/{id}")
    @ResponseBody
    public String previewEmailBody(@PathVariable("id") Long id) {
        Email email = emailRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid email Id:" + id));
        
        // Return the email body directly as HTML (since the modal will display it)
        return email.getBody();
    }

}
