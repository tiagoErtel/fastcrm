package fastcrm.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fastcrm.customer.CustomerRepository;
import fastcrm.email.EmailRepository;
import fastcrm.email.EmailService;
import jakarta.mail.MessagingException;

@Controller
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("emails", emailRepository.findAll());
        return "home";
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam("emailId") Long emailId) {
        try {
			emailService.sendHtmlEmail(emailId);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/?success";
    }
}
