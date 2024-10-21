package fastcrm.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("emails", emailRepository.findAll());
        return "home";
    }

	@PostMapping("/send-email")
	public String sendEmail(@RequestParam("emailId") Long emailId, RedirectAttributes redirectAttributes) {
	    try {
	        emailService.sendHtmlEmail(emailId);
	        redirectAttributes.addFlashAttribute("message", "Email sent successfully!");
	    } catch (MessagingException e) {
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("error", "Failed to send email.");
	    }
	    return "redirect:/";
	}
}
