package fastcrm.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
	List<Customer> findAll(){
		return customerRepository.findAll();
	}
	
	void create(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}
}
