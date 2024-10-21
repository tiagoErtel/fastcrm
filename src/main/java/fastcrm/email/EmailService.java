package fastcrm.email;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fastcrm.customer.Customer;
import fastcrm.customer.CustomerRepository;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
	
	public List<Email> findAll(){
		return emailRepository.findAll();
	}
	
	public void create(Email email) {
		emailRepository.save(email);
	}
	
	public Optional<Email> findById(Long id) {
		return emailRepository.findById(id);
	}
	
	public void delete(Email email) {
		emailRepository.delete(email);
	}
	
    public void sendHtmlEmail(Long idEmail) throws MessagingException {
    	Optional<Email> email = emailRepository.findById(idEmail);
    	
    	List<Customer> customers = customerRepository.findAll();
    
        
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props,
                new Authenticator() {
                   protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication("erteltiago0@gmail.com", "emdg pfxm dlir dydv");
                   }
       	});
    	
    	if (email.isPresent()) {
    		for (Customer customer : customers) {

    			Message message = new MimeMessage(session);
    			message.setFrom(new InternetAddress("erteltiago0@gmail.com"));
			    message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse(customer.getEmail()));
			    message.setSubject(email.get().getSubject());
				message.setContent(email.get().getBody().replace("${customerName}", customer.getName()), "text/html");
				
				Transport.send(message);
    		}
    	}
    }
}
