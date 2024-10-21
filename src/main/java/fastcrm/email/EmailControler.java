package fastcrm.email;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("api/email")
public class EmailControler {

    @Autowired
    private EmailService emailService;
	
	@GetMapping("")
	List<Email> findAll(){
		return emailService.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	void create(@RequestBody Email email) {
		emailService.create(email);
	}
	
	@PostMapping("send/{id}")
	String sendEmail(@PathVariable Long id) {
		try {
			emailService.sendHtmlEmail(id);
			return "Email enviado";
		} catch(MessagingException ex) {
			return "Não deu: " + ex.getMessage();
		}
	}
}